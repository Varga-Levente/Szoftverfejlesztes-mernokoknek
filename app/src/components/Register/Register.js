import React, { useState } from 'react';
import './Register.css';
import {API_URL} from '../Config';
import Swal from 'sweetalert2';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faSignOutAlt, faTimes, faUserPlus } from '@fortawesome/free-solid-svg-icons';
import axios from "axios";

const Register = () => {
    const [formData, setFormData] = useState({
        fullName: '',
        username: '',
        email: '',
        password: '',
        confirmPassword: '',
    });

    const [errors, setErrors] = useState({});

    const handleInputChange = (e) => {
        const { name, value } = e.target;
        setFormData({
            ...formData,
            [name]: value,
        });
        validateField(name, value);
    };

    const validateField = (fieldName, value) => {
        const updatedErrors = { ...errors };
        switch (fieldName) {
            case 'fullName':
                updatedErrors.fullName = value.length < 3 || value.length > 30 ? 'Full name must be between 3 and 30 characters' : '';
                break;
            case 'username':
                updatedErrors.username = value.length < 5 || value.length > 20 ? 'Username must be between 5 and 20 characters' : '';
                break;
            case 'email':
                updatedErrors.email = !/^\S+@\S+\.\S+$/.test(value) || value.length > 50 ? 'Invalid email format or email is too long' : '';
                break;
            case 'password':
                updatedErrors.password = !/^(?=.*\d.*\d)(?=.*[A-Z].*[A-Z])(?=.*[a-z].*[a-z]).{6,40}$/.test(value) ? 'Password must have at least 2 uppercase, 2 lowercase, and 2 digits, and be between 6 and 40 characters' : '';
                break;
            case 'confirmPassword':
                updatedErrors.confirmPassword = value !== formData.password ? 'Passwords do not match' : '';
                break;
            default:
                break;
        }
        setErrors(updatedErrors);
    };

    const isFormValid = () => {
        return (
            formData.fullName.length >= 3 &&
            formData.username.length >= 5 &&
            formData.email.length <= 50 &&
            /^\S+@\S+\.\S+$/.test(formData.email) &&
            /^(.*\d){2}/.test(formData.password) &&
            /^(.*[A-Z]){2}/.test(formData.password) &&
            /^(.*[a-z]){2}/.test(formData.password) &&
            formData.password.length >= 6 &&
            formData.password.length <= 40 &&
            formData.password === formData.confirmPassword
        );
    };

    const handleSubmit = (e) => {
        e.preventDefault();
        if (isFormValid()) {
            //Send data to backend http://localhost:8080/api/v1/auth/signup using POST method and formData wirh axios
            //The sample body of the request is as follows:
            // {
            //     "fullName": "string",
            //     "username": "string",
            //     "email": "string",
            //     "role":["user"],
            //     "password": "string"
            // }

            //If the response is {"message": "User registered successfully!"}, redirect to login page and add get parameter message=registered
            //If the response is {"message": "Error: Username is already taken!"}, show an error message using Swal.fire() (400 status code)
            //If the response is {"message": "Error: Email is already in use!"}, show an error message using Swal.fire() (400 status code)
            //Any other response, show an error message using Swal.fire() (500 or 401 status code)

            //Create the axios request here and get the response if status code is 400, 401, or 500 get the response message and show it using Swal.fire()
            axios.post(`${API_URL}/auth/signup`, formData)
            .then((response) => {
                if (response.status === 200) {
                    window.location.href = "/login?message=registered";
                }
            })
            .catch((error) => {
                if (error.response.status === 400) {
                    Swal.fire('Error!', error.response.data.message.replace("Error: ", ""), 'error');
                } else if (error.response.status === 401) {
                    Swal.fire('Error!', error.response.data.message.replace("Error: ", ""), 'error');
                } else if (error.response.status === 500) {
                    Swal.fire('Error!', error.response.data.message.replace("Error: ", ""), 'error');
                }
            });
        } else {
            Swal.fire('Error!', 'Please fix the form errors before submitting.', 'error');
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
            <form className="loginform" onSubmit={handleSubmit}>
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
                                    className={`form-control fullname-input ${errors.fullName && 'is-invalid'}`}
                                    type="text"
                                    placeholder="FULL NAME"
                                    name="fullName"
                                    value={formData.fullName}
                                    onChange={handleInputChange}
                                />
                                {errors.fullName && <p className="error-text">{errors.fullName}</p>}
                                <input
                                    className={`form-control username-input ${errors.username && 'is-invalid'}`}
                                    type="text"
                                    placeholder="USERNAME"
                                    name="username"
                                    value={formData.username}
                                    onChange={handleInputChange}
                                />
                                {errors.username && <p className="error-text">{errors.username}</p>}
                                <input
                                    className={`form-control email-input ${errors.email && 'is-invalid'}`}
                                    type="email"
                                    placeholder="EMAIL"
                                    name="email"
                                    value={formData.email}
                                    onChange={handleInputChange}
                                />
                                {errors.email && <p className="error-text">{errors.email}</p>}
                                <input
                                    className={`form-control password-input ${errors.password && 'is-invalid'}`}
                                    type="password"
                                    placeholder="PASSWORD"
                                    name="password"
                                    value={formData.password}
                                    onChange={handleInputChange}
                                />
                                {errors.password && <p className="error-text">{errors.password}</p>}
                                <input
                                    className={`form-control password-input ${errors.confirmPassword && 'is-invalid'}`}
                                    type="password"
                                    placeholder="CONFIRM PASSWORD"
                                    name="confirmPassword"
                                    value={formData.confirmPassword}
                                    onChange={handleInputChange}
                                />
                                {errors.confirmPassword && <p className="error-text">{errors.confirmPassword}</p>}
                            </div>
                            <button className="btn btn-primary login-btn" type="submit" disabled={!isFormValid()}>
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