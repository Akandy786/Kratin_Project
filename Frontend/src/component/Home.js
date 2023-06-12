import { Outlet, useNavigate  } from "react-router-dom";
import '../Registration';
import '../assets/imgs.css'
import Header from "./header";
import back from './images/mess.jpeg'
import React from 'react';

function Home()
{
    var navigate = useNavigate();
    var change=()=>{
        navigate("/registrastion");
    }

    var like=()=>{
      console.log("Clicked")

    }



    const myStyle={
      backgroundImage: 
"url('https://www.sehat.com/article_images/ways-to-make-senior-citizens-happy_1325_original.jpg')",
      height:'800px',
      marginTop:'-70px',
      fontSize:'50px',
      backgroundSize: 'cover',
      backgroundRepeat: 'no-repeat',
  };

    return <>
    <button onClick={change}>SignUp</button>

    <div style={myStyle} className="trsize">
        
        <Header></Header>
        <div>
              <img src="https://www.kratin.co.in/images/kratin.png"
                style={{width: '185px'}} alt="logo" />
              <h4 className="mt-1 mb-5 pb-1">Demo Project</h4>
            </div>
        <div className="mainDiv">

          <div className="leftDiv">
          
          </div>
        

        
        <div className="rightDiv">
        <Outlet></Outlet>
        </div>
  
        </div>
       
        </div>
    
    </>
}
 export default Home