// ContentRow.js
import React from 'react';
import axios from 'axios';
import {API_URL} from '../Config';
import {BrowserRouter, Route, Switch} from 'react-router-dom';
import './ContentRow.css';
import VerticalMenu from './VerticalMenu';
import Scroller from './Billboard/Scroller';
import MovieView from "./MovieView/MovieView";
import Cart from "./Cart/Cart";
import Profile from "./Profile/Profile";
import Coming_soon from "./Coming-soon/Coming-soon";
import Food from "./Food/Food";
import Header from "./Header";
import Settings from "./Settings/Settings";

const ContentRow = () => {
    //Get categories from API /movies/getAllCategories
    const [categories, setCategories] = React.useState([]);
    React.useEffect(() => {
        //Use ${API_URL}/movies/getAllCategories with axios and setCategories
        axios
            .get(`${API_URL}/movie/getCategories`)
            .then((response) => {
                const categoryData = response.data;
                console.log('CONTENTROW | API hívás eredménye:', categoryData);
                setCategories(categoryData);
            }, (error) => {
                console.error('CONTENTROW | API hívás sikertelen:', error);
            });
    }, []);

    return (
        <>
            <Header />
            <div className="row" style={{ height: '100%', paddingTop: '90px' }}>
                <div className="col col-1" style={{ position: 'relative' }}>
                    <VerticalMenu />
                </div>
                <div className="col contents content-col">
                    <BrowserRouter>
                        <Switch>
                            <Route path="/cart" component={Cart} />
                            <Route path="/profile" component={Profile} />
                            <Route path="/food" component={Food} />
                            <Route path="/coming-soon" component={Coming_soon} />
                            <Route path="/settings" component={Settings} />
                            <Route
                                key="popular"
                                path="/"
                                exact
                                render={(props) => (
                                    <div>
                                        {/*Popular Scroller*/}
                                        <Scroller {...props}
                                                  endpoint={`${API_URL}/movie/getPopulars`}
                                                  category="Popular (7+ Rating)"
                                                  extraclass="popular-category"
                                        />

                                        {/*Scrollers by Categories*/}
                                        {categories.map((category) => (
                                            <Scroller {...props}
                                                      endpoint={`${API_URL}/movie/getByCategory/${category}`}
                                                      category={category}
                                            />
                                        ))}

                                    </div>
                                )}
                            />
                            <Route path="/movie/:id" component={MovieView} />
                            <Route render={() => {
                                // JavaScript redirect
                                window.location.href = "/404";
                                return null; // Prevent rendering of any component
                            }} />
                        </Switch>
                    </BrowserRouter>
                </div>
            </div>
        </>
    );
};

export default ContentRow;
