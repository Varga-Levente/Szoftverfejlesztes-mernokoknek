import React from 'react';
import './ContentRow.css';
import VerticalMenu from './VerticalMenu';
import Poster from './Poster';

const ContentRow = () => {
  return (
    <div className="row" style={{ height: "100vh" }}>

        <div className="col col-1" style={{ position: "relative" }}>
            <VerticalMenu />
        </div>

        <div className="col content-col">
            <Poster />
        </div>
    </div>
  );
}

export default ContentRow;