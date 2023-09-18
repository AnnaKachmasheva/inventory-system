import React, {useEffect, useState} from "react"
import {useAuth} from "../../context/AuthContext";
import {userApi} from "../../services/api";
import Sidebar from "../../components/Sidebar";
import Header from "../../components/Header";


function UserProfile() {

    const Auth = useAuth();
    const userToken = Auth.getUserToken();
    const titles = ['First name', 'Last name', 'Email', 'Phone'];
    const [userData, setUserData] = useState([]);

    useEffect(() => {
        handleGetCurrentUser()
    }, [])


    const handleGetCurrentUser = async () => {
        try {
            const response = await userApi.currentUser(userToken)
            setUserData(response.data)
        } catch (error) {
            console.log('error')
        }
    }

    return (
        <div className={'content'}>
            <Sidebar/>
            <div className="main-container">
                <Header title="User profile"/>

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
        </div>
    )
}

export default UserProfile