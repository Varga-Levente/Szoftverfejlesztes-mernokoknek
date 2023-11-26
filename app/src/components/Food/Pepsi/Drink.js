import React from 'react';
import '../Popcorn/Snack.css';

const Drink = (props) => {
    const { key, name, size, price} = props;
    return (

        <div key={key} className={"food_1"}>
            <img src={"https://e3.365dm.com/23/03/768x432/skynews-pepsi-cola_6102187.jpg?20230328114227"} className={"popcorn"} alt={"popcorn"}/>
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

export default Drink;