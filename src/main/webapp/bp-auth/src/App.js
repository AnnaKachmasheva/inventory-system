import React from 'react'
import '../node_modules/bootstrap/dist/css/bootstrap.min.css'
import './App.scss'
import {BrowserRouter, Route, Routes} from 'react-router-dom'
import Login from "./pages/Login";

function App() {
    return (
        <BrowserRouter>
            <Routes>
                <Route path="/login" element={<Login/>}/>
            </Routes>
        </BrowserRouter>)
}

export default App