import React from "react";
import {BsListUl, BsTags} from "react-icons/bs";
import {AiOutlineUser} from "react-icons/ai";
import {PiUsers} from "react-icons/pi";
import {RxDashboard} from "react-icons/rx";
import {Link} from "react-router-dom";

const iconSizeSidebar = 36;

const Sidebar = () => (
        <div className={'sidebar-container'}>
            <ul>
                <li>
                    <Link to={'/dashboard'}
                          className={'sidebar-item'}>
                        <RxDashboard className={'sidebar-icon'}
                                     size={iconSizeSidebar}/>
                        <p>Dashboard</p>
                    </Link>
                </li>

                <li>
                    <Link to={'/items'}
                          className={'sidebar-item'}>
                        <BsListUl className={'sidebar-icon'}
                                  size={iconSizeSidebar}/>
                        <p>Items</p>
                    </Link>
                </li>

                <li>
                    <Link to={'/tags'}
                          className={'sidebar-item'}>
                        <BsTags className={'sidebar-icon'}
                                size={iconSizeSidebar}/>
                        <p>Tags</p>
                    </Link>
                </li>

                <li>
                    <Link to={'/users'}
                          className={'sidebar-item'}>
                        <PiUsers className={'sidebar-icon'}
                                 size={iconSizeSidebar}/>
                        <p>Users</p>
                    </Link>
                </li>

                <li className={'profile'}>
                    <Link to={'/user-profile'}
                          className={'sidebar-item'}>
                        <AiOutlineUser className={'sidebar-icon'}
                                       size={iconSizeSidebar}/>
                        <p>Profile</p>
                    </Link>
                </li>

            </ul>
        </div>
    )
;

export default Sidebar;