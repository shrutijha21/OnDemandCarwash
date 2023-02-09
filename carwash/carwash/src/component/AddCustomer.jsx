import React from 'react'
import { useEffect } from 'react';
import { useState } from 'react';
import { Link, useParams } from 'react-router-dom';
import {useNavigate} from 'react-router-dom';
import AdminDashboardService from '../service/AdminDashboardService';


const AddCustomer = () => {

    const [customerName, setCustomerName]= useState('')
    const [customerEmail, setCustomerEmail]=useState('')
    const [customerPassword, setCustomerPassword]=useState('')
    const [customerAddress, setCustomerAddress]=useState('')
    const [formErrors, setFormErrors]=useState({});
    const [isSubmit, setIsSubmit] = useState(false);
    const navigate=useNavigate();
    const {customerId}=useParams();
    

    const saveOrUpdateCustomer=(e)=>{
        e.preventDefault();

        const customer={customerName, customerEmail, customerPassword, customerAddress}
        setFormErrors(validate(customer));
        setIsSubmit(true);
        //console.log(customer);
        //if(!formErrors){
        if(customerId){

            AdminDashboardService.updateUserInfo(customer,customerId).then((response)=>{
                navigate("/admin-customer");
            }).catch(error=>{
                console.log(error)
                alert("invalid data")
            })
        
        
    }
    else{
        
        AdminDashboardService.insertUserInfo(customer).then((response)=>{
            console.log(response.data)
            //alert("Added sucessfully")
            navigate("/admin-customer");
        }).catch(error=>{
            console.log(error)
            alert("invalid data")
        })
    
}
       // }
        

    }

    useEffect(()=>{
        AdminDashboardService.getCustomerById(customerId).then((response) =>{
            setCustomerName(response.data.customerName)
            setCustomerEmail(response.data.customerEmail)
            setCustomerPassword(response.data.customerPassword)
            setCustomerAddress(response.data.customerAddress)
        }).catch(error =>{
            console.log(error)
        })

    },[])

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


    const  title=()=>{
        if(customerId){
            return <h2 className='text-center'>Update Customer</h2>
        } 
        else{
          return <h2 className='text-center'>Add Customer</h2>
        } 
      }

    return (
        <div className='container'>
            <div >
                {
                    title()
                }
                </div>

            <div class="reg">
                <div class="mb-3">
                    <label  class="form-label">Name</label>
                    <input type="text" class="form-control" value={customerName}  onChange={(e)=>setCustomerName(e.target.value)}/>
                </div>
                <p>{formErrors.name}</p>
                <div class="mb-3">
                    <label  class="form-label">Email address</label>
                    <input type="email" class="form-control" value={customerEmail}  onChange={(e)=>setCustomerEmail(e.target.value)}/>
                </div>
                <p>{formErrors.email}</p>
                <div class="mb-3">
                    <label  class="form-label">password</label>
                    <input type="password" class="form-control" value={customerPassword}  onChange={(e)=>setCustomerPassword(e.target.value)}/>
                </div>
                <p>{formErrors.password}</p>
                <div class="mb-3">
                    <label  class="form-label">Address</label>
                    <textarea class="form-control" id="exampleFormControlTextarea1" rows="3" value={customerAddress}  onChange={(e)=>setCustomerAddress(e.target.value)}></textarea>
                </div>
                <p>{formErrors.address}</p>
                <div class="col-12">
                    <button class="btn btn-primary" onClick={(e)=>saveOrUpdateCustomer(e)}>Save</button>
                     <Link to="/admin-customer" class="btn btn-danger">cancel</Link> 
                </div>
            </div>
        </div>
    )
}
export default AddCustomer;