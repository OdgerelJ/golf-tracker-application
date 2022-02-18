import axios from 'axios';

export default{
    
    addNewMatch(match){
        return  axios.post('/newMatch', match);
    },
    //this includes league_id, match_id in the body
    addLeagueMatch(leagueMatch) {
        return axios.post('/newUserLeague', leagueMatch);
    }
    // getAllMatch(){
    //     return axios.get('');
    // }


}