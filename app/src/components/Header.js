import React from 'react';
import './Header.css';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faAngleDown, faSearch, faShoppingBasket } from '@fortawesome/free-solid-svg-icons'; // Hozzáadva a faCaretDown import

const Header = () => {
  return (
    <div className="row justify-content-center align-items-center" style={{ height: 75 }}>
        <div className="col text-start col-2" style={{ height: 50 }}>
            <div className="custom-select">
            <span className="select-text">Choose cinema</span>
            <select>
                <option value="">Debrecen</option>
            </select>
            <div className="select-arrow">
                <FontAwesomeIcon icon={faAngleDown} className="fasangledown" style={{color: "#F74346"}}/>
            </div>
            </div>
        </div>
        <div className="col text-center">
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
        <div className="col col-2">
            <div className="text-end align-middle right">
                <FontAwesomeIcon icon={faShoppingBasket} className="basketicon"/>
                <img className="avatar" alt='avatar' src="avatar.jpg" />
            </div>
        </div>
    </div>
  );
}

export default Header;
