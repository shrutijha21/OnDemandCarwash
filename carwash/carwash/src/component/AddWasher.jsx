import React from 'react'
import { useEffect } from 'react';
import { useState } from 'react';
import { Link, useParams } from 'react-router-dom';
import {useNavigate} from 'react-router-dom';
import AdminDashboardService from '../service/AdminDashboardService';



const AddWasher = () => {

    const [washerName, setWasherName]= useState('')
    const [washerEmail, setWasherEmail]=useState('')
    const [washerPassword, setWasherPassword]=useState('')
    const [formErrors, setFormErrors]=useState({});
    const [isSubmit, setIsSubmit] = useState(false);
    const navigate=useNavigate();
    const {washerId}=useParams();

    
    

    const saveOrUpdateWasher=(e)=>{
        e.preventDefault();

        const washer={washerName, washerEmail, washerPassword}
        setFormErrors(validate(washer));
        setIsSubmit(true);
        //console.log(washer);
       // if(!formErrors){
        if(washerId){
            AdminDashboardService.updateWasherInfo(washer,washerId).then((response)=>{
                navigate("/admin");
            }).catch(error=>{
                console.log(error)
                alert("inavlid data")
            })  
    }
    else{
        AdminDashboardService.insertWasherInfo(washer).then((response)=>{
            console.log(response.data)
            //alert("Added sucessfully")
            navigate("/admin");
        }).catch(error=>{
            console.log(error)
            alert("invalid data")
        })
}
       // }

}

    useEffect(()=>{
        AdminDashboardService.getById(washerId).then((response) =>{
            setWasherName(response.data.washerName)
            setWasherEmail(response.data.washerEmail)
            setWasherPassword(response.data.washerPassword)
        }).catch(error =>{
            console.log(error)
        })

    },[])

    const validate = (washer) => {
        const errors = {};
        const regex = /^[^\s@]+@[^\s@]+\.[^\s@]{2,}$/i;
        const name_regex= /^[a-zA-Z ]{2,30}$/i;
        if (!washer.washerName) {
            errors.name = "name is required!";
          }
          else if(!name_regex.test(washer.washerName)){
            errors.name="Not valid name!";
          }
        if (!washer.washerEmail) {
          errors.email = "Email is required!";
        } else if (!regex.test(washer.washerEmail)) {
          errors.email = "This is not a valid email format!";
        }
        if (!washer.washerPassword) {
          errors.password = "Password is required";
        } else if (washer.washerPassword.length < 4) {
          errors.password = "Password must be more than 4 characters";
        } else if (washer.washerPassword.length > 10) {
          errors.password = "Password cannot exceed more than 10 characters";
        }
        return errors;
    }


   

    const  title=()=>{
        if(washerId){
            return <h2 className='text-center'>Update Washer</h2>
        } 
        else{
          return <h2 className='text-center'>Add Washer</h2>
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
                    <input type="text" class="form-control" value={washerName}  onChange={(e)=>setWasherName(e.target.value)}/>
                </div>
                <p>{formErrors.name}</p>
                <div class="mb-3">
                    <label  class="form-label">Email address</label>
                    <input type="email" class="form-control" value={washerEmail}  onChange={(e)=>setWasherEmail(e.target.value)}/>
                    
                </div>
                <p>{formErrors.email}</p>
                <div class="mb-3">
                    <label  class="form-label">password</label>
                    <input type="password" class="form-control" value={washerPassword}  onChange={(e)=>setWasherPassword(e.target.value)}/>
                </div>
                <p>{formErrors.password}</p>
                <div class="col-12">
                    <button class="btn btn-primary" onClick={(e)=>saveOrUpdateWasher(e)}>Save</button>
                     <Link to="/admin" class="btn btn-danger">cancel</Link> 
                </div>
            </div>
        </div>
    )
}
export default AddWasher;