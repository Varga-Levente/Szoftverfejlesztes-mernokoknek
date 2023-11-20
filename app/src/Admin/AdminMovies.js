import React, { useState, useEffect } from 'react';
import { API_URL } from '../Config';
import axios from 'axios';
import AdminNav from "./AdminNav";
import "./Admin_Movies.css";
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faEdit, faTrash, faCheck, faTimes } from '@fortawesome/free-solid-svg-icons';

const Admin_Movies = () => {
    const [movies, setMovies] = useState([]);
    const [editingRowId, setEditingRowId] = useState(null);
    const [editedData, setEditedData] = useState({
        title: '',
        year: '',
        rating: '',
        overview: '',
        poster_path: '',
        yt_trailer_id: '',
        categories: '',
    });

    useEffect(() => {
        // Fetch movies from the API when the component mounts
        fetchMovies();
    }, []);

    const fetchMovies = async () => {
        try {
            const response = await axios.get(`${API_URL}/movie/getAll`);
            setMovies(response.data);
        } catch (error) {
            console.error('Error fetching movies:', error);
            // Handle error, e.g., show an error message
        }
    };

    const deleteMovie = async (id) => {
        try {
            await axios.delete(`${API_URL}/movie/remove/${id}`);
            // If deleted successfully, fetch movies again to update the list
            fetchMovies();
            window.alert('Movie deleted successfully.');
        } catch (error) {
            console.error('Error deleting movie:', error);
            // Handle error, e.g., show an error message
            window.alert('Error deleting movie. Please try again.');
        }
    };

    const startEditing = (id, data) => {
        setEditingRowId(id);
        setEditedData(data);
    };

    const cancelEditing = () => {
        setEditingRowId(null);
        setEditedData({
            title: '',
            year: '',
            rating: '',
            overview: '',
            poster_path: '',
            yt_trailer_id: '',
            categories: '',
        });
    };

    const applyEditing = async (id) => {
        try {
            // Send edited data to the API
            await axios.put(`${API_URL}/movie/edit/${id}`, editedData);
            // If edited successfully, fetch movies again to update the list
            fetchMovies();
            setEditingRowId(null);
            setEditedData({
                title: '',
                year: '',
                rating: '',
                overview: '',
                poster_path: '',
                yt_trailer_id: '',
                categories: '',
            });
            window.alert('Movie edited successfully.');
        } catch (error) {
            console.error('Error editing movie:', error);
            // Handle error, e.g., show an error message
            window.alert('Error editing movie. Please try again.');
        }
    };

    const renderMovies = () => {
        return movies.map((movie) => (
            <tr key={movie.id}>
                <th scope="row">{movie.id}</th>
                <td>
                    {editingRowId === movie.id ? (
                        <input
                            type="text"
                            value={editedData.title}
                            onChange={(e) =>
                                setEditedData({
                                    ...editedData,
                                    title: e.target.value,
                                })
                            }
                        />
                    ) : (
                        movie.title
                    )}
                </td>
                <td>
                    {editingRowId === movie.id ? (
                        <input
                            type="text"
                            value={editedData.year}
                            onChange={(e) =>
                                setEditedData({
                                    ...editedData,
                                    year: e.target.value,
                                })
                            }
                        />
                    ) : (
                        movie.year
                    )}
                </td>
                <td>
                    {editingRowId === movie.id ? (
                        <input
                            type="text"
                            value={editedData.rating}
                            onChange={(e) =>
                                setEditedData({
                                    ...editedData,
                                    rating: e.target.value,
                                })
                            }
                        />
                    ) : (
                        movie.rating
                    )}
                </td>
                <td>
                    {editingRowId === movie.id ? (
                        <input
                            type="text"
                            value={editedData.overview}
                            onChange={(e) =>
                                setEditedData({
                                    ...editedData,
                                    overview: e.target.value,
                                })
                            }
                        />
                    ) : (
                        movie.overview.substring(0,40)+"..."
                    )}
                </td>
                <td>
                    {editingRowId === movie.id ? (
                        <input
                            type="text"
                            value={editedData.poster_path}
                            onChange={(e) =>
                                setEditedData({
                                    ...editedData,
                                    poster_path: e.target.value,
                                })
                            }
                        />
                    ) : (
                        movie.poster_path.substring(0,30)+"..."
                    )}
                </td>
                <td>
                    {editingRowId === movie.id ? (
                        <input
                            type="text"
                            value={editedData.yt_trailer_id}
                            onChange={(e) =>
                                setEditedData({
                                    ...editedData,
                                    yt_trailer_id: e.target.value,
                                })
                            }
                        />
                    ) : (
                        movie.yt_trailer_id
                    )}
                </td>
                <td>
                    {editingRowId === movie.id ? (
                        <input
                            type="text"
                            value={editedData.categories}
                            onChange={(e) =>
                                setEditedData({
                                    ...editedData,
                                    categories: e.target.value,
                                })
                            }
                        />
                    ) : (
                        movie.categories
                    )}
                </td>
                <td>
                    {editingRowId === movie.id ? (
                        <>
                            <button
                                className="btn btn-success admin-movie-actionbtn"
                                onClick={() => applyEditing(movie.id)}
                            >
                                <FontAwesomeIcon icon={faCheck} />
                            </button>
                            &nbsp;
                            <button
                                className="btn btn-danger admin-movie-actionbtn"
                                onClick={cancelEditing}
                            >
                                <FontAwesomeIcon icon={faTimes} />
                            </button>
                        </>
                    ) : (
                        <>
                            <button
                                className="btn btn-danger admin-movie-actionbtn"
                                onClick={() => deleteMovie(movie.id)}
                            >
                                <FontAwesomeIcon icon={faTrash} />
                            </button>
                            &nbsp;
                            <button
                                className="btn btn-warning admin-movie-actionbtn"
                                onClick={() => startEditing(movie.id, movie)}
                            >
                                <FontAwesomeIcon icon={faEdit} />
                            </button>
                        </>
                    )}
                </td>
            </tr>
        ));
    };

    const handleFileUpload = async (e) => {
        const file = e.target.files[0];

        try {
            const result = await new Promise((resolve, reject) => {
                const reader = new FileReader();
                reader.onload = (e) => {
                    try {
                        const jsonData = JSON.parse(e.target.result);
                        resolve(jsonData);
                    } catch (error) {
                        reject(error);
                    }
                };
                reader.readAsText(file);
            });

            // Send data to the API
            await axios.post('/movie/add', result);

            // If added successfully, fetch movies again to update the list
            fetchMovies();
            window.alert('Movies added successfully.');
        } catch (error) {
            console.error('Error uploading file and adding movies:', error);
            // Handle error, e.g., show an error message
            window.alert('Error uploading file and adding movies. Please try again.');
        }
    };

    return (
        <>
            <div className="row admin-movie-row1 justify-content-md-center">
                <AdminNav/>
            </div>
            <div className="row admin-movie-row2">
                <div className="col-md-12">
                    <h1 className="text-center" style={{color: "white", }}>Admin - Movies</h1>
                    <p className="text-center admin-movie-counter">
                        Movies: <span className="counter">{movies.length}</span>
                    </p>
                </div>
                <div className="col-md-12 text-center">
                    <input
                        type="file"
                        accept=".json"
                        onChange={handleFileUpload}
                        style={{color: "white", }}
                    />
                </div>
            </div>
            <div className="row admin-movie-row3 justify-content-center">
                <div className="col-md-11">
                    <table className="table table-striped table-dark">
                        <thead>
                        <tr>
                            <th scope="col">#</th>
                            <th scope="col">Title</th>
                            <th scope="col">Year</th>
                            <th scope="col">Rating</th>
                            <th scope="col">Overview</th>
                            <th scope="col">Poster</th>
                            <th scope="col">TrailerID</th>
                            <th scope="col">Categories</th>
                            <th scope="col">Actions</th>
                        </tr>
                        </thead>
                        <tbody>{renderMovies()}</tbody>
                    </table>
                </div>
            </div>
        </>
    );
}

export default Admin_Movies;
