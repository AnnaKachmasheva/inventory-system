import React, {Component, useState} from "react";
import {BsListUl, BsTags} from "react-icons/bs";
import {AiOutlineUser} from "react-icons/ai";
import {PiUsers} from "react-icons/pi";
import {RxDashboard} from "react-icons/rx";
import {Link} from "react-router-dom";
import styles from './Sidebar.module.scss';
import logo from '../../assets/logo_sidebar.png';
import {BiLogIn} from "react-icons/bi";
import {useAuth} from "../../context/AuthContext";


const Sidebar = () => {

    const {userLogout} = useAuth()

    const logout = () => {
        userLogout()
    }

    const setSelectedItemStyle = () => {

    }

    return (
        <div className={styles.sidebarContainer}
             onClick={setSelectedItemStyle}>
            <div className={styles.logoContainer}>
                <img src={logo}
                     alt={'logo'}/>
            </div>

            <SidebarRow linkText={'Dashboard'}
                        link={'/dashboard'}
                        onTop={true}

            />
            <SidebarRow linkText={'Items'}
                        link={'/items'}
                        onTop={true}
            />
            <SidebarRow linkText={'Tags'}
                        link={'/app/tags'}
                        onTop={true}
                        isSeleted={false}
            />
            <SidebarRow linkText={'Users'}
                        link={'/users'}
                        onTop={true}
                        isSeleted={false}
            />

            <hr/>
            <SidebarRow linkText={'Profile'}
                        link={'/user-profile'}
                        onTop={false}
            />
            <div/>
            <button className={'base-btn btn btn-outline-success '.concat(styles.logOutBtn)}
                    onClick={logout}>
                <BiLogIn className={styles.sidebarIcon}
                         size={iconSizeSidebar}/>
                Log out
            </button>
        </div>
    );
};

export default Sidebar;


const iconSizeSidebar = 28;

class SidebarRow extends Component {

    renderIcon = () => {
        // eslint-disable-next-line default-case
        switch (this.props.linkText) {
            case 'Dashboard' :
                return <RxDashboard className={styles.sidebarIcon}
                                    size={iconSizeSidebar}/>;
            case 'Items' :
                return <BsListUl className={styles.sidebarIcon}
                                 size={iconSizeSidebar}/>;
            case 'Tags' :
                return <BsTags className={styles.sidebarIcon}
                               size={iconSizeSidebar}/>;
            case 'Users' :
                return <PiUsers className={styles.sidebarIcon}
                                size={iconSizeSidebar}/>;
            case 'Profile' :
                return <AiOutlineUser className={styles.sidebarIcon}
                                      size={iconSizeSidebar}/>;
        }
    }

    render() {
        return (
            <Link to={'/app' + this.props.link}
                  className={styles.sidebarItem + ' ' +
                      (this.props.isSeleted ? styles.selectedItem : styles.notSelectedItem)}>
                {this.renderIcon(this.props.linkText)}
                <p>{this.props.linkText}</p>
            </Link>
        )
    }
}