import React from 'react';
import { useLocation } from 'react-router-dom';
import './AdminNav.css';
import { faHome, faBurger, faCamera, faUser } from '@fortawesome/free-solid-svg-icons';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

const AdminNav = () => {
    const location = useLocation();

    const handleNavigation = (path) => {
        //redirect to path
        window.location.href = `/admin-${path}`;
    };

    const getActiveClass = (path) => {
        return location.pathname === `/admin-${path}` ? 'btn-active' : '';
    };

    return (
        <>
            <div className={`col-md-2 text-center admin-menu-item`}>
                <button
                    onClick={() => handleNavigation('dashboard')}
                    className={`btn nav-btn btn-danger ${getActiveClass('dashboard')}`}
                >
                    <FontAwesomeIcon icon={faHome} /> Dashboard
                </button>
            </div>
            <div className={`col-md-2 text-center admin-menu-item`}>
                <button
                    onClick={() => handleNavigation('foods')}
                    className={`btn nav-btn btn-danger ${getActiveClass('foods')}`}
                >
                    <FontAwesomeIcon icon={faBurger} /> Foods
                </button>
            </div>
            <div className={`col-md-2 text-center admin-menu-item`}>
                <button
                    onClick={() => handleNavigation('movies')}
                    className={`btn nav-btn btn-danger ${getActiveClass('movies')}`}
                >
                    <FontAwesomeIcon icon={faCamera} /> Movies
                </button>
            </div>
            <div className={`col-md-2 text-center admin-menu-item`}>
                <button
                    onClick={() => handleNavigation('users')}
                    className={`btn nav-btn btn-danger ${getActiveClass('users')}`}
                >
                    <FontAwesomeIcon icon={faUser} /> Users
                </button>
            </div>
        </>
    );
}

export default AdminNav;
