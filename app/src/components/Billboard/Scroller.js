import React, { useState, useEffect } from 'react';
import axios from 'axios';
import './Scroller.css';
import Poster from './Poster';

const Scroller = ({ category, endpoint }) => {
    const [movies, setMovies] = useState([]);

    //Split category on the first space and store it in category1 and category2
    let category1 = category;
    let category2 = "";
    if (category.includes(" ")) {
        category1 = category.split(" ")[0];
        //Category 2 is the rest of the string after the first space
        category2 = category.substring(category.indexOf(" ") + 1);
    }

    useEffect(() => {
        // Az API hívás elkészítése és az adatok lekérése
        axios
            .get(endpoint)
            .then((response) => {
                const movieData = response.data;
                console.log('API hívás eredménye:', movieData);
                setMovies(movieData);
            })
            .catch((error) => {
                console.error('API hívás sikertelen:', error);
            });
    }, [endpoint]); // [] üres tömb, hogy az useEffect csak egyszer fusson le

    return (
        <div className="scroller-container">
            <h2 className="scroller-category">{category1}<sup className="category-sup"> {category2}</sup></h2>
            <div className="d-flex flex-nowrap overflow-x-auto scroll-div">
                {movies.map((movie) => (
                <Poster title={movie.title} posterPath={movie.poster_path} key={movie.id} />
                ))}
            </div>
        </div>
    );
}

export default Scroller;
