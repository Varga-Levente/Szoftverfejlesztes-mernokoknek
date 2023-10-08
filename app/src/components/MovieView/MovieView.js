import React, {useState, useEffect} from 'react';
import {API_URL} from '../../Config';
import './MovieView.css';
import axios from 'axios';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faTicket } from '@fortawesome/free-solid-svg-icons';

const MovieView = ({ match }) => {
    const [movieData, setMovieData] = useState({});
    const { id } = match.params;

    useEffect(() => {
        // Elküldjük a GET kérést az API-hoz az adott ID-vel
        axios.get(`${API_URL}/movie/getById/${id}`)
            .then(response => {
                if (response.status === 200) {
                    const data = response.data;
                    //If the rating not has a decimal part, add .0 to the end
                    if (data.rating % 1 === 0) {
                        data.rating += '.0';
                    }
                    //The categories separated by ; change it to ,
                    data.categories = data.categories.replace(/;/g, ', ');
                    setMovieData(data);
                    console.log(data);
                    //If the data stored modify .viewer opacity to 1
                    document.querySelector('.viewer').style.opacity = 1;
                } else {
                    console.error('Hiba történt az API-hívás során:', response.statusText);
                    //Redirect to home page
                    window.location.href = '/';
                }
            })
            .catch(error => {
                console.error('Hiba történt az API-hívás során:', error);
                window.location.href = '/';
            });
    }, [id]);

    return (
        <div className="container viewer">
            <div className="row">
                <div className="col col-md-4 left-col">
                    <div className="row">
                        <div className="col">
                            <div className="centerflex posterdiv">
                                <img className="movieView-poster" alt={movieData.title} src={movieData.poster_path}/>
                                <p className="rating-bar">Rating: {movieData.rating}</p>
                            </div>
                        </div>
                    </div>
                    <div className="row">
                        <div className="col">
                            <div className="centerflex columnflex">
                                <p className="movieView-title">{movieData.title}<sup
                                    className="movieView-releaseyear">({movieData.year})</sup></p>
                                <p className="movieView-categories">{movieData.categories}</p>
                            </div>
                            <div className="centerflex">
                                <a className="btn btn-danger btn-lg buy-ticket-btn" href="#" role="button">
                                    <FontAwesomeIcon icon={faTicket} className="ticket-icon"/>
                                    Buy a Ticket
                                </a>
                            </div>
                        </div>
                    </div>
                </div>
                <div className="col col-md-8">
                    <div>
                        <p className="movieView-overiew">Overview</p>
                        <p className="movieView-overviewtext">{movieData.overview}</p>
                        <p className="movieView-trailer">Trailer</p>
                        <iframe className="bg-dark bg-opacity-50 d-flex align-items-center align-self-center trailer-video"
                                allowFullScreen frameBorder="0" src={`https://www.youtube-nocookie.com/embed/${movieData.yt_trailer_id}`}
                                width="800vh" height="450vw"></iframe>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default MovieView;