import React,{useState} from 'react'
import { useEffect } from 'react'
import { Link, useNavigate } from 'react-router-dom'
import AdminDashboardService from '../service/AdminDashboardService'

const AdminCustomerDashboard = () => {

    const[customers, setCustomers]=useState([])
    const navigate=useNavigate();

    useEffect(() => {
        getAllUsers();
      }, [])

      const getAllUsers= () =>{
        AdminDashboardService.getAllUsers().then((response) => {
          setCustomers(response.data)
          console.log(response.data);
        }).catch(error =>{
          console.log(error);
        })
  
      }

   const deleteCustomer=(customerId) =>{
    AdminDashboardService.deleteUserInfo(customerId).then((response) =>{
      getAllUsers();

    }).catch(error =>{
      console.log(error);
    })
  }

  const Logout=()=>{
    navigate("/admin-login");
    alert("logged-out");
  }


  return (
    <div className="container">
        <h2 className="text-center">Customer List</h2>
        <Link to="/add-customer" class="btn btn-primary">Add customer</Link>
        <br></br>
        <table className="table table-bordered table-striped">
            <thead>
                <th>customerId</th> 
                <th>customer Name</th>
                <th>customer Email</th>
                <th>customer Password</th>
                <th>customer Address</th>
                <th>Action</th>
            </thead>
            <tbody>
                {
                    customers.map(
                        customer=>
                        <tr key={customer.customerId}>
                             <td>{customer.customerId}</td> 
                            <td>{customer.customerName}</td>
                            <td>{customer.customerEmail}</td>
                            <td>{customer.customerPassword}</td>
                            <td>{customer.customerAddress}</td>
                            <td><Link to={`/update-customer/${customer.customerId}`} class="btn btn-primary">update</Link>
                            <button className='btn btn-danger' onClick={() => deleteCustomer(customer.customerId)} style={{marginLeft:"10px"}}>Delete</button>
                            </td>

                        </tr>
                    )
                }
            </tbody>
        </table>
        <button className="btn btn-primary" onClick={()=>Logout()}>Logout</button>
        
    </div>
  )
}
export default AdminCustomerDashboard;