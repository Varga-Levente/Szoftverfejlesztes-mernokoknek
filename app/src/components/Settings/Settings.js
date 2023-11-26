import React, {useState} from 'react';
import './Settings.css';
import {FontAwesomeIcon} from "@fortawesome/react-fontawesome";
import {faGear, faCircleArrowRight} from "@fortawesome/free-solid-svg-icons";

const Settings = () => {
    const [username, setUsername] = useState('Username');
    const [email, setEmail] = useState('username@domain.com');
    const [re_password, setAgainPassword] = useState('');
    const [new_password, setPassword] = useState('');

    const updateUsername = (value) => {
        setUsername(value);
    };
    const updateEmail = (value) => {
        setEmail(value);
    };
    const updateAgainPassword = (value) => {
        setAgainPassword(value);
    };
    const updatePassword = (value) => {
        setPassword(value);
    };

    return (
        <div className={"profile_page"}>
            <h1 className="profile">Settings</h1>
            <div className={"profile_panel_v1"}>
                <div className={"left_side_v1"}>
                    <div className={"upper"}>
                        <div className={"leftwall"}>
                            <img src={"/avatar.jpg"} className={"avatar_v1"} alt={"avatar"}/>
                            <a href={"/settings"} className={"links"}>
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
                        <div className={"bottom"}>
                            <div className={"deletion"}>
                                <h2 className={"request"}>Request account deletion</h2>
                                <FontAwesomeIcon icon={faCircleArrowRight} className={"del"}/>
                            </div>
                            <h2 className={"title_text"}>New password</h2>
                            <input type="text" id="username" className={"textbox"} name="new_password" value={new_password} onChange={(e) => updatePassword(e.target.value)}/>
                        </div>
                </div>
                <div className={"right_side_v1"}>
                    <h2 className={"title_text"}>Name</h2>
                    <input type="text" id="username" className={"textbox"} name="username" value={username} onChange={(e) => updateUsername(e.target.value)}/>
                    <h2 className={"title_text"}>Email</h2>
                    <input type="text" id="username" className={"textbox"} name="email" value={email} onChange={(e) => updateEmail(e.target.value)}/>
                    <h2 className={"title_text"}>Re-enter password</h2>
                    <input type="text" id="username" className={"textbox"} name="re_password" value={re_password} onChange={(e) => updateAgainPassword(e.target.value)}/>
                </div>
            </div>
            <div className={"foot_settings"}>
                <div className={"back"}>
                    <div className={"back_1"}>
                        <h2 className={"twowords"}>Back</h2>
                    </div>
                </div>
                <div className={"save"}>
                        <div className={"save_1"}>
                            <h2 className={"twowords"}>Save</h2>
                        </div>
                </div>
            </div>
        </div>
    );
}

export default Settings;
