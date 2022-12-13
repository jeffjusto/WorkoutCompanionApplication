import axios from 'axios';

const http = axios.create({
    baseURL: "http://localhost:9000"
})

export default {

    getAll() {
        return http.get(`/gymLog`);
    },

    getAllById(id) {
        return http.get(`/gymLog/${id}`);
    },

    create(gymLog) {
        return http.post(`/gymLog`, gymLog);
    },

    update(id, gymLog) {
        return http.put(`/gymLog/${id}`, gymLog);
    }


}