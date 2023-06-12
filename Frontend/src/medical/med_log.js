import React, { useState } from 'react';
import {
  MDBBtn,
  MDBContainer,
  MDBRow,
  MDBCol,
  MDBInput,
  MDBCardImage
}
from 'mdb-react-ui-kit';

function Med_log() {
    
    const [user,setUser]=useState({email:"",password:""});

    const handleChange = (args)=>
    {
        
        var copyOfCurrentUserInState = {...user};
        copyOfCurrentUserInState[args.target.name] = args.target.value;
        setUser(copyOfCurrentUserInState);
    }

    const submit=()=>
    {
        console.log(user);
    }


  return (
    <MDBContainer className="my-5 gradient-form">

      <MDBRow>

        <MDBCol col='6' className="mb-5">
          <div className="d-flex flex-column ms-5">

            <div className="text-center">
              <img src="https://www.kratin.co.in/images/kratin.png"
                style={{width: '185px'}} alt="logo" />
              <h4 className="mt-1 mb-5 pb-1">Demo Project</h4>
            </div>
            <h4>
            <p>Medical login to your account</p></h4>


            <MDBInput wrapperClass='mb-4' label='Email address' id='form1' name='email' type='email' onChange={handleChange}/>
            <MDBInput wrapperClass='mb-4' label='Password' id='form2' name='password' type='password' onChange={handleChange}/>


            <div className="text-center pt-1 mb-5 pb-1">
                
              <MDBBtn className="mx-2 md-4" color='info' onClick={submit}>Login</MDBBtn>
              <br></br>
              <a className="text-muted md-4" href="#!">Forgot password?</a>
            </div>

            <div className="d-flex flex-row align-items-center justify-content-center pb-4 mb-4">
              <p className="mb-0">Don't have an account?</p>
              <MDBBtn outline className='mx-2' color='danger'>
                Singup
              </MDBBtn>
            </div>

          </div>

        </MDBCol>

        <MDBCol col='6' className="mb-5">
        <MDBCardImage src='https://cdn.cloverhealth.com/filer_public/51/72/51721959-d7cf-45e1-b968-2f8bef496d94/5-tips-for-improving-communication-with-older-adults.png' alt="Sample photo" className="rounded-start img-fluid" fluid/>

        </MDBCol>

      </MDBRow>

    </MDBContainer>
  );
}

export default Med_log;