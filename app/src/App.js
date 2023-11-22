// src/App.js
import React, { useState, useEffect } from 'react';
import { BrowserRouter, Route, Switch } from 'react-router-dom';
import "bootstrap/dist/css/bootstrap.min.css";
import './App.css';
import ContentRow from './components/ContentRow';
import Login from './components/Login/Login';
import Register from './components/Register/Register';

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
                <Route path="/" render={() => (
                    <ContentRow />
                )} />
            </Switch>
        </BrowserRouter>
    </div>
  );
}

export default App;
