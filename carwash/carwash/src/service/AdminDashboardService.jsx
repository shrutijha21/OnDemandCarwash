import axios from 'axios'

const WASHER_BASE_REST_API_URL="http://localhost:8081/washer";
const CUSTOMER_BASE_REST_API_URL="http://localhost:8082/customer"

class AdminDashboardService{
    getAllWashers(){
        return axios.get(WASHER_BASE_REST_API_URL+"/view")
    }

insertWasherInfo(washerInfo){
        return axios.post(WASHER_BASE_REST_API_URL+"/add",washerInfo)
    }

    getById(washerId){
        return axios.get(WASHER_BASE_REST_API_URL+'/'+washerId);
    }

    updateWasherInfo(washerInfo, washerId){
        return axios.put(WASHER_BASE_REST_API_URL+"/update/"+washerId, washerInfo);
    }

    deleteWasherInfo(washerId){
        return axios.delete(WASHER_BASE_REST_API_URL+"/delete/"+washerId);
    }

    getAllUsers(){
        return axios.get(CUSTOMER_BASE_REST_API_URL+"/view")
    }

    insertUserInfo(customerInfo){
        return axios.post(CUSTOMER_BASE_REST_API_URL+"/add",customerInfo)
    }

    getCustomerById(customerId){
        return axios.get(CUSTOMER_BASE_REST_API_URL+'/'+customerId);
    }

    getByCustomerEmail(customerEmail){
        return axios.get(CUSTOMER_BASE_REST_API_URL+'/view/'+customerEmail);
    }

    updateUserInfo(customerInfo, customerId){
        return axios.put(CUSTOMER_BASE_REST_API_URL+"/update/"+customerId, customerInfo);
    }

    deleteUserInfo(customerId){
        return axios.delete(CUSTOMER_BASE_REST_API_URL+"/delete/"+customerId);
    }
}

export default new AdminDashboardService();