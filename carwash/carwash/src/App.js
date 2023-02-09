import { BrowserRouter as Router, Route, Routes} from 'react-router-dom'
import './App.css';
import Navbar from './component/Navbar';
import Home from './component/Home';
import Register from "./component/Register";
import Login from "./component/Login";
import ContactComponent from "./component/ContactComponent";
import SucessComponent from "./component/SucessComponent";
import ListWashpackComponent from './component/ListWashpackComponent';
import BookComponent from "./component/BookComponent";
import AdminDashboard from './component/AdminDashboard';
import AdminCustomerDashboard from './component/AdminCustomerDashboard';
import AddWasher from './component/AddWasher';
import AddCustomer from './component/AddCustomer';
import AdminLogin from './component/AdminLogin';
import Mailer from './component/Mailer';
import Payment from './component/Payment';

function App() {


  


  return (
    <>
    
    <Navbar/>
    

    
    
     <Router>
      <Routes>
        
          <Route path="/" element={<Home/>} exact/>
          <Route path="/register" element={<Register/>} exact/>
          <Route path="/login" element={<Login/>} exact/>
          <Route path="/contact" element={<ContactComponent/>} exact/>
          <Route path="/sucess" element={<SucessComponent/>} exact/>
          <Route path="/washpack" element={<ListWashpackComponent/>} exact/>
          <Route path="/pay" element={<BookComponent/>} exact/>
          <Route path="/admin" element={<AdminDashboard/>} exact/>
          <Route path="/add-washer" element={<AddWasher/>} exact/>
          <Route path="/update-washer/:washerId" element={<AddWasher/>} exact/>
          <Route path="/admin-customer" element={<AdminCustomerDashboard/>} exact/>
          <Route path="/add-customer" element={<AddCustomer/>} exact/> 
          <Route path="/update-customer/:customerId" element={<AddCustomer/>} exact/>
          <Route path="/admin-login" element={<AdminLogin/>} exact/>
          <Route path="/mailer/:cost" element={<Mailer/>} exact/>
          <Route path="/payment" element={<Payment/>} exact/>
    
      </Routes>
    </Router> 


  
    </>
  );
}

export default App;
