
import React from "react";
import { Link } from "react-router-dom";



function SucessComponent() {
  return (
    <div className="container" align="center">
      <h1 className="text-center">sucessfuly registered!</h1>
      <Link to="/login">Login here</Link>

      
    </div>
  );
}

export default SucessComponent;
