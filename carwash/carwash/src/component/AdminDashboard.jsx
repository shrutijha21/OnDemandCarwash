import React,{useState} from 'react'
import { useEffect } from 'react'
import { Link, useNavigate } from 'react-router-dom'
import AdminDashboardService from '../service/AdminDashboardService'

const AdminDashboard = () => {

    const[washers, setWashers]=useState([])
    const navigate=useNavigate();

    useEffect(() => {
        getAllWashers();
      }, [])

      const getAllWashers= () =>{
        AdminDashboardService.getAllWashers().then((response) => {
          setWashers(response.data)
          console.log(response.data);
        }).catch(error =>{
          console.log(error);
        })
  
      }

   const deleteWasher=(washerId) =>{
    AdminDashboardService.deleteWasherInfo(washerId).then((response) =>{
      getAllWashers();

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
        <h2 className="text-center">Washer List</h2>
        <Link to="/add-washer" class="btn btn-primary">Add Washer</Link>
        <br></br>
        <table className="table table-bordered table-striped">
            <thead>
                <th>WasherId</th> 
                <th>Washer Name</th>
                <th>Washer Email</th>
                <th>Washer Password</th>
                <th>Action</th>
            </thead>
            <tbody>
                {
                    washers.map(
                        washer=>
                        <tr key={washer.washerId}>
                             <td>{washer.washerId}</td> 
                            <td>{washer.washerName}</td>
                            <td>{washer.washerEmail}</td>
                            <td>{washer.washerPassword}</td>
                            <td><Link to={`/update-washer/${washer.washerId}`} class="btn btn-primary">update</Link>
                            <button className='btn btn-danger' onClick={() => deleteWasher(washer.washerId)} style={{marginLeft:"10px"}}>Delete</button>
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
export default AdminDashboard;