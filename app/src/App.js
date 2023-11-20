// src/App.js
import React, { useState, useEffect } from 'react';
import { BrowserRouter, Route, Switch, Redirect } from 'react-router-dom';
import "bootstrap/dist/css/bootstrap.min.css";
import './App.css';
import ContentRow from './components/ContentRow';
import Login from './components/Login/Login';
import Register from './components/Register/Register';
import AdminFood from './Admin/AdminFood';
import AdminMovies from './Admin/AdminMovies';

function App() {
    const [showLoading, setShowLoading] = useState(true);

    useEffect(() => {
        const timeout = setTimeout(() => {
            document.querySelector('.loadinganim').classList.add('hidden');
            setShowLoading(false);
        }, 500);

        return () => clearTimeout(timeout);
    }, []);

    useEffect(() => {
        if (!showLoading) {
            // Ha a showLoading értéke false, akkor adj hozzá a fade-out osztályt
            const loadingAnim = document.querySelector('.loadinganim');
            if (loadingAnim) {
                loadingAnim.classList.add('fade-out');
            }
        }
    }, [showLoading]);

    const isAdminAccessGranted = () => {
        // Ellenőrizze, hogy az access-token paraméter létezik és megfelelő-e
        const searchParams = new URLSearchParams(window.location.search);
        return searchParams.get('access-token') === 'adminAccess';
    };

  return (
    <div style={{overflowX: 'hidden', overflowY: 'scroll'}}>
        <section className='loadinganim'>
            <div className="loader loader-1">
                <div className="loader-outter"></div>
                <div className="loader-inner"></div>
            </div>
        </section>
        <BrowserRouter>
            <Switch>
                <Route path="/login" component={Login} />
                <Route path="/register" component={Register} />
                <Route
                    path="/admin-food"
                    render={() =>
                        isAdminAccessGranted() ? (
                            <AdminFood />
                        ) : (
                            <Redirect to="/" />
                        )
                    }
                />
                <Route
                    path="/admin-movies"
                    render={() =>
                        isAdminAccessGranted() ? (
                            <AdminMovies />
                        ) : (
                            <Redirect to="/" />
                        )
                    }
                />
                <Route path="/" render={() => (
                    <ContentRow />
                )} />
            </Switch>
        </BrowserRouter>
        <footer className="footer text-center demo-alert">
            <div className="container">
                <span className="warning-text">This website is currently under development. As a result, any data stored on the site may be subject to deletion or restoration at any time.<br/></span>
                <span className="legal-copy">© 2023 - Szoftverfejlesztés mérnököknek projekt</span>
            </div>
        </footer>
    </div>
  );
}

export default App;
