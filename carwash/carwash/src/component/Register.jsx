import React from 'react'
import { useState } from 'react';
import RegisterService from '../service/RegisterService';
import { useEffect } from 'react';
import { useNavigate } from 'react-router-dom';


const Register = () => {

    const [customerName, setCustomerName]= useState('')
    const [customerEmail, setCustomerEmail]=useState('')
    const [customerPassword, setCustomerPassword]=useState('')
    const [customerAddress, setCustomerAddress]=useState('')
    const [formErrors, setFormErrors]=useState({});
    const [isSubmit, setIsSubmit] = useState(false);
    const navigate=useNavigate();
    
   
    const saveCustomer=(e)=>{
        e.preventDefault();
        const customer={customerName, customerEmail, customerPassword, customerAddress}
        //console.log(customer);
        setFormErrors(validate(customer));
        setIsSubmit(true);
        
        // if(!formErrors){
        RegisterService.insertUserInfo(customer).then((response)=>{
            console.log(response.data)
            alert("registered sucessfully"); 
            navigate("/sucess");

        }).catch(error=>{
          console.log(error)
          alert("not registered")
      })
      // }
      // else{
      //   alert("no")
      // }

    
    }
  

    useEffect(() => {
        console.log(formErrors);
        if (Object.keys(formErrors).length === 0 && isSubmit) {
          console.log("sucess");
        }
      }, [formErrors]);

    const validate = (customer) => {
        const errors = {};
        const regex = /^[^\s@]+@[^\s@]+\.[^\s@]{2,}$/i;
        const name_regex= /^[a-zA-Z ]{2,30}$/i;
        if (!customer.customerName) {
            errors.name = "name is required!";
          }
          else if(!name_regex.test(customer.customerName)){
            errors.name="Not valid name!";
          }
        if (!customer.customerEmail) {
          errors.email = "Email is required!";
        } else if (!regex.test(customer.customerEmail)) {
          errors.email = "This is not a valid email format!";
        }
        if (!customer.customerPassword) {
          errors.password = "Password is required";
        } else if (customer.customerPassword.length < 4) {
          errors.password = "Password must be more than 4 characters";
        } else if (customer.customerPassword.length > 10) {
          errors.password = "Password cannot exceed more than 10 characters";
        }
        if (!customer.customerAddress) {
            errors.address = "Address is required!";
          }
          
        return errors;
      };

    return (
        <div className='container'>
            <h1 align="center">Register</h1>


            <div class="reg">
                <div class="mb-3">
                    <label  class="form-label">Name</label>
                    <input type="text" class="form-control" value={customerName}  onChange={(e)=>setCustomerName(e.target.value)} />
                </div>
                <p>{formErrors.name}</p>
                <div class="mb-3">
                    <label  class="form-label">Email address</label>
                    <input type="email" class="form-control" value={customerEmail}  onChange={(e)=>setCustomerEmail(e.target.value)} />
                </div>
                <p>{formErrors.email}</p>
                <div class="mb-3">
                    <label  class="form-label">password</label>
                    <input type="password" class="form-control" value={customerPassword}  onChange={(e)=>setCustomerPassword(e.target.value)} />
                </div>
                <p>{formErrors.password}</p>
                <div class="mb-3">
                    <label  class="form-label">Address</label>
                    <textarea class="form-control" id="exampleFormControlTextarea1" rows="3" value={customerAddress}  onChange={(e)=>setCustomerAddress(e.target.value)}></textarea>
                </div>
                <p>{formErrors.address}</p>
                <div class="col-12">
                    <button class="btn btn-primary" onClick={(e)=>saveCustomer(e)}>Save</button>
                    {/* <Link to="/sucess" class="btn btn-primary">Submit</Link> */}
                </div>
            </div>
        </div>
    )
}
export default Register;