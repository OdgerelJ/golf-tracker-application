<template>
<div id="new-match-score">
    <form class="create-match-score"  v-on:submit.prevent>
      <h1 id="create-header">New Match Score</h1>

<label for="match-score">Match ID:</label>
      <input class="match-id"  v-model="score.matchId" placeholder="Enter your match ID here"/><br>

      <label for="match-score">Match Score:</label>
      <input class="match-score"  v-model="score.score" placeholder="Enter your match score here"/><br>
      <button id="addMatchScore"> Add Match Score</button>
    </form>
  </div>
</template>

<script>
export default {
name: 'add-match-score',
data() {
    return {
        score: {
            matchId: "",
            score: ""
        },
        selectedMatch: {}
    }
}
}
</script>

<style scoped>
  #new-match-score {
  display: flex;
  background-color: #f7ecde;
  margin-top: 1rem;
  padding: 0.3rem;
  border-radius: 5px;
  width: 100%;
  height: 30%;
  }

  #create-header {
    font-size: 1.5rem;
  }


</style>>