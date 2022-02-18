import axios from 'axios';

//should probably be logged in user to make a league
export default {
    addLeague(league){
        return axios.post('/newLeague', league);
    },
    addUserLeague(userLeague) {
        return axios.post('/newUserLeague', userLeague);
    },
    getAllLeagues(){
        return axios.get('/allLeagues');
    },
    listPlayersInLeague(leagueId) {
        console.log(leagueId)
        return axios.get(`/allPlayersName/${leagueId}`);
    }
}