import React from 'react';
import axios from 'axios';
import { BrowserRouter, Route, Switch } from "react-router-dom";
import './ContentRow.css';
import VerticalMenu from './VerticalMenu';
import Scroller from './Billboard/Scroller';
import Test from './Test';

const ContentRow = () => {
    //Get all categories from /movies/getAllCategories endpoint
    const [categories, setCategories] = React.useState([]);

    React.useEffect(() => {
        axios.get('movies/getAllCategories')
            .then(res => {
                setCategories(res.data);
            })
            .catch(err => {
                console.log(err);
            })
    }, []);





  return (
    <div className="row" style={{ height: "100%" }}>

        <div className="col col-1" style={{ position: "relative" }}>
            <VerticalMenu />
        </div>

        <div className="col content-col contents">
            <BrowserRouter>
                <Switch>
                    <Route path="/test" component={Test} />
                    <Route
                        path="/"
                        render={(props) => (
                            <div className="scrollers">
                                <Scroller {...props} key="Popular" category_name="Popular" />
                                {categories.map((category) => (
                                    <Scroller {...props} key={category} category_name={category} getByCategory="movies/getByCategory/"/>
                                ))}
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