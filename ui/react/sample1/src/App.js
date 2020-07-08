import React from 'react';
import './App.css';
import BasicForm from './component/BasicForm';
import { BrowserRouter, Route} from 'react-router-dom';
import Home from './component/Home';
import FormElements from './component/FormElements';

function App() {
  return (
    <div className="App">
        <BrowserRouter>
          <Route exact path='/' component={Home}/>
          <Route path='/basicForm' component={BasicForm}/>
          <Route path='/formElements' component={FormElements}/>
        </BrowserRouter>
    </div>
  );
}

export default App;
