import React, { useState, useEffect } from 'react';
import { API_URL } from '../Config';
import axios from 'axios';
import AdminNav from "./AdminNav";
import "./AdminUsers.css";
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faTrash } from '@fortawesome/free-solid-svg-icons';

const AdminMovies = () => {
    const [users, setUsers] = useState([]);

    useEffect(() => {
        // Fetch movies from the API when the component mounts
        fetchUser();
    }, []);

    const fetchUser = async () => {
        try {
            const response = await axios.get(`${API_URL}/user/getAll`);
            setUsers(response.data);
            console.log(response.data);
        } catch (error) {
            console.error('Error fetching users:', error);
        }
    };

    const deleteUser = async (id) => {
        try {
            await axios.delete(`${API_URL}/user/remove/${id}`);
            // If deleted successfully, fetch movies again to update the list
            fetchUser();
            window.alert('User deleted successfully.');
        } catch (error) {
            console.error('Error deleting user:', error);
            // Handle error, e.g., show an error message
            window.alert('Error deleting user. Please try again.');
        }
    };

    const renderMovies = () => {
        return users.map((user) => (
            <tr key={user.id}>
                <th scope="row">
                    {user.id}
                </th>
                <td>
                    {user.profileImage}
                </td>
                <td>
                    {user.fullName}
                </td>
                <td>
                    {user.username}
                </td>
                <td>
                    {user.email}
                </td>
                <td>
                    {user.roles[0].name}
                </td>
                <td>
                    <>
                        <button
                            className="btn btn-danger admin-user-actionbtn"
                            onClick={() => deleteUser(user.id)}
                        >
                            <FontAwesomeIcon icon={faTrash} />
                        </button>
                    </>
                </td>
            </tr>
        ));
    };

    return (
        <>
            <div className="row admin-user-row1 justify-content-md-center">
                <AdminNav/>
            </div>
            <div className="row admin-user-row2">
                <div className="col-md-12">
                    <h1 className="text-center" style={{color: "white", }}>Admin - Users</h1>
                    <p className="text-center admin-user-counter">
                        Users: <span className="counter">{users.length}</span>
                    </p>
                </div>
            </div>
            <div className="row admin-user-row3 justify-content-center">
                <div className="col-md-11">
                    <table className="table table-striped table-dark">
                        <thead>
                        <tr>
                            <th scope="col">#</th>
                            <th scope="col">ProfileIMG</th>
                            <th scope="col">Full Name</th>
                            <th scope="col">Username</th>
                            <th scope="col">Email</th>
                            <th scope="col">Role</th>
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

export default AdminMovies;
