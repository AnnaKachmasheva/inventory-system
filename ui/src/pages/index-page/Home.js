import React from "react"
import {Link} from "react-router-dom";

function Home(props) {
    return (
        <div className="form-container">
            <p>
                <Link to={'/login'}>Log in</Link>
            </p>

            <p>
                <Link to={'/registrtaion'}>Registration</Link>
            </p>
        </div>
    )
}

export default Home