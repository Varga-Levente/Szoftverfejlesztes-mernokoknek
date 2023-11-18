import React from 'react';
import './Profile.css';
const Profile = () => {
    return (
        <div className={"profile_page"}>
            <h1 className="profile">Profile</h1>
            <div className={"profile_panel"}>
                <div className={"left_side"}>
                    <img src={"/avatar.jpg"} className={"avatar_v1"} alt={"avatar"}/>
                </div>
                <div className={"right_side"}>
                    <div className={"my_tickets"}>
                        <div className={"ticket"}>
                            <h2>My Tickets</h2>
                        </div>
                    </div>
                    <div className={"my_credit"}>

                    </div>
                    <div className={"history"}>

                    </div>
                </div>
            </div>
        </div>
    );
}

export default Profile;
