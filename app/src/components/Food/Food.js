import React from 'react';
import './Food.css';
import PopcornSmall from "./Popcorn/PopcornSmall";
import PopcornMedium from "./Popcorn/PopcornMedium";
import PopcornLarge from "./Popcorn/PopcornLarge";
import NachosSmall from "./Nachos/NachosSmall";
import NachosNormal from "./Nachos/NachosNormal";
import NachosLarge from "./Nachos/NachosLarge";
import FriesSmall from "./Fries/FriesSmall";
import FriesNormal from "./Fries/FriesNormal";
import FriesLarge from "./Fries/FriesLarge";
import WingsSmall from "./Wings/WingsSmall";
import WingsNormal from "./Wings/WingsNormal";
import WingsLarge from "./Wings/WingsLarge";
import CokeSmall from "./Coke/CokeSmall";
import CokeNormal from "./Coke/CokeNormal";
import CokeLarge from "./Coke/CokeLarge";
import PepsiSmall from "./Pepsi/PepsiSmall";
import PepsiNormal from "./Pepsi/PepsiNormal";
import PepsiLarge from "./Pepsi/PepsiLarge";
import SpriteSmall from "./Sprite/SpriteSmall";
import SpriteNormal from "./Sprite/SpriteNormal";
import SpriteLarge from "./Sprite/SpriteLarge";
const Food = () => {
    return (
        <div className={"foodPage"}>
            <h1 className="food">Food</h1>
            <div className={"foodContent"}>
                <div className={"line"}>
                    <div className={"foods"}>
                        <PopcornSmall />
                    </div>
                    <div className={"foods"}>
                        <PopcornMedium />
                    </div>
                    <div className={"foods"}>
                        <PopcornLarge />
                    </div>
                    <div className={"foods"}>
                        <NachosSmall />
                    </div>
                    <div className={"foods"}>
                        <NachosNormal />
                    </div>
                </div>
                <div className={"line"}>
                    <div className={"foods"}>
                        <NachosLarge />
                    </div>
                    <div className={"foods"}>
                        <FriesSmall />
                    </div>
                    <div className={"foods"}>
                        <FriesNormal />
                    </div>
                    <div className={"foods"}>
                        <FriesLarge />
                    </div>
                    <div className={"foods"}>
                        <WingsSmall />
                    </div>
                </div>
                <div className={"line"}>
                    <div className={"foods"}>
                        <WingsNormal />
                    </div>
                    <div className={"foods"}>
                        <WingsLarge />
                    </div>
                </div>
                <h2 className={"drink"}>Drink</h2>
                <div className={"line"}>
                    <div className={"foods"}>
                        <CokeSmall />
                    </div>
                    <div className={"foods"}>
                        <CokeNormal />
                    </div>
                    <div className={"foods"}>
                        <CokeLarge />
                    </div>
                    <div className={"foods"}>
                        <PepsiSmall />
                    </div>
                    <div className={"foods"}>
                        <PepsiNormal />
                    </div>
                </div>
                <div className={"line"}>
                    <div className={"foods"}>
                        <PepsiLarge />
                    </div>
                    <div className={"foods"}>
                        <SpriteSmall />
                    </div>
                    <div className={"foods"}>
                        <SpriteNormal />
                    </div>
                    <div className={"foods"}>
                        <SpriteLarge />
                    </div>
                </div>
            </div>
        </div>
    );
}

export default Food;
