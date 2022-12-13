import axios from "axios";
const http = axios.create({
    baseURL: "http://localhost:9000/calendar"
})

export default {
    getAll(){
        return http.get(`/schedule`);
    }
}