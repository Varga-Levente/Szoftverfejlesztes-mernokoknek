import React, { useState, useEffect } from 'react';
import { API_URL } from '../Config';
import AdminNav from './AdminNav';
import './Admin_Food.css';
import { faEdit, faTrash, faPlus, faCheck, faTimes } from '@fortawesome/free-solid-svg-icons';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import axios from 'axios';
import Papa from 'papaparse';

const Admin_Food = () => {
    const [foods, setFoods] = useState([]);
    const [editingRowId, setEditingRowId] = useState(null);
    const [editedData, setEditedData] = useState({
        name: '',
        description: '',
        img_url: '',
        price: '',
    });

    useEffect(() => {
        // Fetch foods from the API when the component mounts
        fetchFoods();
    }, []);

    const fetchFoods = async () => {
        try {
            const response = await axios.get(`${API_URL}/food/getAll`);
            setFoods(response.data);
            console.log(response.data);
        } catch (error) {
            console.error('Error fetching foods:', error);
            // Handle error, e.g., show an error message
        }
    };

    const handleFileUpload = (event) => {
        const file = event.target.files[0];

        Papa.parse(file, {
            header: false,
            complete: (result) => {
                const parsedFoods = result.data
                    .filter(food => food.every(value => value !== null)) // Filter out rows with null values
                    .map((food, index) => ({
                        id: index + 1,
                        name: food[0],
                        description: food[1],
                        img_url: 'default_image_url', // Set your default image URL here
                        price: food[2],
                    }));

                sendDataToApi(parsedFoods);
            },
        });
    };

    const sendDataToApi = async (data) => {
        try {
            // Send data to the API
            await axios.post(`${API_URL}/food/add`, data);
            // If sent successfully, fetch foods again to update the list
            fetchFoods();
        } catch (error) {
            console.error('Error sending data to API:', error);
            // Handle error, e.g., show an error message
        }
    };

    const deleteFood = async (id) => {
        try {
            await axios.delete(`${API_URL}/food/delete/${id}`);
            // If deleted successfully, fetch foods again to update the list
            fetchFoods();
            window.alert('Food deleted successfully.');
        } catch (error) {
            console.error('Error deleting food:', error);
            // Handle error, e.g., show an error message
            window.alert('Error deleting food. Please try again.');
        }
    };

    const startEditing = (id, data) => {
        setEditingRowId(id);
        setEditedData(data);
    };

    const cancelEditing = () => {
        setEditingRowId(null);
        setEditedData({
            name: '',
            description: '',
            img_url: '',
            price: '',
        });
    };

    const applyEditing = async (id) => {
        try {
            // Send edited data to the API
            await axios.put(`${API_URL}/food/edit/${id}`, editedData);
            // If edited successfully, fetch foods again to update the list
            fetchFoods();
            setEditingRowId(null);
            setEditedData({
                name: '',
                description: '',
                image: '',
                price: '',
            });
            window.alert('Food edited successfully.');
        } catch (error) {
            console.error('Error editing food:', error);
            // Handle error, e.g., show an error message
            window.alert('Error editing food. Please try again.');
        }
    };

    const renderFoods = () => {
        return foods.map((food) => (
            <tr key={food.id}>
                <th scope="row">{food.id}</th>
                <td>
                    {editingRowId === food.id ? (
                        <input
                            type="text"
                            value={editedData.name}
                            onChange={(e) =>
                                setEditedData({
                                    ...editedData,
                                    name: e.target.value,
                                })
                            }
                        />
                    ) : (
                        food.name
                    )}
                </td>
                <td>
                    {editingRowId === food.id ? (
                        <input
                            type="text"
                            value={editedData.description}
                            onChange={(e) =>
                                setEditedData({
                                    ...editedData,
                                    description: e.target.value,
                                })
                            }
                        />
                    ) : (
                        food.description
                    )}
                </td>
                <td>
                    {editingRowId === food.id ? (
                        <input
                            type="text"
                            value={editedData.image}
                            onChange={(e) =>
                                setEditedData({
                                    ...editedData,
                                    image: e.target.value,
                                })
                            }
                        />
                    ) : (
                        food.image // Itt a food.img_url-t kell megjeleníteni
                    )}
                </td>
                <td>
                    {editingRowId === food.id ? (
                        <input
                            type="text"
                            value={editedData.price}
                            onChange={(e) =>
                                setEditedData({
                                    ...editedData,
                                    price: e.target.value,
                                })
                            }
                        />
                    ) : (
                        food.price
                    )}
                </td>
                <td>
                    {editingRowId === food.id ? (
                        <>
                            <button
                                className="btn btn-success admin-food-actionbtn"
                                onClick={() => applyEditing(food.id)}
                            >
                                <FontAwesomeIcon icon={faCheck} />
                            </button>
                            &nbsp;
                            <button
                                className="btn btn-danger admin-food-actionbtn"
                                onClick={cancelEditing}
                            >
                                <FontAwesomeIcon icon={faTimes} />
                            </button>
                        </>
                    ) : (
                        <>
                            <button
                                className="btn btn-danger admin-food-actionbtn"
                                onClick={() => deleteFood(food.id)}
                            >
                                <FontAwesomeIcon icon={faTrash} />
                            </button>
                            &nbsp;
                            <button
                                className="btn btn-warning admin-food-actionbtn"
                                onClick={() => startEditing(food.id, food)}
                            >
                                <FontAwesomeIcon icon={faEdit} />
                            </button>
                        </>
                    )}
                </td>
            </tr>
        ));
    };

    return (
        <>
            <div className="row admin-food-row1 justify-content-md-center">
                <AdminNav/>
            </div>
            <div className="row admin-food-row2">
                <div className="col-md-12">
                    <h1 className="text-center" style={{color: "white", }}>Admin - Food</h1>
                    <p className="text-center admin-food-counter">
                        Foods: <span className="counter">{foods.length}</span>
                    </p>
                </div>
                <div className="col-md-12 text-center">
                    <input
                        type="file"
                        accept=".csv"
                        onChange={handleFileUpload}
                        style={{color: "white", }}
                    />
                </div>
            </div>
            <div className="row admin-food-row3 justify-content-center">
                <div className="col-md-11">
                    <table className="table table-striped table-dark">
                        <thead>
                        <tr>
                            <th scope="col">#</th>
                            <th scope="col">Name</th>
                            <th scope="col">Description</th>
                            <th scope="col">IMG_URL</th>
                            <th scope="col">Price</th>
                            <th scope="col">Actions</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <th scope="row">WIP</th>
                            <td>
                                <input type="text" className="form-control admin-food-input" disabled placeholder="Food name"/>
                            </td>
                            <td>
                                <input type="text" className="form-control admin-food-input" disabled placeholder="Food description"/>
                            </td>
                            <td>
                                <input type="text" className="form-control admin-food-input" disabled placeholder="Food image url"/>
                            </td>
                            <td>
                                <input type="text" className="form-control admin-food-input" disabled placeholder="Food price"/>
                            </td>
                            <td>
                                <button disabled className="btn btn-success admin-food-actionbtn"><FontAwesomeIcon icon={faPlus}/></button>
                            </td>
                        </tr>
                        {renderFoods()}
                        </tbody>
                    </table>
                </div>
            </div>
        </>
    );
}

export default Admin_Food;
