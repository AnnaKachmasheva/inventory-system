import React from "react";
import logo from '../../assets/logo.png';
import styles from './AuthHeader.module.scss';


const AuthHeader = () => (
    <div className={'logo'}>
        <img className={styles.logo} src={logo} alt={'logo'}/>
    </div>

);

export default AuthHeader;