import axios from 'axios';

const http = axios.create({
    baseURL: "http://localhost:9000"
})

export default {

    create(equipmentLog) {
        return http.post(`/equipmentLog`, equipmentLog);
    }
}