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

function Registration() {

  var navigate=new useNavigate();

  const [user, setUser] = useState({first_name: "", last_name: "",email:"",state:"",district:"",taluka:"",pincode:"",contactNo:"",role:"",password:""});

    const handleChange = (args)=>
    {
        
        var copyOfCurrentUserInState = {...user};
        copyOfCurrentUserInState[args.target.name] = args.target.value;
        setUser(copyOfCurrentUserInState);
    }

    const handleChange_role = (e) => {
        var copyOfUser = { ...user };
        copyOfUser[e.target.id]= e.target.value;
        //set the form values
        setUser(copyOfUser);
      };

      var submit=()=>{
        debugger;
        console.log(user)
        console.log(user.first_name);

        axios.post("http://localhost:7070/user/signup", {
        email: user.email,
        first_name:user.first_name,
        last_name:user.last_name,
        contactNO:user.contactNo,
        state:user.state,
        district:user.district,
        taluka:user.taluka,
        pin:user.pincode,
        role:user.role,
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

              <MDBCol md='6' className="d-none d-md-block">
                <MDBCardImage src='https://e0.pxfuel.com/wallpapers/227/1008/desktop-wallpaper-food-background-herbs-and-spices-food-background-food-background-food-graphy-background-fancy-food-thumbnail.jpg' alt="Sample photo" className="rounded-start img-fluid" fluid/>
              </MDBCol>

              <MDBCol md='6'>

                <MDBCardBody className='text-black d-flex flex-column justify-content-center' >
                  <h3 className="mb-5 text-uppercase fw-bold">Registration form</h3>
                  <MDBRow>
                    <MDBCol md='6'>
                      <MDBInput wrapperClass='mb-4' label='First Name' size='lg' name='first_name' type='text' onChange={handleChange}/>
                    </MDBCol>

                    <MDBCol md='6'>
                      <MDBInput wrapperClass='mb-4' label='Last Name' size='lg' name='last_name' type='text' onChange={handleChange}/>
                    </MDBCol>
                    <MDBInput wrapperClass='mb-4' label='Email ID' size='lg' name='email' type='email' onChange={handleChange}/>
                 

                    <MDBCol md='6'>
                    <MDBInput wrapperClass='mb-4' label='State' size='lg' name='state' type='text' onChange={handleChange}/>
                    </MDBCol>

                    <MDBCol md='6'>
                    <MDBInput wrapperClass='mb-4' label='City' size='lg' name='district' type='text' onChange={handleChange}/>
                    </MDBCol>

                  </MDBRow>
                  <MDBRow>
                  <MDBCol md='6'>
                  <MDBInput wrapperClass='mb-4' label='Taluka' size='lg' name='taluka' type='text' onChange={handleChange}/>
                  </MDBCol>
                  <MDBCol md='6'>
                  <MDBInput wrapperClass='mb-4' label='Pincode' size='lg' name='pincode' type='number' onChange={handleChange}/>
                  </MDBCol>
                  </MDBRow>

                  <MDBRow>
                  <MDBCol md='6'>
                  <MDBInput wrapperClass='mb-4' label='Mobile No' size='lg' name='contactNo' type='number' onChange={handleChange}/>
                  </MDBCol>

                  </MDBRow>
                  <div className='d-md-flex ustify-content-start align-items-center mb-4'>
                    <h6 class="fw-bold mb-0 me-4">Role : </h6>
                    <MDBRadio name='role'  value='mess' label='Mess' id='role' inline onChange={handleChange_role}/>
                    <MDBRadio name='role'value='Customer' label='Customer' id='role' inline  onChange={handleChange_role}/>
                  </div>
                  <MDBRow>
                  <MDBInput wrapperClass='mb-4' label='Password' size='lg' name='password' type='password' onChange={handleChange}/>
                  </MDBRow>
                  
                  

                 <div className="d-flex justify-content-end pt-3">
                    <MDBBtn color='light' size='lg'>Reset all</MDBBtn>
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

export default Registration;