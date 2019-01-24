import React from 'react';
//import ReactDOM from 'react-dom';
import '../index.css';
import AppPage from '../App';
import HomePage from '../pages/HomePage/HomePage.js';
import Curries from'../pages/Curries/Curries.js';
var indexRoutes = [
    { path: "/", name: "App", component: AppPage },
   { path: "/curries", name: "Curries", component: Curries },
  ];

export default indexRoutes;

