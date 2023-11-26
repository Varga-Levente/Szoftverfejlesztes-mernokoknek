import React from 'react';
import './Snack.css';

const Snack = (props) => {
    const { key, name, size, price } = props;



    return (

        <div key={key} className={"food_1"}>
            <img src={"https://www.simplyrecipes.com/thmb/Xzggu-Md45HKhhYSw4DK8tGlZ_I=/1500x0/filters:no_upscale():max_bytes(150000):strip_icc()/Simply-Recipes-Perfect-Popcorn-LEAD-41-4a75a18443ae45aa96053f30a3ed0a6b.JPG"} className={"popcorn"} alt={"popcorn"}/>
            <div className={"rightside_of_popcorn"}>
                <h2 className={"title"}>{name}</h2>
                <h5 className={"size"}>{size}</h5>
                <p className={"price"}>{price} Ft</p>
                <div className={"plus"}>
                    <button className={"but"}>
                        <img src={"/plus.png"} alt={"icon"} height="10px"/>
                    </button>
                </div>
            </div>
        </div>

    );
}

export default Snack;