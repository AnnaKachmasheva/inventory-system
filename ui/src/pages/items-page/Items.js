import React, {useEffect, useState} from "react"
import {useAuth} from "../../context/AuthContext";
import Sidebar from "../../components/Sidebar";


function Items() {

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
            <Sidebar/>
            items
        </div>
    )
}

export default Items;