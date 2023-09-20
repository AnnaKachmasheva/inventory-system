import React, {useEffect, useState} from "react"
import {useAuth} from "../../context/AuthContext";


function Dashboard() {
    const Auth = useAuth();
    const userToken = Auth.getUserToken();
    const [userData, setUserData] = useState([]);

    useEffect(() => {
        handleGetCurrentUser()
    }, [])


    const handleGetCurrentUser = async () => {
        try {
            //todo
        } catch (error) {
            console.log('error')
        }
    }

    return (
        <div className={'content'}>
            dashboard
        </div>
    )
}

export default Dashboard;