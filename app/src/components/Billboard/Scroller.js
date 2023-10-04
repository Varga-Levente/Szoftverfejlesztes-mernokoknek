import React, { useState, useEffect } from 'react';
import axios from 'axios';
import './Scroller.css';
import Poster from './Poster';

const Scroller = ({ endpoint, category, extraclass }) => {
    const [movies, setMovies] = useState([]);

    useEffect(() => {
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
    }, [endpoint]);

    //Split category into two parts on space if it starts with "Popular"
    let category1 = category;
    let category2 = "";
    if (category.startsWith("Popular")) {
        category1 = category.split(" ")[0];
        //Add the rest of the string to category2
        category2 = category.split(" ").slice(1).join(" ");
    }

    return (
        <div className="scroller-container">
            <h2 className={`scroller-category ${extraclass}`}>{category1}<sup className="category-sup"> {category2}</sup></h2>
            <div className="d-flex flex-nowrap overflow-x-auto scroll-div">
                {movies.map((movie) => (
                    <Poster title={movie.title} posterPath={movie.poster_path} />
                ))}
            </div>
        </div>
    );

}

export default Scroller;
