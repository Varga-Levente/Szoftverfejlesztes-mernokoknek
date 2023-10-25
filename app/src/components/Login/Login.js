import React, { useState, useEffect } from 'react';
import './Login.css';
import axios from 'axios';
import Swal from 'sweetalert2';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import {faSignOutAlt, faTimes, faUserLock} from "@fortawesome/free-solid-svg-icons";

const Login = () => {

    //If ?message=registered is in the URL, show a success message
    useEffect(() => {
        if (window.location.search.includes('message=registered')) {
            Swal.fire({
                icon: 'success',
                title: 'Registration successful',
                text: 'You can now log in!',
            });
        }
    }, []);

    const [formData, setFormData] = useState({
        username: '',
        password: '',
    });
    const [userData, setUserData] = useState(JSON.parse(localStorage.getItem('user')) || null);

    const handleChange = (e) => {
        const { name, value } = e.target;
        setFormData({
            ...formData,
            [name]: value,
        });
    };

    const Toast = Swal.mixin({
        toast: true,
        position: 'top-end',
        showConfirmButton: false,
        timer: 3000,
        timerProgressBar: true,
        didOpen: (toast) => {
            toast.addEventListener('mouseenter', Swal.stopTimer);
            toast.addEventListener('mouseleave', Swal.resumeTimer);
        }
    });

    const handleLogout = () => {
        // Töröld a felhasználói adatokat a localStorage-ból
        localStorage.removeItem('user');
        // Töröld a felhasználói adatokat a komponens állapotából
        setUserData(null);
        Toast.fire({
            icon: 'success',
            title: 'Kijelentkezés sikeres'
        });
    };

    const handleExitButton = () => {
        // If button pressed redirect to previous page
        window.history.back();
    }

    const handleSubmit = async (e) => {
        e.preventDefault();

        try {
            const response = await axios.post('http://localhost:8080/api/v1/auth/signin', formData);

            if (response.status === 200) {
                console.log('Sikeres bejelentkezés');
                console.log(response.data);

                // Mentsd el a felhasználói adatokat a localStorage-ban
                localStorage.setItem('user', JSON.stringify(response.data));
                setUserData(response.data);

                //Clear form
                setFormData({
                    username: '',
                    password: '',
                });

                Toast.fire({
                    icon: 'success',
                    title: 'Bejelentkezés sikeres'
                });
            } else {
                Toast.fire({
                    icon: 'error',
                    title: 'Hibás felhasználónév vagy jelszó!'
                });
            }
        } catch (error) {
            Toast.fire({
                icon: 'error',
                title: 'Hiba történt a bejelentkezés során!'
            });
            console.error('Hiba történt:', error);
        }
    };

    useEffect(() => {
        // Ellenőrizd a localStorage-t a komponens betöltésekor
        const storedUser = JSON.parse(localStorage.getItem('user'));
        if (storedUser) {
            setUserData(storedUser);
        }
    }, []);

    return (
        <div className="logincontainer">
            <div>
                <button className="btn btn-primary close-button" onClick={handleExitButton} type="button">
                    <FontAwesomeIcon icon={faTimes} />
                </button>
                {userData ? (
                <button className="btn btn-primary logout-button" onClick={handleLogout} type="button">
                    <FontAwesomeIcon icon={faSignOutAlt} />
                </button>
                ) : () => {}}
            </div>
            {!userData ? (
            <form className="loginform" onSubmit={handleSubmit}>
                <div className="container">
                    <div className="row">
                        <div className="col-md-12">
                            <div className="logintop">
                                <FontAwesomeIcon icon={faUserLock} className={"usericon"} />
                                <div className="logintextcontainer">
                                    <p className="login-text">Login</p>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div className="row">
                        <div className="col-md-12">
                            <div className="input-container">
                                <input className="form-control username-input loginforminput" type="text" name="username" value={formData.username} onChange={handleChange} placeholder="USERNAME"/>
                                <input className="form-control password-input loginforminput" type="password" name="password" value={formData.password} onChange={handleChange} placeholder="PASSWORD"/>
                            </div>
                            <button className="btn btn-primary login-btn" type="submit">Login</button>
                        </div>
                    </div>
                </div>
            </form>
            ) : (
                <div className="signedindetails">
                    <h1>Bejelentkezve</h1>
                    <p><span className="dataname">ID:</span> {userData.id}</p>
                    <p><span className="dataname">FullName:</span> {userData.fullName}</p>
                    <p><span className="dataname">Username:</span> {userData.username}</p>
                    <p><span className="dataname">ProfileIMG:</span> {userData.profileImage}</p>
                    <p><span className="dataname">Email:</span> {userData.email}</p>
                    <p><span className="dataname">Roles:</span> {userData.roles.join(', ')}</p>
                    <p><span className="dataname">AccessToken:</span> {userData.accessToken}</p>
                    <p><span className="dataname">TokenType:</span> {userData.tokenType}</p>
                    <br />
                    <button className="btn btn-primary login-btn" onClick={handleLogout}>Logout</button>
                </div>
            )}
        </div>
    );
};

export default Login;