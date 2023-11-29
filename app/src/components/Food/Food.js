import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { API_URL } from '../../Config';
import './Food.css';
import Snack from "./Popcorn/Snack";
import Drink from "./Pepsi/Drink";

const Food = () => {
    const [foodItems, setFoodItems] = useState({ snacks: [], drinks: [] });

    useEffect(() => {
        // Axios hívás a /food/getAll endpointra
        console.log('FOOD | useEffect | API hívás indul');
        axios.get(`${API_URL}/food/getAll`)
            .then(response => {
                let drinks = response.data.filter(item => item.description && item.description.includes('ml'));
                drinks = drinks.concat(response.data.filter(item => item.name.includes('Szentkirályi')));

                let snacks = response.data.filter(item => item.description && !item.description.includes('ml') && !item.name.includes('Szentkirályi') && !item.name.includes('Pepsi'));
                console.log('FOOD | useEffect | API hívás eredménye:', drinks);
                setFoodItems({ snacks: snacks, drinks: drinks });
                //print fooditems snacks
                console.log('FOOD | useEffect | API hívás eredménye:', drinks);

            })
            .catch(error => {
                console.error('Error fetching data:', error);
            });
    }, []); // Az üres dependency array azt jelenti, hogy a useEffect csak egyszer fusson le, amikor a komponens mountolódik

    return (
        <div className={"foodPage"}>
            <h1 className="food">Food</h1>
            <div className={"foodContent"}>
                <div className={"line"}>
                    {foodItems.snacks && foodItems.snacks.map(snack => (
                        <div key={snack.id} className={"foods"}>
                                <Snack name={snack.name} size={snack.description} price={snack.price} image={snack.image} />
                        </div>
                    ))}
                </div>
            </div>
            <h1 className="drink">Drinks</h1>
            <div className={"foodContent"}>
                <div className={"line"}>
                    {foodItems.drinks && foodItems.drinks.map(drink => (
                        <div key={drink.id} className={"foods"}>
                                <Drink name={drink.name} size={drink.description} price={drink.price} image={drink.image} />
                        </div>
                    ))}
                </div>
            </div>
        </div>
    );
}

export default Food;
