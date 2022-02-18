// Display all leagues in league page as component
<template>
  <div id="display-all-league">
    <h1 id="league-h1">All leagues:</h1>
    <div id="league-wrapper">
      <div
        id="league-container"
        v-for="league in leagueList"
        :key="league.leagueId"
      >
        <!-- League name: {{league.name}}
              Number of Players:{{numberOfPlayers}}
              Players name:{{player}}
              Course name: -->
        {{ league.leagueName }}
    
      </div>
    </div>
  </div>
</template>

<script>
import LeagueService from "../services/LeagueService";
export default {
  name: "DisplayAllLeague",
  created() {
    LeagueService.getAllLeagues().then((response) => {
      console.log("getAllLeagues called");
      this.leagueList = response.data;
    });
  },
  data() {
    return {
      leagueList: [],
    };
  },
};
</script>

<style scoped>
#display-all-league {
  background-color: #f7ecde;
  margin-right: 10rem;
  padding-top: 1rem;
  padding-bottom: 1rem;
  border-radius: 10px;
  padding-left: 1rem;
  padding-right: 1rem;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  width: 95%;
  height: 93%;
}
#league-wrapper {
  overflow: scroll;
}
</style>