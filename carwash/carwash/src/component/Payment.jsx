import React from "react";
import Stripe from "react-stripe-checkout";
import axios from "axios";

const Payment = () =>  {

async function handleToken(token) {
console.log(token);
await axios.post("http://localhost:8080/api/payment/charge", "", {         headers: {
  token: token.id,
  amount: 500,
},}).then(() => {
   alert("Payment Success");
   }).catch((error) => {
   alert(error);
   });
}
return (
<div className="App">
<Stripe
stripeKey="pk_test_51LkNUASBXarqJXJFJ3fECLOaRVS3brnKqgbtBV3RCepsNTRhORmp2LyevQ2SCZwCurgSc8WDbxpKHqt2uLdtw7gB0074Xz5YED"
token={handleToken}
/>
</div>
);
}
export default Payment;