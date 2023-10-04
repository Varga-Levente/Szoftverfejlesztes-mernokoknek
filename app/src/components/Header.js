import React from 'react';
import './Header.css';
import './CinemaSelector';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faSearch, faShoppingBasket } from '@fortawesome/free-solid-svg-icons';
import CinemaSelector from "./CinemaSelector"; // Hozzáadva a faCaretDown import

const Header = () => {
  return (
    <div className="row fixed-top justify-content-center top-nav align-items-center" style={{ height: 75 }}>
        <div className="col text-start col-3" style={{ height: 50 }}>
            <CinemaSelector />
        </div>
        <div className="col col-15 text-center">
            <div className="input-group">
            <span className="input-group-text searchinputpre">
                <FontAwesomeIcon icon={faSearch} style={{ color: "white" }} />
            </span>
            <input
                className="form-control searchinput"
                type="text"
                placeholder="Movie Search"
            />
            <button className="btn btn-primary searchbtn" type="button">
                <FontAwesomeIcon icon={faSearch} style={{ fontSize: 22 }} />
            </button>
            </div>
        </div>
        <div className="col col-3">
            <div className="text-end align-middle right">
                <FontAwesomeIcon icon={faShoppingBasket} className="basketicon"/>
                <img className="avatar" alt='avatar' src="avatar.jpg" />
            </div>
        </div>
    </div>
  );
}

export default Header;
