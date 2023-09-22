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
import {UserRoutes} from "./routes/UserRoutes";

function App() {

    return (
        <AuthProvider>
            <Routes>
                <Route path="/" element={<Home/>}/>
                <Route path="/login" element={<Login/>}/>
                <Route path="/registration" element={<SignUp/>}/>
                <Route path="/reset-password" element={<ResetPassword/>}/>
                <Route path="/reset-password-confirmation" element={<ResetPasswordConfirmation/>}/>
                <Route path={'/app/*'} element={<UserRoutes/>}/>

                <Route path="*" element={<Navigate to="/"/>}/>
            </Routes>
        </AuthProvider>
    )
}

export default App