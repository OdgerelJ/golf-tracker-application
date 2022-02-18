import axios from 'axios';

export default {

    getAllRegisteredUsers() {
        return axios.get('/allUsers');
    }
}