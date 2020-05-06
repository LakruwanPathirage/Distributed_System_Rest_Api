import React, { Component } from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';
import { Container } from 'react-bootstrap';
import './App.css';
import SensorView from './Layouts/SensorView/SensorView';
import Header from './Layouts/Header/Header';
import Footer from './Layouts/Footer/Footer';
import Wrapper from './Hoc/Wrapper';

class App extends Component {
  constructor(props){
    super(props);
    this.state = {
      sensors: [],
      apiStatus: "Disconnected",
      lastUpdated : Date.now()
   };
    this.loadData = this.loadData.bind(this);
    // this method need to be binded 'this' inorder to call setState method
  }


  componentDidMount() {
    //get data from api
    this.loadData()
    //run load data function after every 40 seconds to get latest data from api
    setInterval(this.loadData, 40000);
  }

  //this function will asynchronously load data from rest api  
  async loadData() {
    try {
      const res = await fetch('http://localhost:4000/monitoring/details'); 
      const data = await res.json();
      //updateing state with lastest data
      this.setState({
        sensors: data,
        apiStatus: "Connected",
        lastUpdated : Date.now()
      });
    } catch (e) {
      //if failed to communicate with api this code block will run
      console.log(e); 
      this.setState({
        apiStatus:"Disconnected!!"
      });
    }
  }

  render() {
    return (
      <Wrapper>
        <Header />
        <Container className="App mt-5">
          <SensorView sensorList={this.state.sensors}/>
        </Container>
        <Footer apiStatus={this.state.apiStatus} lastUpdated={this.state.lastUpdated}/>
      </Wrapper>
    );
  };
};
  export default App;
