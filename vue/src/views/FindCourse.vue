<template>
  <div id="find-course">
    <h1 id="find-course-h1">Find a Course Near You</h1>
    <input
      id="search"
      type="text"
      v-model="search"
      placeholder=" search by course name"
    />
    <button id="button" v-on:click="findCourse">Search</button>

    <div id="details">
      <h4 id="coursedetails-h4">Course Details:</h4>
      Course Name:{{ courses.courseName }} <br />
      Address: {{ courses.address }}<br />
      City: {{ courses.city }}<br />
      State: {{ courses.stateName }}<br />
      Zipcode: {{ courses.zipcode }}<br />
      Course ID: {{courses.courseId}}
    </div>

     <div id="map"></div>
    <!-- <div
      v-for="course in filteredCourses"
      v-bind:key="course.id"
      class="single-course"
    ></div> -->
    <!-- <br /> -->
    <br />

  </div>
</template>
 
<script>

import CourseService from "../services/CourseService.js";
export default {
  components: {  },
  name: "FindCourse",
  data() {
    return {
      courses: [],
      search: "",
      map: null,
    mapCenter: { lat: 38.5948096, lng: -84.8355755 },
    courseObj: {
      coord: {lat: 0, lng: 0},
       name : ''
    }   
     };
  },
  // computed: {
  //   filteredCourses: function () {
  //     return this.courses.filter((course) => {
  //       return course.title.match(this.search);
  //     });
  //   },
  // },
  methods: {
    findCourse() {
      CourseService.filterCourses(this.search).then((response) => {
        console.log(response.data);
        this.courses = response.data;
        // let address = `${this.courses.address}, ${this.courses.city}, ${this.courses.stateName} ${this.courses.zipcode}`;
       
        this.courseObj.coord.lat =  parseFloat(response.data.latitude);
        this.courseObj.coord.lng = parseFloat(response.data.longitude); 
        this.courseObj.name = response.data.courseName;

        this.mapCenter.lat =  parseFloat(response.data.latitude);
        this.mapCenter.lng = parseFloat(response.data.longitude);
       this.initMap();


   this.dropPin(this.courseObj);

        this.$store.commit("SAVE_COURSE", this.courses);
      });
    },
    initMap() {
      this.map = new window.google.maps.Map(document.getElementById("map"), {
        center: this.mapCenter,
        zoom: 12,
        maxZoom: 20,
        minZoom: 3,
        streetViewControl: true,
        mapTypeControl: true,
        fullscreenControl: true,
        zoomControl: true,
      });
      let noPOIStyle = [
        {
          featureType: "poi",
          elementType: "labels",
          stylers: [{ visibility: "off" }],
        },
      ];
      this.map.setOptions({ styles: noPOIStyle });
    },
        dropPin(markerObj) {
      new window.google.maps.Marker({
        position: markerObj.coord,
        map: this.map,
        label: {
          text: markerObj.name,
          color: "blue",
        },
      });
    },
  },
  mounted() {
        // this.initMap();

  }
};
</script>
<style scoped>
#map {
  grid-area: map;
  width: 500px;
  height: 400px;
  padding: 25px;
  margin: 25px;
}
#find-course {
  background-color: #f7ecde;
  padding-top: 1rem;
  padding-bottom: 1rem;
  border-radius: 10px;
  padding-left: 1rem;
  padding-right: 1rem;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  height: 100vh;
  width: 60vw;
}
#find-course-h1 {
  padding-top: 1.5rem;
  display: flex;
  align-items: center;
  justify-self: center;
  font-size: 1rem;
}
#search {
  margin: 10px;
  width: 60%;
  border-radius: 5px;
  align-content: center;
}
#details {
  background-color: #e3b7a0;
  margin: 1rem;
  border: 1rem;
  width: 20vw;
  height: 20vh;
  border-radius: 5px;
  font-size: 0.6rem;
}
#button {
  font-size: 18px;
  color: #926239;
  border-radius: 10px;
}
#button:hover {
  background-color: #926239;
  color: #fff;
}

#coursedetails-h4 {
  margin-top: 0.3rem;
  margin-bottom: 0.3rem;
  font-size: 0.8rem;
}
</style>