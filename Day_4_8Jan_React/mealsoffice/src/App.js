import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';
import HomePage from './pages/HomePage/HomePage';
import Cards from './pages/Cards/Cards';

class App extends Component {
  render() {
    return (
      <div >
        <HomePage></HomePage>
        <Cards></Cards>
       
      </div>
    );
  }
}

export default App;
