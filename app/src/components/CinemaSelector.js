import React, { useState } from 'react';
import './CinemaSelector.css';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faCaretDown } from '@fortawesome/free-solid-svg-icons';

const CinemaSelector = () => {
    const [cities] = useState([
        'Debrecen',
        'Budapest',
        'Szeged',
        'Pécs',
        'Miskolc',
        'Győr',
        'Székesfehérvár'
    ]);

    const [selectedCity, setSelectedCity] = useState('Debrecen');
    const [isDropdownOpen, setIsDropdownOpen] = useState(false);

    const toggleDropdown = () => {
        setIsDropdownOpen(!isDropdownOpen);
    };

    const handleCitySelect = (city) => {
        setSelectedCity(city);
        setIsDropdownOpen(false); // Bezárja a legördülő menüt, amikor várost választasz
    };

    return (
        <div className="costomselect">
            <div className="container">
                <div className="row">
                    <div className="col-sm-10 col-md-10 col-xxl-10">
                        <div className="row">
                            <div className="col-xxl-12">
                                <span className="choosecinema" onClick={toggleDropdown}>
                                    Choose Cinema
                                </span>
                            </div>
                        </div>
                        <div className="row">
                            <div className="col">
                                <span className="cityname" onClick={toggleDropdown}>
                                    {selectedCity}
                                </span>
                            </div>
                        </div>
                    </div>
                    <div className="col-sm-2 col-md-2 col-xxl-2 d-flex arrowcontainer">
                        <FontAwesomeIcon icon={faCaretDown} className={`selectarrow ${isDropdownOpen ? 'open' : ''}`} onClick={toggleDropdown} />
                    </div>
                </div>
            </div>
            {isDropdownOpen && (
                <ul>
                    {cities.map(city => (
                        <li key={city} onClick={() => handleCitySelect(city)}>{city}</li>
                    ))}
                </ul>
            )}
        </div>
    );
}

export default CinemaSelector;
