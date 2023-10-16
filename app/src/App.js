// src/App.js
import React, { useState, useEffect } from 'react';
import "bootstrap/dist/css/bootstrap.min.css";
import './App.css';
import Header from './components/Header';
import ContentRow from './components/ContentRow';

function App() {
    const [showLoading, setShowLoading] = useState(true);

    useEffect(() => {
        const timeout = setTimeout(() => {
            document.querySelector('.loadinganim').classList.add('hidden');
            setShowLoading(false);
        }, 1500);

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
      <Header />
      <ContentRow />
    </div>
  );
}

export default App;
