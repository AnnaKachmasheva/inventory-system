import React, {Component} from "react";
import {BsListUl, BsTags} from "react-icons/bs";
import {AiOutlineUser} from "react-icons/ai";
import {PiUsers} from "react-icons/pi";
import {RxDashboard} from "react-icons/rx";
import {Link} from "react-router-dom";
import styles from './Sidebar.module.scss';


const Sidebar = () => {

    return (
        <div className={styles.sidebarContainer}>
            <SidebarRow linkText={'Dashboard'}
                        link={'/dashboard'}
            />
            <SidebarRow linkText={'Items'}
                        link={'/items'}
            />
            <SidebarRow linkText={'Tags'}
                        link={'/tags'}
            />
            <SidebarRow linkText={'Users'}
                        link={'/users'}
            />
            <SidebarRow linkText={'Profile'}
                        link={'/user-profile'}
            />
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
            <Link to={this.props.link}
                  className={styles.sidebarItem}>
                {this.renderIcon(this.props.linkText)}
                <p>{this.props.linkText}</p>
            </Link>
        )
    }
}