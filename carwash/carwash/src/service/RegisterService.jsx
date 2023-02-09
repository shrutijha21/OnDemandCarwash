import axios from 'axios'

const CUSTOMER_BASE_REST_API_URL="http://localhost:8082/customer/";

class RegisterService{
    insertUserInfo(customer){
        return axios.post(CUSTOMER_BASE_REST_API_URL+"add", customer)
    }
}

export default new RegisterService();