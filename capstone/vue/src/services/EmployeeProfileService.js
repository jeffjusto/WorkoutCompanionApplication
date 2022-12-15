import axios from 'axios';
const http = axios.create({
    baseURL: "http://localhost:9000/profiles"
})
export default {

    create(employee) {
        return http.post(`/employee`, employee);
    }
    
}