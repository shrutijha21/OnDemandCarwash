import React,{useState} from 'react'
import { useEffect } from 'react'
import { Link, useNavigate } from 'react-router-dom'
import ListWashpackService from '../service/ListWashpackService'

const ListWashpackComponent = () => {

    const[washpacks, setWashpacks]=useState([])
    const navigate=useNavigate();

   useEffect(()=>{

    ListWashpackService.getWashPacks().then((response)=>{
        setWashpacks(response.data)
        console.log(response.data);
    }).catch(error=>{
        console.log(error);
    })

   },[])

   const Logout=()=>{
    navigate("/login");
    alert("logged-out");
  }


  return (
    <div className="container">
        <h2 className="text-center">WashPack List</h2>
        <table className="table table-bordered table-striped">
            <thead>
                {/* <th>WashPackId</th> */}
                <th>WashPack Name</th>
                <th>WashPack description</th>
                <th>WashPack Cost</th>
                <th>Booking</th>
            </thead>
            <tbody>
                {
                    washpacks.map(
                        washpack=>
                        <tr key={washpack.id}>
                            {/* <td>{washpack.washPackId}</td> */}
                            <td>{washpack.washPackName}</td>
                            <td>{washpack.washPackDescription}</td>
                            <td>{washpack.washPackCost}</td>
                            <td><Link to={`/mailer/${washpack.washPackCost}`}  class="btn btn-primary">book</Link></td>
                        </tr>
                    )
                }
            </tbody>
            <button className="btn btn-primary"  onClick={()=>Logout()}>Logout</button>
        </table>
        
    </div>
  )
}
export default ListWashpackComponent;