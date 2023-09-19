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

    const user = {
        firstName: 'first',
        lastName: 'last',
        email: 'mail@gmail.com',
        phone: '123456789',
    }

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
        <div className={'content-container'}>
            <Sidebar/>
            <div className="content">
                <Header title="User profile"/>

                <div className={'content-info'}>
                    <div className={'card-title-container'}>
                        <h4>Personal information</h4>

                        <button type={'submit'}
                                className={'btn btn-danger '}>
                            Delete account
                        </button>
                    </div>

                    <div className={'card user-info'}>
                        <ul>
                            {titles.map((title, i) => {
                                return (<li className={'title'} key={i}>{title}</li>);
                            })}
                        </ul>

                        <ul>
                            <li>{user.firstName}</li>
                            <li>{user.lastName}</li>
                            <li>{user.email}</li>
                            <li>{user.phone}</li>
                        </ul>

                        <ul className={'title'}>User role</ul>

                        <ul>USER</ul>

                        <div className={'buttons-container'}>
                            <button type={'submit'}
                                    className={'btn btn-outline-success edit-btn'}>
                                Change password
                            </button>
                            <button type={'submit'}
                                    className={'btn btn-success edit-btn'}>
                                Edit
                            </button>
                        </div>

                    </div>

                    <div className={'card user-permission'}>

                    </div>
                </div>

            </div>
        </div>
    )
}

export default UserProfile