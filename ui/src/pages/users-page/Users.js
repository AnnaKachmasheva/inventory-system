import React, {Component, useEffect, useMemo, useState} from "react"
import {useAuth} from "../../context/AuthContext";
import Sidebar from "../../components/sidebar/Sidebar";
import styles from './Users.module.scss';
import Header from "../../components/header/Header";
import {HiOutlinePencilAlt} from "react-icons/hi";
import {RiDeleteBinLine} from "react-icons/ri";
import MOCK_DATA from "./MOCK_DATA.json"


function Users() {

    const Auth = useAuth();
    const userToken = Auth.getUserToken();
    const [userData, setUserData] = useState([]);

    useEffect(() => {
        handleGetCurrentUser()
    }, [])

    const headers = ['USER', 'ROLE', 'ACTIVITIES'];

    const handleGetCurrentUser = async () => {
        try {
            //todo
        } catch (error) {
            console.log('error')
        }
    }


    const data = useMemo(() => MOCK_DATA, []);


    return (
        <div className={'content'}>
            <Sidebar/>

            <Header title={'USERS'}/>

            <div className={styles.container}>
                <table className={styles.table}>
                    <thead>
                    <tr>
                        <td className={styles.checkboxContainer}><input type={"checkbox"}/></td>
                        {
                            headers.map((header) => <HeaderItem title={header}/>)
                        }
                    </tr>
                    </thead>

                    <tbody>
                        {
                            data.map((user) => <TableRow user={user}/>)
                        }
                    </tbody>

                </table>
            </div>


        </div>
    )
}

export default Users;


class HeaderItem extends Component {
    render() {
        return (
            <td scope={'col'}>
                {this.props.title}
            </td>
        )
    }
}

class TableRow extends Component {
    render() {
        return (
            <tr>
                <td className={styles.checkboxContainer}><input type={"checkbox"}/></td>
                <td>
                    <h6>{this.props.user.firstName} {this.props.user.lastName}</h6>
                    <p>{this.props.user.email}</p>
                    <p>{this.props.user.phone}</p>
                </td>
                <td>{this.props.user.userRole}</td>
                <td>
                    <div className={styles.buttonsContainer}>
                        <button className={'btn btn-outline-success base-btn'}>
                            <HiOutlinePencilAlt className={styles.icon}/>
                            Edit
                        </button>
                        <button className={'btn btn-outline-danger base-btn'}>
                            <RiDeleteBinLine className={styles.icon}/>
                            Delete
                        </button>
                    </div>
                </td>
            </tr>
        )
    }
}