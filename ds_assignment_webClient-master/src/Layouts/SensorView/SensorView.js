import React from 'react';
import { Container, Row, Col } from 'react-bootstrap';
import Sensor from '../../Components/Sensor/Sensor';

const SensorView = (props) => {
    // this will craete jsx elements for every sensor object in sensors[]
    const sensorRender = props.sensorList.map(sensor => {
        return (<Col key={sensor._id} className='mt-5'>
            <Sensor
                floor={sensor.floorNo}
                room={sensor.roomNo}
                co2={sensor.co2_level}
                smoke={sensor.smokelevel}
                status={sensor.status} />
        </Col>);
    });
    return (
        <Container className='mb-5'>
            <Row xs={1} md={2} lg={2} xl={3} className="justify-content-md-center">

                {sensorRender}

            </Row>


        </Container>
    );
}

export default SensorView;
