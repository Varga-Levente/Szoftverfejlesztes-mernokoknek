import React from 'react';
import './Admin_NAV.css';
import { faHome, faBurger, faCamera, faUser } from '@fortawesome/free-solid-svg-icons';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

const Admin_NAV = () => {
    return (
        <>
            <div className="col-md-2 text-center admin-menu-item">
                <button className="btn nav-btn btn-danger">
                    <FontAwesomeIcon icon={faHome} /> Dashboard
                </button>
            </div>
            <div className="col-md-2 text-center admin-menu-item">
                <button className="btn nav-btn btn-danger btn-active">
                    <FontAwesomeIcon icon={faBurger} /> Foods
                </button>
            </div>
            <div className="col-md-2 text-center admin-menu-item">
                <button className="btn nav-btn btn-danger">
                    <FontAwesomeIcon icon={faCamera} /> Movies
                </button>
            </div>
            <div className="col-md-2 text-center admin-menu-item">
                <button className="btn nav-btn btn-danger">
                    <FontAwesomeIcon icon={faUser} /> Users
                </button>
            </div>
        </>
    );
}

export default Admin_NAV;
