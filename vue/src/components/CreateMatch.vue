<template>
  <div id="create-match">
    
    <form class="new-match" > <!-- need to add v-on:submit.prevent="addNewScore" except addnewmatch method -->
      <h1 id="create-header">Create New Match:</h1>

      <label for="match" class="all-labels">Select League: </label>
      <select name="courseList" id="courseList" :multiple="true" v-model="singleLeagueList">
        <option value="" disabled>----Select League for Match----</option>
        <option v-for='league in leaguesList' v-bind:key='league.id' v-bind:id="league.id" v-bind:value="league.leagueId" v-on:click="getPlayers(league.leagueId)">{{league.leagueName}}</option>
      </select>
      <br> 

      <label for="userList" class="all-labels">Players in Match:</label>
      <select name="userList" id="userList" :multiple="true" v-model="singleLeagueList">
        <option value="" disabled>----Select Users for Match----</option>
        <option v-for="member in singleLeagueList" :value="member.id" :key="member.id">{{member.name}}</option><br>
      </select>

      <label for="score">Tee Time:</label>
      <input class="all-labels" placeholder="Enter your Tee Time: " /><br>

      <label for="score">Date:</label>
      <input class="all-labels" placeholder="Enter your score" />

      <button id="MatchButton" v-on:click="push">Add New Match</button> <br>
      
    </form>
      <br>
      </div>
     
</template>

<script>
import LeagueService from '../services/LeagueService.js';
export default {
    name: "create-match",
  data() {
    return {
      selectedUserList: [],
      courseList: [],
      leaguesList: [],
      leagueId: "",
      pickedLeague: {},
      selectedCourse: {}
    }
  },
  computed: {
      singleLeagueList() {
        return this.selectedUserList;
      }
  },
  created() {
      LeagueService.getAllLeagues().then(
          (response) => {
            this.leaguesList = response.data;
          }
      );
  },
  methods: {
    getPlayers(id) {
    LeagueService.listPlayersInLeague(id).then(
      (response) => {
        this.selectedUserList = response.data;
      }
    );
    },
    push() {
      window.alert('Your match is set! See you then')
      this.$router.push('/')
    }
  }

}
</script>

<style scoped>
 #create-match {
   margin-top: 5rem;
  background-color: #F7ECDE;
  padding: 3rem;
  border-radius: 5px;
  width: 100%;
  height: 70%;
  justify-content: flex-end;
  }
  #create-header {
    font-size: 1.5rem;
  }
  #all-inputs {
    display:flex;
    flex: 1;
  }
  #all-labels {
    display: flex;
    flex: 1;
  }
  .new-match {
    display: flex;
    align-content: center;
    justify-content: center;
    flex-direction: column;
    width: 100%;
    height: 100%;
    text-align: center;
  }
  
  #MatchButton {
    margin-top: 1rem;
    margin-right:3rem;
    margin-left: 3rem;
  }
</style>>

