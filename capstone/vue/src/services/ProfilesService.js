import axios from 'axios';

const http = axios.create({
    baseURL: "http://localhost:9000"
})

export default {
    getAll() {
        return http.get('/profiles');
    },

    create(profile) {
        return http.post('/profiles', profile);
    },

    update(profile) {
        return http.put('/profiles', profile);
    }
}