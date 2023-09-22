import React, {Fragment} from 'react';
import Sidebar from "../components/sidebar/Sidebar";
import {Route, Routes} from "react-router-dom";
import UserProfile from "../pages/user-profile-page/UserProfile";
import Dashboard from "../pages/dashboard-page/Dashboard";
import Tags from "../pages/tags-page/Tags";
import Items from "../pages/items-page/Items";
import PrivateRoute from "./PrivateRoute";

export const UserRoutes = () => {
    return (
        <Fragment>
            <Sidebar/>
            <Routes>
                <Route exact path="/user-profile" element={<PrivateRoute><UserProfile/></PrivateRoute>}/>
                <Route exact path="/dashboard" element={<PrivateRoute><Dashboard/></PrivateRoute>}/>
                <Route exact path="/tags" element={<PrivateRoute><Tags/></PrivateRoute>}/>
                <Route exact path="/items" element={<PrivateRoute><Items/></PrivateRoute>}/>
            </Routes>
        </Fragment>
    )
}