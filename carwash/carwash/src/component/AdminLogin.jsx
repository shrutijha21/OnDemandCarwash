import React, {useState} from 'react'
import { useNavigate } from 'react-router-dom'
import { useEffect } from 'react'




const AdminLogin = () => {
    

   const [email, setEmail]=useState('')
   const [password, setPassword]=useState('')
   const [board, setBoard]=useState('')
   const [formErrors, setFormErrors]=useState({});
    const [isSubmit, setIsSubmit] = useState(false);
    
    const navigate=useNavigate();

    useEffect(() => {
        console.log(formErrors);
        if (Object.keys(formErrors).length === 0 && isSubmit) {
          console.log(email,password,board);
        }
      }, [formErrors]);
   

   const handleSubmit=(e)=>{
    e.preventDefault()
    setFormErrors(validate(email,password,board));
    setIsSubmit(true);
    if((email==="admin@admin.com") &&( password==="admin123")){
        if(board==="washer"){
        navigate("/admin");
        }
        if(board==="customer"){
            navigate("/admin-customer");
        }
    }
    else{
        alert("invalid credentials");
    }
   
   }

   const validate = (email, password, board) => {
    const errors = {};
    const regex = /^[^\s@]+@[^\s@]+\.[^\s@]{2,}$/i;
    
    if (!email) {
      errors.email = "Email is required!";
    } else if (!regex.test(email)) {
      errors.email = "This is not a valid email format!";
    }
    if (!password) {
      errors.password = "Password is required";
    } else if (password.length < 4) {
      errors.password = "Password must be more than 4 characters";
    } else if (password.length > 20) {
      errors.password = "Password cannot exceed more than 10 characters";
    }
    if(!board){
        errors.board="select a board!";
    }
    return errors;
  };

    return (
        <div className='container'>
            <h1 align="center">Admin-login</h1>


            <div class="reg">
                
                <div class="mb-3">
                    <label  class="form-label" >Email address</label>
                    <input type="email" class="form-control" value={email} onChange={(e)=>setEmail(e.target.value)} />
                    
                </div>
                <p>{formErrors.email}</p>
                <div class="mb-3">
                    <label  class="form-label">password</label>
                    <input type="password" class="form-control" value={password} onChange={(e)=>setPassword(e.target.value)} />
                </div>
                <p>{formErrors.password}</p>
                <div class="mb-3">
                    <label  class="form-label">Board</label>
                    {/* <input type="text" class="form-control" value={board} onChange={(e)=>setBoard(e.target.value)} /> */}
                    <select class="form-select" onChange={(e)=>setBoard(e.target.value)}>
                        <option selected>--select--</option>
                        <option value="customer">customer</option>
                        <option value="washer">washer</option>
                    </select>
                </div>
                <p>{formErrors.board}</p>
                
                <div class="col-12">
                    <button class="btn btn-primary" type="submit" onClick={(e)=>handleSubmit(e)}>Login</button>
                </div>
            </div>
        </div>
    )
}
export default AdminLogin;