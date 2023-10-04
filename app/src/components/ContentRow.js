// ContentRow.js
import React from 'react';
import { BrowserRouter, Route, Switch } from 'react-router-dom';
import './ContentRow.css';
import VerticalMenu from './VerticalMenu';
import Scroller from './Billboard/Scroller';
import Test from './Test';

const ContentRow = () => {
    const API_URL = process.env.API_URL;
    //Get categories from API /movies/getAllCategories
    const [categories, setCategories] = React.useState([]);
    React.useEffect(() => {
        fetch(`${API_URL}/movies/getAllCategories`)
            .then((response) => response.json())
            .then((data) => {
                setCategories(data);
            });
    }, [API_URL]);

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
                                              endpoint={`${API_URL}/movies/getPopularMovies`}
                                              category="Popular (7+ Rating)"
                                              extraclass="popular-category"
                                    />

                                    {/*Scrollers by Categories*/}
                                    {categories.map((category) => (
                                        <Scroller {...props}
                                                  endpoint={`${API_URL}/movies/getMoviesByCategory/${category}`}
                                                  category={category}
                                        />
                                    ))}

                                </div>
                            )}
                        />
                    </Switch>
                </BrowserRouter>
            </div>
        </div>
    );
};

export default ContentRow;
