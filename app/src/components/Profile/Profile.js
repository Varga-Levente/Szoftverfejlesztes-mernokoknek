import React from 'react';
import './Profile.css';
import { faPlay, faTicket, faCreditCard, faBookOpen, faRightFromBracket, faGear, faCircleInfo, faPen } from '@fortawesome/free-solid-svg-icons';
import {FontAwesomeIcon} from "@fortawesome/react-fontawesome";
const Profile = () => {
    const handleLogout = () => {
        // localStorage-ből eltávolítjuk a 'user' kulcsot
        localStorage.removeItem('user');
        // Itt további lépéseket is végrehajthatsz a kijelentkezés után
    };
    return (
        <div className={"profile_page"}>
            <h1 className="profile">Profile</h1>
            <div className={"profile_panel"}>
                <div className={"left_side"}>
                    <div className={"upper"}>
                        <div className={"leftwall"}>
                            <img src={"/avatar.jpg"} className={"avatar_v1"} alt={"avatar"}/>
                            <a href={"/profile"} className={"links"}>
                            <div className={"option"}>
                                <FontAwesomeIcon icon={faGear} className={"option_icon"}/>
                            </div>
                            </a>
                        </div>
                        <div className={"rightwall"}>
                            <h2 className={"welcome"}>Hi! User</h2>
                            <h2 className={"welcome_v1"}>Welcome</h2>
                        </div>
                    </div>
                    <a href={"/profile"} className={"links"} onClick={handleLogout}>
                        <div className={"down"}>
                            <FontAwesomeIcon icon={faRightFromBracket} className={"prof_icons logout_icon"}/>
                            <h2 className={"text_v1"}>Logout</h2>
                        </div>
                    </a>
                </div>
                <div className={"right_side"}>
                    <a href={"/profile"} className={"links"}>
                        <div className={"my_tickets"}>
                            <FontAwesomeIcon icon={faTicket} className={"prof_icons lefticons"}/>
                            <h2 className={"text"}>My tickets</h2>
                            <FontAwesomeIcon icon={faPlay} className={"prof_icons"}/>
                        </div>
                    </a>
                    <a href={"/profile"} className={"links"}>
                        <div className={"my_credit"}>
                            <FontAwesomeIcon icon={faCreditCard} className={"prof_icons lefticons"}/>
                            <h2 className={"text"}>My credit cards</h2>
                            <FontAwesomeIcon icon={faPlay} className={"prof_icons"}/>
                        </div>
                    </a>
                    <a href={"/profile"} className={"links"}>
                        <div className={"history"}>
                            <FontAwesomeIcon icon={faBookOpen} className={"prof_icons lefticons"}/>
                            <h2 className={"text"}>History</h2>
                            <FontAwesomeIcon icon={faPlay} className={"prof_icons"}/>
                        </div>
                    </a>
                </div>
            </div>
            <div className={"foot_profile"}>
                <FontAwesomeIcon icon={faPen} className={"below_icon"}/>
                <h2 className={"below"}>Changes City</h2>
                <FontAwesomeIcon icon={faCircleInfo} className={"below_icon"}/>
                <h2 className={"below"}>About us</h2>
            </div>
        </div>
    );
}

export default Profile;
