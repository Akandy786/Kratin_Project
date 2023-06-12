
import { Routes ,Route } from 'react-router-dom';
import Home from './component/Home';
import Registration from './Registration';
import Login from './component/login';
import Doc_reg from './doctor/doc_reg'
import Med_reg from './medical/med_reg'
import User_reg from './user/user_reg'

import User_log from './user/user_log'
import Doc_log from './doctor/doc_log'
import Med_log from './medical/med_log'


function App() {
  return (
   
    <Routes>
               <Route exact path="/" element={ <Home/> }></Route>
               <Route exact path="/registrastion" element={ <Registration/> }></Route>
               <Route exact path="/login" element={ <Login/> }></Route>
               <Route exact path="/doc_reg" element={ <Doc_reg/> }> </Route>
               <Route exact path="/med_reg" element={ <Med_reg/> }> </Route>
               <Route exact path="/user_reg" element={ <User_reg/> }> </Route>


               <Route exact path="/user_log" element={ <User_log/> }> </Route>

               <Route exact path="/doc_log" element={ <Doc_log/> }> </Route>
               <Route exact path="/med_log" element={ <Med_log/> }> </Route>
    </Routes>
  );
}

export default App;
