import React from 'react';
import '../Popcorn/PopcornSmall.css';

const NachosNormal = () => {
    return (

        <div className={"food_1"}>
            <img src={"https://d.newsweek.com/en/full/1850144/nachos-cheese-top-lime.jpg"} className={"popcorn"} alt={"popcorn"}/>
            <div className={"rightside_of_popcorn"}>
                <h2 className={"title"}>Nachos</h2>
                <h5 className={"size"}>Normal</h5>
                <p className={"price"}>850 Ft</p>
                <div className={"plus"}>
                    <button className={"but"}>
                        <img src={"/plus.png"} alt={"icon"} height="10px"/>
                    </button>
                </div>
            </div>
        </div>

    );
}

export default NachosNormal;