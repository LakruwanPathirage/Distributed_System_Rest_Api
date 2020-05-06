import React from 'react'
import { Nav } from 'react-bootstrap';

const Footer = (props) => {

    //Simple function to format date to readable string
    const getFormattedDate = (datePassed) => {
        let date = new Date(datePassed);
        let str = date.getFullYear() + "/" + (date.getMonth() + 1)
            + "/" + date.getDate() + " " + date.getHours()
            + ":" + date.getMinutes() + ":" + date.getSeconds();
        return str;
    }
    return (
        <Nav className=" fixed-bottom  navbar navbar-dark bg-dark text-white ">
            <Nav.Item>
                {/* this will display api Connection status */}
                Api Connection : <strong>{props.apiStatus}</strong>
            </Nav.Item>
            <Nav.Item>
                {/* This will display the last Updated time */}
                Last Updated : <strong>{getFormattedDate(props.lastUpdated)}</strong> 
            </Nav.Item>
        </Nav>
    );
}

export default Footer
