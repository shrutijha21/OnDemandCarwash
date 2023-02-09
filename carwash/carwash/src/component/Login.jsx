import React, {useState} from 'react'
import {  useNavigate } from 'react-router-dom';
import { useEffect } from 'react';
import AdminDashboardService from '../service/AdminDashboardService';




const Login = () => {
    const [customerEmail, setCustomerEmail]=useState('')
    const [customerPassword, setCustomerPassword]=useState('')
    const [formErrors, setFormErrors]=useState({});
    const [isSubmit, setIsSubmit] = useState(false);
    const navigate=useNavigate();


   const handleSubmit=(e)=>{
    e.preventDefault();
    setFormErrors(validate(customerEmail,customerPassword));
    setIsSubmit(true);
    // if((customerEmail==="shrutijha9065@gmail.com") && (customerPassword==="customer123"))
    // {
    // navigate("/washpack");
    // }
    // else{
    //     alert("invalid credentails");
    // }

    AdminDashboardService.getByCustomerEmail(customerEmail).then((response)=>{
        //console.log(response.data)
        if(response.data.customerEmail===customerEmail && response.data.customerPassword===customerPassword)
        {
            navigate("/washpack");
        }
        else{
            alert("invalid credentials");
        }
        
    }).catch(error=>{
        console.log(error)
        alert("invalid credentials")
    })

   }

   useEffect(() => {
    console.log(formErrors);
    if (Object.keys(formErrors).length === 0 && isSubmit) {
      console.log("login sucess");
    }
  }, [formErrors]);
   

   const validate = (customerEmail, customerPassword) => {
    const errors = {};
    const regex = /^[^\s@]+@[^\s@]+\.[^\s@]{2,}$/i;
    
    
    if (!customerEmail) {
      errors.email = "Email is required!";
    } else if (!regex.test(customerEmail)) {
      errors.email = "This is not a valid email format!";
    }
    if (!customerPassword) {
      errors.password = "Password is required";
    } else if (customerPassword.length < 4) {
      errors.password = "Password must be more than 4 characters";
    } else if (customerPassword.length > 20) {
      errors.password = "Password cannot exceed more than 10 characters";
    }
    return errors;
  };

   

    return (
        <div className='container'>
            <h1 align="center">Login</h1>


            <div class="reg">
                
                <div class="mb-3">
                    <label  class="form-label" >Email address</label>
                    <input type="email" class="form-control" value={customerEmail} onChange={(e)=>setCustomerEmail(e.target.value)} />
                    
                </div>
                <p>{formErrors.email}</p>
                <div class="mb-3">
                    <label  class="form-label">password</label>
                    <input type="password" class="form-control" value={customerPassword} onChange={(e)=>setCustomerPassword(e.target.value)} />
                </div>
                <p>{formErrors.password}</p>
                <div class="col-12">
                     <button class="btn btn-primary" type="submit" onClick={(e)=>handleSubmit(e)}>Login</button>
                    {/* <Link to="/washpack" class="btn btn-primary">click</Link> */}
                </div>
            </div>
        </div>
    )
}
export default Login;