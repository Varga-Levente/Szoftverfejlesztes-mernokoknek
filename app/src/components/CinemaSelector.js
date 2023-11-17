import React, { useState } from 'react';
import './CinemaSelector.css';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faCaretDown } from '@fortawesome/free-solid-svg-icons';

const CinemaSelector = () => {
    const [selectedCity, setSelectedCity] = useState('Debrecen');

    const toggleDropdown = (city) => {
        setSelectedCity(city);
        const dropdown = document.querySelector('.dropdown');
        dropdown.classList.toggle('open');
    }

    document.addEventListener('click', function (event) {
        const dropdown = document.querySelector('.dropdown');
        if (!dropdown.contains(event.target)) {
            dropdown.classList.remove('open');
        }
    });

    return (
        <div className="costomselect">
            <div className="container">
                <div className="row">
                    <div className="col-sm-10 col-md-10 col-xxl-10">
                        <div className="row">
                            <div className="col-xxl-12"><span className="choosecinema">Choose Cinema</span></div>
                        </div>
                        <div className="row">
                            <div className="col"><span className="cityname">{selectedCity}</span></div>
                        </div>
                    </div>
                    <div className="col-sm-2 col-md-2 col-xxl-2 d-flex arrowcontainer">
                        <div className="dropdown">
                            <button className="btn btn_cinema" onClick={() => toggleDropdown(selectedCity)}>
                                <FontAwesomeIcon icon={faCaretDown} className="selectarrow" />
                            </button>
                            <div className="dropdown-content" id="dropdownContent">
                                <a href={"/#"} onClick={() => toggleDropdown('Szeged')}>Szeged</a>
                                <a href={"/#"} onClick={() => toggleDropdown('Debrecen')}>Debrecen</a>
                                <a href={"/#"} onClick={() => toggleDropdown('Budapest')}>Budapest</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default CinemaSelector;
