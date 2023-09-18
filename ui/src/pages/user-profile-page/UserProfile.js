import React, {useEffect, useState} from "react"
import {useAuth} from "../../context/AuthContext";
import {userApi} from "../../services/api";
import Sidebar from "../../components/Sidebar";


function UserProfile() {

    const Auth = useAuth();
    const userToken = Auth.getUserToken();
    const titles = ['First name', 'Last name', 'Email', 'Phone'];
    const user = {
        firstName: 'first',
        lastName: 'last',
        email: 'email@gmail.com',
        phone: '123456789'
    }

    const [userData, setUserData] = useState([]);

    useEffect(() => {handleGetCurrentUser()}, [])


    const handleGetCurrentUser = async () => {
        try {
            const response = await userApi.currentUser(userToken)

            console.log(response.data)
            setUserData(response.data)
        } catch (error) {
            console.log('error')        }
    }

    return (
        <div className="main-container">
            <Sidebar/>

            <div className={'card user-info'}>
                <ul>
                    {titles.map((title, i) => {
                        return (<li className={'title'} key={i}>{title}</li>);
                    })}
                </ul>

                <ul>
                    <li>{userData.firstName}</li>
                    <li>{userData.lastName}</li>
                    <li>{userData.email}</li>
                    <li>{userData.phone}</li>
                </ul>

                <button type={'submit'}
                        className={'btn btn-outline-success edit-btn'}>
                    Edit
                </button>
            </div>
        </div>
    )
}

export default UserProfile