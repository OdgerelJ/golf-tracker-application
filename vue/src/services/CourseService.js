import axios from 'axios';

export default {
    // method to get all courses from db==> sending get request
    getAllCourses(){
        return axios.get('/allCourses');
    },

    filterCourses(search) {
        return axios.get('/findCourses?search=' + search);
    },

    //Gets all scores
    getAllScores(){
        return axios.get('/allScores');
    },

    // Adding new score to DB
    addScores(score, config){
        console.log(config)
        return axios.post('/newScore', score, config);
    },

    // This for specific user only
    getUserScores(user_id){
        return axios.get('/userScores', user_id);
    },

    getLeaderboard() {
        return axios.get('/leaderboard');
    }

}