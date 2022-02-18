<!--Could use this component for displaying courses after logged in on home page
Trying to make connection to the database in here-->
<template>
  <div>
      <div class='course' v-for = 'course in courseList' v-bind:key = 'course.id'>
        {{courseid}} <br>
        {{course.name}}
    </div>
  </div>
</template>

<script>
import courseService from '@/services/CourseService.js';
export default {
name: "display-course",
data() {
    return {
      courseList: []
    }
  },
  //creating lifecycle hook 91:11 review video
  created(){
    courseService.getAllCourses().then(
    (response) => {
      this.courseList = response.data;
    }
    );
  }
};
</script>

<style>

</style>