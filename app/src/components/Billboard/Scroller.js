import React, { useState, useEffect } from 'react';
import axios from 'axios';
import './Scroller.css';
import Poster from './Poster';

const Scroller = ({ allCategories, popular, getByCategory, getPopulars }) => {


        //Return movies by categories using category name and all movies in that category
        return (
            <div className="scroller-container">
                <h2 className="scroller-category">Categories</h2>
                <select className="form-control" onChange={handleCategoryChange}>
                    {categories.map((category) => (
                        <option key={category} value={category}>{category}</option>
                    ))}
                </select>
                <div className="d-flex flex-nowrap overflow-x-auto scroll-div">
                    {movies.map((movie) => (
                        <Poster title={movie.title} posterPath={movie.poster_path} key={movie.id} />
                    ))}
                </div>
            </div>
        );
    }
}

export default Scroller;
