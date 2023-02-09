import { useNavigate } from "react-router-dom";



const BookComponent = () => {
    const navigate=useNavigate();

    //const {cost}=useParams();
    const Logout=()=>{
        navigate("/login");
        alert("logged-out");
      }

    
    return (
        <div className="container pay" >
            <div class="card-body" align="center" >
             {/* <img src="/assets/Paytm-Logo.jpg"  alt="Baground" height="600px"/>  */}
            <br></br>
            <h1 >Confirm your Booking through </h1>
            <img src="/assets/Paytm_Logo.png"  alt="Baground" height="50px"/> 
            
            <h1 >Check your email to pay</h1>
            <h1>OR</h1>
            <h1>Click the below link to pay(prefer using phone) other Payment details will be shaired to you through mail</h1>

            <a href=" https://p.paytm.me/xCTH/r3yhhl73 " > https://p.paytm.me/xCTH/r3yhhl73 </a><hr></hr>
            <button className="btn btn-primary" onClick={()=>Logout()}>Logout</button>
            </div>

            
        </div>
        
    );
}

export default BookComponent;