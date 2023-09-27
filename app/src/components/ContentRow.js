import React from 'react';
import './ContentRow.css';
import VerticalMenu from './VerticalMenu';

const ContentRow = () => {
  return (
    <div className="row" style={{ height: "100vh" }}>
        <div className="col col-1" style={{ position: "relative" }}>
            <VerticalMenu />
        </div>
        <div className="col" />
        </div>
  );
}

export default ContentRow;