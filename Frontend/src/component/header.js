
import {useNavigate,Link} from "react-router-dom";

import Container from 'react-bootstrap/Container';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
import '../../node_modules/bootstrap/dist/css/bootstrap.css'
import '../assets/divs.css'
function Header()
{

  var navigate= useNavigate();


  var session=()=>{

    sessionStorage.clear();

    navigate("/")
  }


  var selected=(e)=>
  {
      if(e.target.value==="user")
      {
        navigate("/user_reg")
      }
      else if(e.target.value=="doctor")
      {
        navigate("/doc_reg")
      }

      else
      {
        navigate("/med_reg")
      }
    
  }
  var logs=(e)=>
  {
      if(e.target.value==="user")
      {
        navigate("/user_log")
      }
      else if(e.target.value=="doctor")
      {
        navigate("/doc_log")
      }

      else
      {
        navigate("/med_log")
      }
    
  }


  





    return(
    <div>


<nav class="navbar navbar-expand-lg bg-body-tertiary">
  <div class="container-fluid">
   
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <Link to={"/"} class="nav-link active" aria-current="page" >Home</Link>
        </li>
        <li class="nav-item">
        
        </li>
       


        




      </ul>
      <form class="d-flex" role="search">
      <label style={{fontSize: 20}}>



<select onChange={logs}>

<option value="">login</option>

  <option value="user">User</option>

  <option value="medical">Medical</option>

  <option value="doctor">Doctor</option>

</select>

</label>
      </form>

      <form class="d-flex" role="search">
      <label style={{fontSize: 20}}>

{'  '}

<select onChange={selected}>

<option value="">Register</option>

  <option value="user">User</option>

  <option value="medical">Medical</option>

  <option value="doctor">Doctor</option>

</select>

</label>
      </form>

    </div>
  </div>
</nav>
    



    </div>
      

    );
}
export default Header;