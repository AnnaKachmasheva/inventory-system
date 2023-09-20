import React from 'react'
import '../node_modules/bootstrap/dist/css/bootstrap.min.css'
import './App.scss'
import {Navigate, Route, Routes} from 'react-router-dom'
import Home from "./pages/index-page/Home";
import Login from "./pages/login-page/Login";
import SignUp from "./pages/registartion-page/SignUp";
import ResetPassword from "./pages/reset-password/ResetPassword";
import ResetPasswordConfirmation from "./pages/reset-password-confirmation/ResetPasswordConfirmation";
import {AuthProvider} from "./context/AuthContext";
import UserProfile from "./pages/user-profile-page/UserProfile";
import Items from "./pages/items-page/Items";
import Dashboard from "./pages/dashboard-page/Dashboard";
import Tags from "./pages/tags-page/Tags";
import Users from "./pages/users-page/Users";
import Sidebar from "./components/sidebar/Sidebar";
import Header from "./components/header/Header";

function App() {
    return (
        <AuthProvider>
            <Routes>
                <Route path="/" element={<Home/>}/>
                <Route path="/login" element={<Login/>}/>
                <Route path="/registration" element={<SignUp/>}/>
                <Route path="/reset-password" element={<ResetPassword/>}/>
                <Route path="/reset-password-confirmation" element={<ResetPasswordConfirmation/>}/>
                <Route path="*" element={<Navigate to="/"/>}/>

                <Route path="/dashboard" element={<Dashboard to="/"/>}/>
                <Route path="/items" element={<Items to="/"/>}/>
                <Route path="/tags" element={<Tags to="/"/>}/>
                <Route path="/users" element={<Users to="/"/>}/>
                <Route path="/user-profile" element={<UserProfile to="/"/>}/>
            </Routes>

        </AuthProvider>
    )
}

export default App