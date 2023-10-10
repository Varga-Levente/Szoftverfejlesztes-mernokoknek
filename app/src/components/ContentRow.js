// ContentRow.js
import React from 'react';
import axios from 'axios';
import {API_URL} from '../Config';
import { BrowserRouter, Route, Switch } from 'react-router-dom';
import './ContentRow.css';
import VerticalMenu from './VerticalMenu';
import Scroller from './Billboard/Scroller';
import Test from './Test';
import MovieView from "./MovieView/MovieView";

const ContentRow = () => {
    //Get categories from API /movies/getAllCategories
    const [categories, setCategories] = React.useState([]);
    React.useEffect(() => {
        //Use ${API_URL}/movies/getAllCategories with axios and setCategories
        axios
            .get(`${API_URL}/movie/getCategories`)
            .then((response) => {
                const categoryData = response.data;
                console.log('API hívás eredménye:', categoryData);
                setCategories(categoryData);
            }, (error) => {
                console.error('API hívás sikertelen:', error);
            });
    }, []);

    return (
        <div className="row" style={{ height: '100%' }}>
            <div className="col col-1" style={{ position: 'relative' }}>
                <VerticalMenu />
            </div>
            <div className="col contents content-col">
                <BrowserRouter>
                    <Switch>
                        <Route path="/test" component={Test} />
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
                    </Switch>
                </BrowserRouter>
            </div>
        </div>
    );
};

export default ContentRow;
