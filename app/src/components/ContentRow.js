import React from 'react';
import { BrowserRouter, Route, Switch } from "react-router-dom";
import './ContentRow.css';
import VerticalMenu from './VerticalMenu';
import Scroller from './Billboard/Scroller';
import Test from './Test';

const ContentRow = () => {
  return (
    <div className="row" style={{ height: "100vh" }}>

        <div className="col col-1" style={{ position: "relative" }}>
            <VerticalMenu />
        </div>

        <div className="col content-col">
            <BrowserRouter>
                <Switch>
                    <Route path="/test" component={Test} />
                    <Route
                        path="/"
                        render={(props) => (
                            <div>
                                <Scroller {...props} category="Popular (Rating 7+)" endpoint="movies/getPopularMovies" />
                                <Scroller {...props} category="Action" endpoint="movies/getMoviesByCategory/Action" />
                            </div>
                        )}
                    />
                </Switch>
            </BrowserRouter>
        </div>
    </div>
  );
}

export default ContentRow;