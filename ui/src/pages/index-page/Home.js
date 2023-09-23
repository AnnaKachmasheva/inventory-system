import React from "react"
import {Link} from "react-router-dom";
import {useAuth} from "../../context/AuthContext";
import Nav from "../../components/nav/Nav";


function Home() {

    return (
        <div>
            <Nav/>
            <div className="form-container">

            </div>
        </div>
    )
}

export default Home