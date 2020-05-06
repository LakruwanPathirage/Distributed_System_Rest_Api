import React from 'react'
import { Card, ProgressBar } from 'react-bootstrap';

const Sensor = (props) => {
    let cardStyle = "primary";
    //this will change the sensor card backgrouund color red if smoke or co2 lvls are above 5
    if (props.co2 > 5 || props.smoke > 5) {
        cardStyle = "danger";
    }
    return (
        //if a sensor is inactive yellow border will be added to the card
        <Card border={props.status?null:"warning"} bg={cardStyle} key={props.id}
            style={{ minWidth: '20rem' }} text="light" >
            <Card.Header className="text-center">
                <h4> {"Floor " + props.floor + " Room " + props.room}</h4>
            </Card.Header>
            <Card.Body>
                <h5>CO2 : {props.co2}</h5>
                <ProgressBar srOnly animated striped variant="warning"
                    now={props.co2} min={0} max={10} />
                <h5>Smoke : {props.smoke}</h5>
                <ProgressBar animated striped variant="warning"
                    now={props.smoke} min={0} max={10} />

            </Card.Body>
            <Card.Footer> <strong>Status: </strong>{props.status ? "Active" : "Inactive"}</Card.Footer>
        </Card>
    )
}

export default Sensor;