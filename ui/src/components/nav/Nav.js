import React from "react";
import styles from './Nav.module.scss';
import logo from '../../assets/logo_sidebar.png';
import {useNavigate} from "react-router-dom";


const Nav = () => {

    const navigate = useNavigate()


    return (
        <div className={styles.navBarContainer}>
            <div className={styles.logoContainer}>
                <img src={logo}
                     alt={'logo'}/>
            </div>
            <div/>
            <button className={'btn btn-primary '.concat(styles.logInBtn)}
                    onClick={() => {
                        navigate(`/login`)
                    }}>
                LOG IN
            </button>
            <button className={'btn btn-primary '.concat(styles.registrationBtn)}
                    onClick={() => {
                        navigate(`/registration`)
                    }}>
                REGISTRATION
            </button>

        </div>
    );
};

export default Nav;