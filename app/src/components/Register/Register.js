import React, { useState } from 'react';
import './Register.css';
import Swal from 'sweetalert2';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faSignOutAlt, faTimes, faUserPlus } from '@fortawesome/free-solid-svg-icons';

const Register = () => {
    const [formData, setFormData] = useState({
        fullname: '',
        username: '',
        email: '',
        password: '',
        confirmPassword: '',
    });

    const handleChange = (e) => {
        const { name, value } = e.target;
        setFormData({ ...formData, [name]: value });
        validateInput(name, value);
        handleSignup(e);
    };

    const Toast = Swal.mixin({
        toast: true,
        position: 'top-end',
        showConfirmButton: false,
        timerProgressBar: false,
        timer: 999999,
        didOpen: (toast) => {
            toast.addEventListener('mouseenter', Swal.stopTimer);
            toast.addEventListener('mouseleave', Swal.resumeTimer);
        },
        //Prevent close on click
        allowOutsideClick: false,
        allowEscapeKey: false,
        allowEnterKey: false,
        stopKeydownPropagation: false
    });

    const validateInput = (name, value) => {
        switch (name) {
            case 'fullname':
                if (value.length < 3 || value.length > 30) {
                    Toast.close();
                    Swal.fire({
                        title: 'Full name is too short or too long.',
                        icon: 'error',
                        showConfirmButton: false,
                        timerProgressBar: false,
                        toast: true,
                        didOpen: (toast) => {
                            toast.addEventListener('mouseenter', Swal.stopTimer);
                            toast.addEventListener('mouseleave', Swal.resumeTimer);
                        },
                        position: 'top-end',
                        timer: 9000
                    });
                } else {
                    Toast.close();
                    Swal.fire({
                        title: 'Full name is valid.',
                        icon: 'success',
                        showConfirmButton: false,
                        timerProgressBar: false,
                        toast: true,
                        didOpen: (toast) => {
                            toast.addEventListener('mouseenter', Swal.stopTimer);
                            toast.addEventListener('mouseleave', Swal.resumeTimer);
                        },
                        position: 'top-end',
                        timer: 9000
                    });
                }
                break;
            case 'username':
                if (value.length < 5 || value.length > 20) {
                    Toast.close();
                    Swal.fire({
                        title: 'Username is too short or too long.',
                        icon: 'error',
                        showConfirmButton: false,
                        timerProgressBar: false,
                        toast: true,
                        didOpen: (toast) => {
                            toast.addEventListener('mouseenter', Swal.stopTimer);
                            toast.addEventListener('mouseleave', Swal.resumeTimer);
                        },
                        position: 'top-end',
                        timer: 9000
                    });
                } else {
                    // Remove the toast if it exists
                    Toast.close();
                    Swal.fire({
                        title: 'Username is valid.',
                        icon: 'success',
                        showConfirmButton: false,
                        timerProgressBar: false,
                        toast: true,
                        didOpen: (toast) => {
                            toast.addEventListener('mouseenter', Swal.stopTimer);
                            toast.addEventListener('mouseleave', Swal.resumeTimer);
                        },
                        position: 'top-end',
                        timer: 9000
                    });
                }
                break;
            case 'email':
                if (value.length > 50 || !/^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{2,4}$/.test(value)) {
                    Toast.close();
                    Swal.fire({
                        title: 'Email is too long or not valid.',
                        icon: 'error',
                        showConfirmButton: false,
                        timerProgressBar: false,
                        toast: true,
                        didOpen: (toast) => {
                            toast.addEventListener('mouseenter', Swal.stopTimer);
                            toast.addEventListener('mouseleave', Swal.resumeTimer);
                        },
                        position: 'top-end',
                        timer: 9000
                    });
                } else {
                    Toast.close();
                    Swal.fire({
                        title: 'Email is valid.',
                        icon: 'success',
                        showConfirmButton: false,
                        timerProgressBar: false,
                        toast: true,
                        didOpen: (toast) => {
                            toast.addEventListener('mouseenter', Swal.stopTimer);
                            toast.addEventListener('mouseleave', Swal.resumeTimer);
                        },
                        position: 'top-end',
                        timer: 9000
                    });
                }
                break;
            case 'password':
                if (
                    value.length < 6 ||
                    value.length > 40 ||
                    !/(?=.*[a-z]){2}(?=.*[A-Z]){2}(?=.*[0-9]){2}/.test(value)
                ) {
                    Toast.close();
                    Swal.fire({
                        title: 'Password is too short or too long or not valid.',
                        text: 'Password must contain at least 2 lowercase, 2 uppercase and 2 numeric characters.',
                        icon: 'error',
                        showConfirmButton: false,
                        timerProgressBar: false,
                        toast: true,
                        didOpen: (toast) => {
                            toast.addEventListener('mouseenter', Swal.stopTimer);
                            toast.addEventListener('mouseleave', Swal.resumeTimer);
                        },
                        position: 'top-end',
                        timer: 9000
                    });
                } else {
                    Toast.close();
                    Swal.fire({
                        title: 'Password is valid.',
                        icon: 'success',
                        showConfirmButton: false,
                        timerProgressBar: false,
                        toast: true,
                        didOpen: (toast) => {
                            toast.addEventListener('mouseenter', Swal.stopTimer);
                            toast.addEventListener('mouseleave', Swal.resumeTimer);
                        },
                        position: 'top-end',
                        timer: 9000
                    });
                }
                break;
            case 'confirmPassword':
                if (value !== formData.password) {
                    Toast.close();
                    Swal.fire({
                        title: 'Passwords do not match.',
                        icon: 'error',
                        showConfirmButton: false,
                        timerProgressBar: false,
                        toast: true,
                        didOpen: (toast) => {
                            toast.addEventListener('mouseenter', Swal.stopTimer);
                            toast.addEventListener('mouseleave', Swal.resumeTimer);
                        },
                        position: 'top-end',
                        timer: 9000
                    });
                } else {
                    // Remove the toast if it exists
                    Toast.close();
                    Swal.fire({
                        title: 'Passwords match.',
                        icon: 'success',
                        showConfirmButton: false,
                        timerProgressBar: false,
                        toast: true,
                        didOpen: (toast) => {
                            toast.addEventListener('mouseenter', Swal.stopTimer);
                            toast.addEventListener('mouseleave', Swal.resumeTimer);
                        },
                        position: 'top-end',
                        timer: 9000
                    });
                }
                break;
            default:
                break;
        }
    };

    // A függvény, amely ellenőrzi, hogy az összes mező érvényes-e
    const isFormValid = () => {
        // Ellenőrizd minden mezőt, és ha bármelyik érvénytelen, térj vissza false-szal
        if (
            formData.fullname.length < 3 || formData.fullname.length > 30 ||
            formData.username.length < 5 || formData.username.length > 20 ||
            formData.email.length > 50 || !/^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{2,4}$/.test(formData.email) ||
            formData.password.length < 6 || formData.password.length > 40 || !/(?=.*[a-z]){2}(?=.*[A-Z]){2}(?=.*[0-9]){2}/.test(formData.password) ||
            formData.confirmPassword !== formData.password
        ) {
            return false;
        }
        return true;
    };

    const handleSignup = (e) => {
        e.preventDefault();

        // Ellenőrizd, hogy az összes mező érvényes-e
        if (isFormValid()) {
            // Remove disabled attribute from button
            document.querySelector('.login-btn').removeAttribute('disabled');
            console.log('All fields are valid.');
            // Remove the toast if it exists
            Toast.close();
            Swal.fire({
                title: 'Registration successful.',
                icon: 'success',
                showConfirmButton: false,
                timerProgressBar: false,
                toast: true,
                didOpen: (toast) => {
                    toast.addEventListener('mouseenter', Swal.stopTimer);
                    toast.addEventListener('mouseleave', Swal.resumeTimer);
                },
                position: 'top-end',
                timer: 9000
            });
        }
    };

    return (
        <div className="registercontainer">
            <div>
                <button className="btn btn-primary logout-button" type="button">
                    <FontAwesomeIcon icon={faSignOutAlt} className="logouticon" />
                </button>
                <button className="btn btn-primary close-button" type="button">
                    <FontAwesomeIcon icon={faTimes} className="closeicon" />
                </button>
            </div>
            <form className="loginform" onSubmit={handleSignup}>
                <div className="container">
                    <div className="row">
                        <div className="col-md-12">
                            <div className="logintop">
                                <FontAwesomeIcon icon={faUserPlus} className="usericon" />
                                <div className="logintextcontainer">
                                    <p className="login-text">Registration</p>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div className="row">
                        <div className="col-md-12">
                            <div className="input-container">
                                <input
                                    className="form-control fullname-input"
                                    type="text"
                                    placeholder="FULL NAME"
                                    name="fullname"
                                    value={formData.fullname}
                                    onChange={handleChange}
                                />
                                <input
                                    className="form-control username-input"
                                    type="text"
                                    placeholder="USERNAME"
                                    name="username"
                                    value={formData.username}
                                    onChange={handleChange}
                                />
                                <input
                                    className="form-control email-input"
                                    type="email"
                                    placeholder="EMAIL"
                                    name="email"
                                    value={formData.email}
                                    onChange={handleChange}
                                />
                                <input
                                    className="form-control password-input"
                                    type="password"
                                    placeholder="PASSWORD"
                                    name="password"
                                    value={formData.password}
                                    onChange={handleChange}
                                />
                                <input
                                    className="form-control password-input"
                                    type="password"
                                    placeholder="CONFIRM PASSWORD"
                                    name="confirmPassword"
                                    value={formData.confirmPassword}
                                    onChange={handleChange}
                                />
                            </div>
                            <button className="btn btn-primary login-btn" type="submit" disabled>
                                SIGNUP
                            </button>
                        </div>
                    </div>
                </div>
            </form>
        </div>
    );
};

export default Register;