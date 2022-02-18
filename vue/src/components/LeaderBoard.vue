<template>
  <div id="leaderboard">
    <h1 id="leaderboard-h1">Leaderboard:</h1>

    <div id="leaderboard-wrapper">
    <div id="leaderboard-container" v-for="golfScore in leaderboardList" :key="golfScore.scoreId">
      Player name:{{golfScore.username}} <br>
      Your game score:{{golfScore.score}} <br>
      Course name:{{golfScore.courseName}} <br>
      Played Date: {{golfScore.golfDate}} <br>
    </div>
    </div>

  </div>
</template>

<script>
import courseService from "../services/CourseService";

export default {
    name: "Leaderboard",
    mounted() {
        courseService.getLeaderboard().then((responce) => {
        console.log("Display score method called");
        this.leaderboardList = responce.data;
      });
    },
    data() {
      return {
        leaderboardList: [],
      }
    }
}
</script>

<style scoped>
#leaderboard {
  background-color: #f7ecde;
  padding-top: 1rem;
  padding-bottom: 1rem;
  border-radius: 10px;
  padding-left: 1rem;
  padding-right: 1rem;
  display: flex;
  justify-content: flex-start;
  align-content: center;
  flex-direction: column;
  width: 25vw;
}

#leaderboard-h1 {
  font-size: 1.5rem;
  align-items: flex-start;
  justify-content: flex-start;
}

.leaderboard {
  background-color: white;
  width: 50vh;
  height: 50vh;
  margin-top: 1rem;
  border: 1px solid  #BF9270;
  border-radius: 2px;
 }

#leaderboard-container {
  border: 1px solid #bf9270;
  background-color: white;
}

#leaderboard-wrapper {
  overflow: scroll;
}

@media only screen and (max-width: 832px) {

#leaderboard-container {
  font-size: 0.8rem;
}

#leaderboard-h1 {
  font-size: 1.0rem;
}
}
</style>