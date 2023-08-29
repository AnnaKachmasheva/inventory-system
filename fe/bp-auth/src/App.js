import React from 'react'
import '../node_modules/bootstrap/dist/css/bootstrap.min.css'
import './App.scss'
import {Route, Routes} from 'react-router-dom'
import Home from "./pages/index-page/Home";
import Login from "./pages/login-page/Login";
import SignUp from "./pages/registartion-page/SignUp";
import ResetPassword from "./pages/reset-password/ResetPassword";

function App() {
    return (
        <div>
            <Routes>
                <Route path="/" element={<Home/>}/>
                <Route path="/login" element={<Login/>}/>
                <Route path="/registrtaion" element={<SignUp/>}/>
                <Route path="/reset-password" element={<ResetPassword/>}/>
            </Routes>
        </div>)
}

export default App