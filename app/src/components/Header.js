import React, { useState, useEffect } from 'react';
import axios from "axios";
import './Header.css';
import './CinemaSelector';
import { API_URL } from "../Config";
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faSearch, faShoppingBasket, faRightFromBracket, faTicket, faUser, faUserPlus, faUserTie } from '@fortawesome/free-solid-svg-icons';
import CinemaSelector from "./CinemaSelector";

const Header = () => {
    const [searchText, setSearchText] = useState('');
    const [user, setUser] = useState(null);
    // Use the useState hook to track the click state
    const [clicked, setClicked] = useState(false);

    useEffect(() => {
        // Check if the user is on the "localhost:3000/cart" page
        if (window.location.pathname === '/cart') {
            setClicked(true);
        }
    }, []);

    // Function to handle the click event
    const handleCartClick = () => {
        // Set the clicked state to true
        setClicked(true);
    };

    const handleSearch = async () => {
        if (searchText.trim() === '') {
            return;
        }

        try {
            const response = await axios.get(`${API_URL}/movie/getAll`);
            const movies = response.data;

            const filteredMovies = movies.filter((movie) =>
                movie.title.toLowerCase().includes(searchText.toLowerCase())
            );

            if (filteredMovies.length > 0) {
                // Ha találtunk találatokat, válaszd ki az elsőt és irányítsd át a felhasználót az /movie/{id}-ra
                const firstMatch = filteredMovies[0];
                const movieId = firstMatch.id;
                window.location.href = `/movie/${movieId}`;
            } else {
                // Ha nincs találat, irányítsd át a felhasználót a /test-re
                window.location.href = '/error?err=No%20movie%20found!';
            }
        } catch (error) {
            console.error('Hiba történt az API hívás közben:', error);
        }
    };

    const handleKeyPress = (e) => {
        if (e.key === 'Enter') {
            // Ha az Enter billentyűt lenyomják a keresőmezőben, akkor indítsd el a keresést
            handleSearch();
        }
    };

    useEffect(() => {
        // Ellenőrizd a localStorage-t a komponens betöltésekor
        const storedUser = JSON.parse(localStorage.getItem('user'));
        //If user is not null, then he is logged in
        if (storedUser) {
            setUser(storedUser);
            console.log(storedUser);
        }
    }, []);

    const handleLogout = () => {
        localStorage.removeItem('user');
        window.location.href = '/';
    }

    return (
    <div className="row fixed-top justify-content-center top-nav align-items-center" style={{ height: '90',  zIndex: '998' }}>
        <div className="col text-start col-3">
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
                value={searchText}
                onChange={(e) => setSearchText(e.target.value)}
                onKeyDown={handleKeyPress}
            />
            <button className="btn btn-primary searchbtn" type="button" onClick={handleSearch}>
                <FontAwesomeIcon icon={faSearch} style={{ fontSize: 22 }} />
            </button>
            </div>
        </div>
        <div className="col col-3">
            <div className="text-end align-middle right">
                <a href={"/cart"} onClick={handleCartClick}>
                    <FontAwesomeIcon icon={faShoppingBasket} className={clicked ? "basketicon clicked" : "basketicon"}/>
                </a>
                <a href={user ? "/profile" : "/login"}>
                    <div className="dropdown_avatar">
                        <button className=" dropbtn_avatar"><img className="avatar" alt='avatar' src={user ? "data:image/jpg;base64,"+user.profileImage : "/avatar.jpg"} /></button>
                        {user ?
                            <div className="dropdown-content_avatar">
                                <a href="/profile"><FontAwesomeIcon icon={faUser} className={"profile_icons"} />Profile</a>
                                <a href="/#"><FontAwesomeIcon icon={faTicket} className={"profile_icons"} />My Tickets</a>
                                <a onClick={handleLogout} href="/#"><FontAwesomeIcon icon={faRightFromBracket} className={"profile_icons"} />Logout</a>
                                {user.roles.includes('ROLE_ADMIN') &&
                                    <a href="/admin-movies"><FontAwesomeIcon icon={faUserTie} className={"profile_icons"} />Admin</a>
                                }
                            </div>
                            :
                            <div className="dropdown-content_avatar">
                                <a href="/login"><FontAwesomeIcon icon={faUser} className={"profile_icons"} />Login</a>
                                <a href="/register"><FontAwesomeIcon icon={faUserPlus} className={"profile_icons"} />Register</a>
                            </div>
                        }
                    </div>
                </a>
            </div>
        </div>rt

    </div>
    );
}

export default Header;
