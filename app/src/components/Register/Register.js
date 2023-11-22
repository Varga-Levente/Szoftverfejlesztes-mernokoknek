import React, { useState } from 'react';
import './Register.css';
import {API_URL} from '../../Config';
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

    const [imageData, setImageData] = useState('');

    const [errors, setErrors] = useState({});

    const handleInputChange = (e) => {
        const { name, value } = e.target;
        setFormData({
            ...formData,
            [name]: value,
        });
        validateField(name, value);
    };

    const handleProfilePictureChange = async (e) => {
        const file = e.target.files[0];
        const reader = new FileReader();

        reader.onloadend = () => {
            const base64String = reader.result.split(',')[1];
            setImageData(base64String);
        };
        //Create a simplified file url
        await reader.readAsDataURL(file);
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
                                    className={`regforminput form-control fullname-input ${errors.fullName && 'is-invalid'}`}
                                    type="text"
                                    placeholder="FULL NAME"
                                    name="fullName"
                                    value={formData.fullName}
                                    onChange={handleInputChange}
                                />
                                {errors.fullName && <p className="error-text">{errors.fullName}</p>}
                                <input
                                    className={`regforminput form-control username-input ${errors.username && 'is-invalid'}`}
                                    type="text"
                                    placeholder="USERNAME"
                                    name="username"
                                    value={formData.username}
                                    onChange={handleInputChange}
                                />
                                {errors.username && <p className="error-text">{errors.username}</p>}
                                <input
                                    className={`regforminput form-control email-input ${errors.email && 'is-invalid'}`}
                                    type="email"
                                    placeholder="EMAIL"
                                    name="email"
                                    value={formData.email}
                                    onChange={handleInputChange}
                                />
                                {errors.email && <p className="error-text">{errors.email}</p>}
                                <input
                                    className={`regforminput form-control password-input ${errors.password && 'is-invalid'}`}
                                    type="password"
                                    placeholder="PASSWORD"
                                    name="password"
                                    value={formData.password}
                                    onChange={handleInputChange}
                                />
                                {errors.password && <p className="error-text">{errors.password}</p>}
                                <input
                                    className={`regforminput form-control password-input ${errors.confirmPassword && 'is-invalid'}`}
                                    type="password"
                                    placeholder="CONFIRM PASSWORD"
                                    name="confirmPassword"
                                    value={formData.confirmPassword}
                                    onChange={handleInputChange}
                                />
                                {errors.confirmPassword && <p className="error-text">{errors.confirmPassword}</p>}
                                <input
                                    className="regforminput form-control"
                                    type="file"
                                    placeholder="PROFILE PICTURE"
                                    name="profilePicture"
                                    onChange={handleProfilePictureChange}
                                />
                            </div>
                            <button className="btn btn-primary login-btn" type="submit" disabled={!isFormValid()}>
                                SIGNUP
                            </button>
                            {imageData && (
                                <div>
                                    <h2>Uploaded Image:</h2>
                                    <img src={`data:image/jpg;base64,${imageData}`} alt="Uploaded" style={{ maxWidth: '100%' }} />
                                </div>
                            )}
                        </div>
                    </div>
                </div>
            </form>
        </div>
    );
};

export default Register;