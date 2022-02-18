<template>
  <div id="create-league">
    <form class="create-league-form"  v-on:submit.prevent>
      <h1 id="create-header">Create New League</h1>

      <label for="league-name" class="all-labels">League Name: </label>
      <input
        type="text"
        id="league-name"
        class="form-control"
        placeholder=" Please enter your new league name"
        required
        v-model="league.leagueName"
      />
      <br />

      <!-- multi select for usernames -->
      <!-- Need multi select to grab all users at once-->
      <label for="userList" class="all-labels">Users:</label>
      <select name="userList" id="userList" :multiple="true" v-model="selectedUserList">
        <option value="" disabled>----Select Users for League----</option>
        <option v-for="user in userList" :value="user" :key="user.id">{{user.username}}</option>
      </select><br>

      <!-- select for courses -->
      <label for="course" class="all-labels">Course:</label>
      <select name="course" id="course" v-model="selectedCourse">
        <option value="" disabled>----Select Course----</option>
        <option v-for="course in $store.state.allCourses" :value="course" :key="course.courseId">{{course.courseName}}</option>
      </select><br>
      <button class="btn" v-on:click='addLeague'>Create</button>
    </form>
  </div>
</template>

<script>
import leagueService from "../services/LeagueService";
import UserService from "../services/UserService";
import CourseService from '../services/CourseService';

export default {
  name: "create-league",
  data() {
    return {
      league: {
        leagueName: "",
        courseId: "",
        members: "",
      },
      userList: [],
      selectedUserList: [],
      courseList: [],
      selectedCourse: {}
    }
  },
  methods: {
    addLeague() {
      this.league.members = this.selectedUserList.length;
      this.league.courseId = this.selectedCourse.courseId;
      leagueService.addLeague(this.league).then((response) => {
        if (response.status == 201) {
          console.log(response.data);
          alert("League Added!" + response.data.id);
          const id = response.data.id;
          for (const user of this.selectedUserList) {
            const body = {
              leagueId: id,
              userId: user.id
            }
            console.log(body)
            console.log(user)
            leagueService.addUserLeague(body)
          }
        }
      });
    },
  },
  mounted() {
    UserService.getAllRegisteredUsers().then((response) => {
        this.userList = response.data;
      });
    CourseService.getAllCourses().then((response) => {
        this.courseList = response.data;
    })
  }
};
</script>

<style scoped>
#create-league {
  background-color: #f7ecde;
  padding: 20px;
  border-radius: 10px;
  margin: 0 auto;
  display: flex;
  height: 92%;
  width: 100%;
  justify-content: space-between;
}
#create-header {
  margin-left: 3rem;
  padding-top: 10%;
  display: flex;
  align-items: center;
}
.create-league .btn {
  font-size: 18px;
  color: #926239;
  border-radius: 10px;
}
.create-league .btn:hover {
  background-color: #926239;
  color: #fff;
}
.create-league-form {
  background-color: #f7ecde;
}
</style>