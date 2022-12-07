import axios from 'axios';

const http = axios.create({
    baseURL: "http://localhost:9000"
})

export default {
    getAllProfiles() {
        return http.get('/profiles');
    },

    createNewProfile(profile) {
        return http.post('/profiles', profile);
    },

    updateProfile(profile) {
        return http.put('/profiles', profile);
    }
}