<template>
  <div id="score-page">
    <add-score />
    <h4 id="scoreboard-h4">Your Previous Scores:</h4>
    <button type="Submit" id="ScoreButton" v-on:click.prevent="displayScore">
      Display My Scores
    </button>

    <div id="score-wrapper">
      <div id="score-container" v-for="golfScore in scoresList" :key="golfScore.scoreId">
        Your score:{{ golfScore.score }} <br>
        Course name:{{golfScore.courseName}} <br>
        Played Date: {{ golfScore.golfDate }} <br>
      </div>
    </div>

  </div>
</template>

<script>
import courseService from "../services/CourseService";
import AddScore from "./AddScore.vue";
export default {
  components: { AddScore },
  name: "Score",
  data() {
    return {
      scoresList: [],
    };
  },
  methods: {
    displayScore(user_id) {
      courseService.getUserScores(user_id).then((response) => {
        console.log("Display score method called");
        this.scoresList = response.data;
      });
    },
  },
};
</script>

<style scoped>
#score-button {
  padding-bottom: 0.5rem;
}

#score-page {
  background-color: #f7ecde;
  padding-top: 1rem;
  padding-bottom: 1rem;
  border-radius: 10px;
  padding-left: 1rem;
  padding-right: 1rem;
  display: flex;
  flex-direction: column;
  justify-content: flex-start;
  align-items: center;
  width: 25vw;
}

#scoreboard-h4 {
  margin-top: 0.5rem;
  margin-bottom: 0.5rem;
}

#score-container {
  background-color: white;
  width: 95%;
  height: 40%;
  border: 1px solid #bf9270;
  border-radius: 5px;
  font-size: 0.85rem;
}

#score-wrapper {
  overflow: scroll;
  width: 100%;
  height: 80%;
}

@media only screen and (max-width: 1083px) {
  #score-container {
    font-size: 0.7rem;
  }
}

</style>