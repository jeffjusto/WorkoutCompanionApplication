import axios from 'axios';

const http = axios.create({
    baseURL: "http://localhost:9000"
})

export default {
    getAll() {
        return http.get(`/profiles`);
    },

    getProfile(id) {
        return http.get(`/profiles/${id}`);
    },

    create(profile) {
        return http.post(`/profiles`, profile);
    },

    update(id, profile) {
        return http.put(`/profiles/${id}`, profile);
    }
}