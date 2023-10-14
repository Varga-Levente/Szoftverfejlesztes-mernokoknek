import React from 'react';
import './CinemaSelector.css';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faCaretDown } from '@fortawesome/free-solid-svg-icons';

const CinemaSelector = () => {
    return (
        <div className="costomselect">
            <div className="container">
                <div className="row">
                    <div className="col-sm-10 col-md-10 col-xxl-10">
                        <div className="row">
                            <div className="col-xxl-12"><span className="choosecinema">Choose Cinema</span></div>
                        </div>
                        <div className="row">
                            <div className="col"><span className="cityname">Debrecen</span></div>
                        </div>
                    </div>
                    <div className="col-sm-2 col-md-2 col-xxl-2 d-flex arrowcontainer">
                        <FontAwesomeIcon icon={faCaretDown} className="selectarrow" />
                    </div>
                </div>
            </div>
        </div>
    );
}

export default CinemaSelector;