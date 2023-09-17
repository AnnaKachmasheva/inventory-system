import React from "react"
import {Link} from "react-router-dom";
import {useAuth} from "../../context/AuthContext";


function Home(props) {

    const {getUser, userIsAuthenticated, userLogout} = useAuth()

    const enterMenuStyle = () => {
        return userIsAuthenticated() ? {"display": "none"} : {"display": "block"}
    }

    const logoutMenuStyle = () => {
        return userIsAuthenticated() ? { "display": "block" } : { "display": "none" }
    }

    const logout = () => {
        userLogout()
    }

    const getUserName = () => {
        const user = getUser()
        return user ? user.data.name : ''
    }

    return (
        <div className="form-container">
            <p style={logoutMenuStyle()}>
                {`Hi ${getUserName()}`}
            </p>

            <p>
                <Link to={'/login'}
                      style={enterMenuStyle()}>
                    Log in
                </Link>
            </p>

            <p>
                <Link to={'/registrtaion'}
                      style={enterMenuStyle()}>
                    Registration
                </Link>
            </p>

            <p>
                <Link to={'/logout'}
                      style={logoutMenuStyle()}
                      onClick={logout}>
                    Log out
                </Link>
            </p>
        </div>
    )
}

export default Home