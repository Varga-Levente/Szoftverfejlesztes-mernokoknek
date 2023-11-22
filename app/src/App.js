// src/App.js
import React from 'react';
import "bootstrap/dist/css/bootstrap.min.css";
import './App.css';
import Header from './components/Header';
import ContentRow from './components/ContentRow';

function App() {
  return (
    <div className="App">
      <Header />
      <ContentRow />
    </div>
  );
}

export default App;
