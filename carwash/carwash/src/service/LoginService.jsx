import axios from 'axios';
const CUSTOMER_BASE_REST_API_URL="http://localhost:8082/authenticate";

class LoginService{

    createAuthenticationToken(loginData)
    {
        return axios.post(CUSTOMER_BASE_REST_API_URL, loginData)
    }
}
export default new LoginService();