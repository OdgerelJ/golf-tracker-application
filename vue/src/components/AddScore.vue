<template>
  <div id="add-score">

    <form id="addnewscore-form" v-on:submit.prevent="addNewScore">
      <h4 id="addnewscore-h4">Add new Score:</h4>

      <label for="score">Score:</label>
      <input class="form-control"  v-model="score.score" placeholder="Enter your score" /><br>

      <label for="course" class="all-labels">Course:</label>
      <select name="course" id="course" v-model="selectedCourse">
        <option value="" disabled>----Select Course----</option>
        <option v-for="course in $store.state.allCourses" :value="course" :key="course.courseId">{{course.courseName}}</option>
      </select><br>
      
      <!-- <label for="course">Course:</label>
      <input
        class="form-control" v-model="score.courseId" 
        placeholder="Course id/Course name"
      /> <br> -->

      <label for="score">Date:</label>
      <input class="form-control" type="date" v-model="score.golfDate" placeholder="YYYY-MM-DD" />
      <br>
      <button id="ScoreButton" >Add New Score</button> <br>

    </form>
  </div>
</template>

<script>
import CourseService from "../services/CourseService";
export default {
  name: "add-score",
  data() {
    return {
      score: {
        score: "",
        courseId: "",
        golfDate: "",
      },
      selectedCourse: {}
    };
  },
  methods: {
    addNewScore() {
      console.log("Adding new score");
      this.score.courseId = this.selectedCourse.courseId;
      const newScore = {
        score: this.score.score,
        courseId: this.score.courseId,
        golfDate: this.score.golfDate,
      };
      console.log(newScore);
      const config = {
        headers: { Authorization: `Bearer ${this.$store.state.token}` },
      };
      CourseService.addScores(newScore, config).then((response) => {
        if (response.status == 201) {
          alert("score added!");
          // location.reload();
        }
      });
    },

  },
};
</script>

<style>
#add-score {
  border: 2px solid #bf9270;
  margin: 0.2rem;
  padding: 0.3rem;
  border-radius: 5px;
  width: 80%;
  height: 50%;
}

#addnewscore-h4 {
  margin-top: 0.5rem;
  margin-bottom: 0.5rem;
}

#addnewscore-form label {
  font-size: 0.9rem;
}

#addnewscore-form {
  width: 100%;
  height: 50%; 
  align-content: center;
  justify-content: center;
}

@media only screen and (max-width: 820px) {

#add-score {
  border: 2px solid #bf9270;
  margin: 0.2rem;
  padding: 0.3rem;
  padding-left: 10rem;
  border-radius: 5px;
  width: 80%;
  height: 50%;
  }

#addnewscore-form input {
  width: 60%;
  height: 20%;
  }
  
#addnewscore-form label {
  font-size: 0.8rem;
  }

#ScoreButton {
  width: 4rem;
  height: 1.3rem;
  font-size: 0.5rem;
  }

.form-control::placeholder {
  font-size: 0.5rem;
}
}
</style>