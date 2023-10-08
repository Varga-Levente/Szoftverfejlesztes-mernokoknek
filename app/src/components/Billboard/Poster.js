import React from 'react';
import './Poster.css';

const Poster = ({ title, posterPath, movieid }) => {
    //Check if the title has : in it and split it and store it in title1 and title2 (Add : in the end of title1)
    let title1 = title;
    let title2 = "";
    if (title.includes(":")) {
        title1 = title.split(":")[0] + ":";
        title2 = title.split(":")[1];
    }

    return (
        <div className="poster p-2">
            <a href={`/movie/${movieid}`} className="poster-link">
                <img className="movie-poster" src={posterPath} alt={title}/>
                <div className="poster-title-container">
                    <p className="movie-title">
                        {title1}
                        <br/>
                        <span className="movie-title-sec">{title2}</span>
                    </p>
                </div>
            </a>
        </div>
    );
}

export default Poster;
