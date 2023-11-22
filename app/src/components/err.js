import React from 'react';
import './err.css';
const Err = (props) => {
    const query = new URLSearchParams(props.location.search);
    const errmsg = query.get('err');
    console.log('ERR | errmsg:', errmsg);

    return (
        <h1 className="errtext">{errmsg}</h1>
    );
}

export default Err;
