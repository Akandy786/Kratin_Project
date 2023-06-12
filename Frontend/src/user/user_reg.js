import axios from 'axios';
import React, { useState} from 'react';
import { useNavigate } from 'react-router-dom';
import {
  MDBBtn,
  MDBContainer,
  MDBCard,
  MDBCardBody,
  MDBCardImage,
  MDBRow,
  MDBCol,
  MDBInput,
  MDBRadio,
}
from 'mdb-react-ui-kit';

function User_reg() {

  var navigate=new useNavigate();

  const [user, setUser] = useState({name: "", age: "",email:"",address:"",pin:"",mobileNo:"",password:""});

    const handleChange = (args)=>
    {
        
        var copyOfCurrentUserInState = {...user};
        copyOfCurrentUserInState[args.target.name] = args.target.value;
        setUser(copyOfCurrentUserInState);
    }

   

      var submit=()=>{
        debugger;
        console.log(user)
        console.log(user.name);

        axios.post("http://localhost:8585/health/users/register", {
        email: user.email,
        name:user.name,
        address:user.address,
        mobileNo:user.mobileNo,
        age:user.age,
        pin:user.pin,
        password:user.password
        })
        .then((response) => {
          
          console.log(response)
          
        });
        navigate("/login")
    }


  return (
    <MDBContainer fluid className='bg-dark'>

      <MDBRow className='d-flex justify-content-center align-items-center h-100'>
        <MDBCol>

          <MDBCard className='my-4'>

            <MDBRow className='g-0'>

              

              <MDBCol md='6'>

                <MDBCardBody className='text-black d-flex flex-column justify-content-center' >
                  <h3 className="mb-5 text-uppercase fw-bold"> User Registration form</h3>
                  <MDBRow>
                    <MDBCol md='6'>
                      <MDBInput wrapperClass='mb-4' label='Name' size='lg' name='name' type='text' onChange={handleChange}/>
                    </MDBCol>

            
                    <MDBInput wrapperClass='mb-4' label='Address' size='lg' name='address' type='text' onChange={handleChange}/>
                 
                    <MDBCol md='6'>
                  <MDBInput wrapperClass='mb-4' label='Pincode' size='lg' name='pin' type='number' onChange={handleChange}/>
                  </MDBCol>
                    <MDBCol md='6'>
                    <MDBInput wrapperClass='mb-4' label='Email Id' size='lg' name='email' type='email' onChange={handleChange}/>
                    </MDBCol>

                    <MDBCol md='6'>
                    <MDBInput wrapperClass='mb-4' label='Age' size='lg' name='age' type='text' onChange={handleChange}/>
                    </MDBCol>

                  </MDBRow>
                  <MDBRow>
                  
                  
                  </MDBRow>

                  <MDBRow>
                  <MDBCol md='6'>
                  <MDBInput wrapperClass='mb-4' label='Mobile No' size='lg' name='mobileNo'  onChange={handleChange}/>
                  </MDBCol>

                  
                  <MDBInput wrapperClass='mb-4' label='Password' size='lg' name='password' type='password' onChange={handleChange}/>
                  </MDBRow>
                  
                  

                 <div className="d-flex justify-content-end pt-3">
                  
                    <MDBBtn className='btn btn-square-sm' color='success' size='md' onClick={submit}>Submit form</MDBBtn>
                  </div>
                 

                </MDBCardBody>

              </MDBCol>
            </MDBRow>

          </MDBCard>

        </MDBCol>
      </MDBRow>
      

    </MDBContainer>
  );
}

export default User_reg;