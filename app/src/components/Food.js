import React from 'react';
import './Food.css';
import FoodCard from './FoodCard';

const Food = () => {
    const foods = [
        {
            name: 'PopCorn',
            image: 'popcorn.jpg',
            price: 5,
        },
        {
            name: 'Chicken Wings',
            image: 'chickenwings.jpg',
            price: 8,
        },
        {
            name: 'Burger and Fries',
            image: 'bgf.jpg',
            price: 10,
        },
        {
            name: 'Nacho',
            image: 'nachos.jpg',
            price: 7,
        },
        {
            name: "M&M's",
            image: 'mmsjpg.jpg',
            price: 4,
        },
        {
            name: 'Ananász Snack',
            image: 'pineapple.jpg',
            price: 6,
        },
    ];

    return (
        <div>
            <h1>Foods</h1>
            <div className="grid-container">
                {foods.map((food, index) => (
                    <FoodCard key={index} {...food} />
                ))}
            </div>
        </div>
    );
}

export default Food;