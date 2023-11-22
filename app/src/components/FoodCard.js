import React, { useState } from 'react';
import './FoodCard.css';

const FoodCard = ({ name, image, price, onAddToCart }) => {
    const [quantity, setQuantity] = useState(0);

    const incrementQuantity = () => {
        setQuantity(quantity + 1);
    };

    const decrementQuantity = () => {
        if (quantity > 0) {
            setQuantity(quantity - 1);
        }
    };

    return (
        <div className="food-card">
            <div className="food-card-left">
                <img src={image} alt={name} />
            </div>
            <div className="food-card-right">
                <h2>{name}</h2>
                <p>Price: {price} USD</p>
                <div className="quantity-control">
                    <button onClick={decrementQuantity}>-</button>
                    <span>{quantity}</span>
                    <button onClick={incrementQuantity}>+</button>
                </div>
                <button className="order-button" disabled={quantity === 0} onClick={() => onAddToCart({ name, price, quantity })}>
                    Order
                </button>
            </div>
        </div>
    );
}

export default FoodCard;
