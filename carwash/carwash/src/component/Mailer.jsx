import React from 'react'
import { useState } from 'react';
import { Link, useNavigate, useParams } from 'react-router-dom';
import emailjs from 'emailjs-com';


 const Mailer = () => {

  const [customerName, setCustomerName]=useState('')
  const [customerEmail, setCustomerEmail]=useState('')
  const navigate=useNavigate();
  const {cost}=useParams();

  const sendEmail=(e)=>{
    e.preventDefault();
      //console.log("email sent");
    const email_content={
      customerName:customerName,
      customerEmail:customerEmail,
      cost:cost,
      
    };

    emailjs.send(
      "service_usv8q2l",
      "template_efw6fqo",
      email_content,
      "g49kgHoiaDaXJQSmI"
      
    )
    navigate("/pay")

  }


  return (
    <div className='container'>
        <div className='card-body'>
        <div className='card col-md-6 offset-md-3 offset-md-3'>
                    <form>
                        <div className='form-group mb-2'>
                            <label className='form-label'>Name</label>
                            <input
                              type="text"
                              className='form-control'
                              value={customerName}
                              onChange= {(e) =>setCustomerName(e.target.value)}
                            ></input>
                        </div>

                        
                        <div className='form-group mb-2'>
                            <label className='form-label'>Enter Email to receive confirmation </label>
                            <input
                              type="email"
                              className='form-control'
                              value={customerEmail}
                              onChange= {(e) =>setCustomerEmail(e.target.value)}
                            ></input>
                        </div>
                        <button className='btn btn-success' onClick={(e) => sendEmail(e)}>Submit</button>
    
                        <Link to="/washpack" className="btn btn-danger ms-2"> Cancel </Link>
                    </form>

                </div>

            </div>
            </div>
    
  )
}
export default Mailer;
