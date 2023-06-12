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

function Med_reg() {

  var navigate=new useNavigate();

  const [user, setUser] = useState({shopkeeperName: "", shopName: "",email:"",address:"",openTime:"",closeTime:"",pin:"",mobileNo:"",password:""});

    const handleChange = (args)=>
    {
        
        var copyOfCurrentUserInState = {...user};
        copyOfCurrentUserInState[args.target.name] = args.target.value;
        setUser(copyOfCurrentUserInState);
    }

  

      var submit=()=>{
        debugger;
        console.log(user)
        console.log(user.address);

        axios.post("http://localhost:8585/medical/register", {
        email: user.email,
        shopkeeperName:user.shopkeeperName,
        shopName:user.shopName,
        contactNO:user.contactNo,
        address:user.address,
        openTime:user.openTime,
        closeTime:user.closeTime,
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
                  <h3 className="mb-5 text-uppercase fw-bold">Medical Registration form</h3>
                  <MDBRow>
                    <MDBCol md='6'>
                      <MDBInput wrapperClass='mb-4' label='Shopkeeper Name' size='lg' name='shopkeeperName' type='text' onChange={handleChange}/>
                    </MDBCol>

                    <MDBCol md='6'>
                      <MDBInput wrapperClass='mb-4' label='Shop Name' size='lg' name='shopName' type='text' onChange={handleChange}/>
                    </MDBCol>
                    <MDBInput wrapperClass='mb-4' label='Email ID' size='lg' name='email' type='email' onChange={handleChange}/>
                 

                    
                    <MDBCol md='6'>
                    <MDBInput wrapperClass='mb-4' label='Open Time' size='lg' name='openTime' type='text' onChange={handleChange}/>
                    </MDBCol>

                    <MDBCol md='6'>
                    <MDBInput wrapperClass='mb-4' label='Close Time' size='lg' name='closeTime' type='text' onChange={handleChange}/>
                    </MDBCol>

                    <MDBCol md='6'>
                    <MDBInput wrapperClass='mb-4' label='Adress' size='lg' name='address' type='text' onChange={handleChange}/>
                    </MDBCol>

                    <MDBCol md='6'>
                  <MDBInput wrapperClass='mb-4' label='Pincode' size='lg' name='pin' type='number' onChange={handleChange}/>
                  </MDBCol>

                  </MDBRow>
                

                  <MDBRow>
                  <MDBCol md='6'>
                  <MDBInput wrapperClass='mb-4' label='Mobile No' size='lg' name='mobileNo' type='number' onChange={handleChange}/>
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

export default Med_reg;