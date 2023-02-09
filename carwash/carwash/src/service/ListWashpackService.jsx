import axios from 'axios'

const WASHPACK_BASE_REST_API_URL="http://localhost:8081/washpack/viewall";

class ListWashpackService{
    getWashPacks(){
        return axios.get(WASHPACK_BASE_REST_API_URL)
    }
}

export default new ListWashpackService();