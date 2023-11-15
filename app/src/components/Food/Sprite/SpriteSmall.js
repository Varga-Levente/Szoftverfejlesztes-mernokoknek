import React from 'react';
import '../Popcorn/PopcornSmall.css';

const SpriteSmall = () => {
    return (

        <div className={"food_1"}>
            <img src={"https://st4.depositphotos.com/1063437/38719/i/950/depositphotos_387196838-stock-photo-poznan-pol-jun-2020-can.jpg"} className={"popcorn"} alt={"popcorn"}/>
            <div className={"rightside_of_popcorn"}>
                <h2 className={"title"}>Sprite</h2>
                <h5 className={"size"}>Small</h5>
                <p className={"price"}>550 Ft</p>
                <div className={"plus"}>
                    <button className={"but"}>
                        <img src={"/plus.png"} alt={"icon"} height="10px"/>
                    </button>
                </div>
            </div>
        </div>

    );
}

export default SpriteSmall;