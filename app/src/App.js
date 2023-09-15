import React, { Component } from 'react';

class App extends Component {
    constructor() {
        super();
        this.state = {
            movies: [],
        };
    }

    componentDidMount() {
        // Itt kérjük le a Spring API-tól az adatokat
        fetch('api/v1/movies/getAllMovie')
            .then((response) => response.json())
            .then((data) => {
                this.setState({ movies: data });
            })
            .catch((error) => {
                console.error('Hiba történt:', error);
            });
    }

    render() {
        return (
            <div>
                <h1>Filmek</h1>
                <ul>
                    {this.state.movies.map((movie) => (
                        <li key={movie.id}>
                            <h2>{movie.title}</h2>
                            <p>Év: {movie.year}</p>
                            <p>Értékelés: {movie.rating}</p>
                            <p>Leírás: {movie.overview}</p>
                            <img src={movie.poster_path} alt={movie.title} />
                            <p>Kategóriák: {movie.categories}</p>
                        </li>
                    ))}
                </ul>
            </div>
        );
    }
}

export default App;
