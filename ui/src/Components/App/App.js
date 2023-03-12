import { Routes, Route,} from "react-router";
import React from 'react';
import './css/App.css';
import Main from '../../Pages/Main/Main';
import Information from '../../Pages/Information/Information';

function App() {
  return (
    <div className="wrapper">
      
        <Routes>
          <Route path='/' element={<Main/>}/>
          <Route path='/information/*' element={<Information />}/>
        </Routes>
  </div>
  );
}

export default App;