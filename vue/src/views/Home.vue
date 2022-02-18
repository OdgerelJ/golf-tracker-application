<template>
  <div class="home">

    <div id="leaderboardDiv">
      <leader-board/>
    </div>

    <!-- <div id="home-page-instructions">
    <h1 id="home-h1">Home</h1>
    <p id="home-page-info">Welcome to Tee Shot!<br>
      1) Start by finding the course you want to play
      at the Find Golf Course Page!<br>
      2) Use the Course ID to submit a score 
      where you played!
    </p>
    </div> -->

    <div id="scoreboardDiv">
      <score/>
    </div>
  <footer id="golf_info_footer">
   
  </footer>
  </div>
</template>

<script>
import LeaderBoard from '../components/LeaderBoard.vue';
import Score from '../components/Score.vue';

export default {
  components: {Score, LeaderBoard },
  name: "home",
};

</script>

<style scoped>

.home{
  padding: 20px;
  border-radius: 10px;
  margin-top: 5rem;
  display: flex;
  height: 100vh;
  width: 100vw;
  justify-content: space-evenly;
}

#scoreboardDiv {
  border-radius: 10px;
  display: flex;
  padding-left: 5rem;
  padding-right: 1rem;
  margin-left: 5rem;
  margin-right: 0;
  margin-top: 2rem;
  height: 80vh;
  justify-content: flex-end;
}

#leaderboardDiv {
  border-radius: 10px;
  display: flex;
  padding-left: 2rem;
  padding-right: 2rem;
  margin-left: 2rem;
  margin-right: 2rem;
  margin-top: 2rem;
  height: 80vh;
}

#home-h1 {
  color: #926239;
  font-size: 1rem;
  align-items: center;
  justify-content: center;
}

#home-page-info {
  color: #926239;;
  align-items: center;
  justify-content: center;
}

#home-page-instructions {
  background-color: #f7ecde;
  height: 40%;
  width: 30%;
  margin-top: 4rem;
  border-radius: 5px;
  margin-top: 3rem;
  padding: 1rem;
}

</style>
