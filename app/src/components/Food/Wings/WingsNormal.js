import React from 'react';
import '../Popcorn/PopcornSmall.css';

const WingsNormal = () => {
    return (

        <div className={"food_1"}>
            <img src={"data:image/jpeg;base64,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"} className={"popcorn"} alt={"popcorn"}/>
            <div className={"rightside_of_popcorn"}>
                <h2 className={"title"}>Wings</h2>
                <h5 className={"size"}>Normal</h5>
                <p className={"price"}>1000 Ft</p>
                <div className={"plus"}>
                    <button className={"but"}>
                        <img src={"/plus.png"} alt={"icon"} height="10px"/>
                    </button>
                </div>
            </div>
        </div>

    );
}

export default WingsNormal;