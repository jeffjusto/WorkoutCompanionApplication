import axios from 'axios';

const http = axios.create({
    baseURL: "http://localhost:9000"
})

export default {

    get(username) {
        return http.getAll(`/user/${username}`);
    }
}