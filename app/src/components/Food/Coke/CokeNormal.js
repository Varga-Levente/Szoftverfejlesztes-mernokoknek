import React from 'react';
import '../Popcorn/PopcornSmall.css';

const CokeNormal = () => {
    return (

        <div className={"food_1"}>
            <img src={"https://cdn.vg.hu/2023/04/NfeJtlC1RyA0Zlw4dA9QWOd8dmCv0lz29X2v0lIFnkY/fit/1200/802/no/1/aHR0cHM6Ly9jbXNjZG4uYXBwLmNvbnRlbnQucHJpdmF0ZS9jb250ZW50LzBlOWQ1MjZkOTZkNTQ3NzA5ZjhiMzk1MzlhZmJmZmQ2.jpg"} className={"popcorn"} alt={"popcorn"}/>
            <div className={"rightside_of_popcorn"}>
                <h2 className={"title"}>Coca Cola</h2>
                <h5 className={"size"}>Small</h5>
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

export default CokeNormal;