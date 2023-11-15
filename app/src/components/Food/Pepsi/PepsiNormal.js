import React from 'react';
import '../Popcorn/PopcornSmall.css';

const PepsiNormal = () => {
    return (

        <div className={"food_1"}>
            <img src={"https://e3.365dm.com/23/03/768x432/skynews-pepsi-cola_6102187.jpg?20230328114227"} className={"popcorn"} alt={"popcorn"}/>
            <div className={"rightside_of_popcorn"}>
                <h2 className={"title"}>Pepsi</h2>
                <h5 className={"size"}>Normal</h5>
                <p className={"price"}>650 Ft</p>
                <div className={"plus"}>
                    <button className={"but"}>
                        <img src={"/plus.png"} alt={"icon"} height="10px"/>
                    </button>
                </div>
            </div>
        </div>

    );
}

export default PepsiNormal;