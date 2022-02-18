<template>
<div id="google_map">
  <!-- <gmap-map :zoom="10" :center="center" style="width: 80vh; height: 60vh"> -->
    <!-- <gmap-marker
      :key="index"
      v-for="(m, index) in locationMarkers"
      :position="m.position"
      @click="center = m.position"
    ></gmap-marker>
  </gmap-map> -->
</div>
</template>
 
<script>
// import Locations from '../components/Locations.vue';
export default {
  // components: {},
  name: "FindCourse",
  data() {
    return {
      selectedCourse: {},
      courses: [],
      search: "",
      center: {
        lat: 39.7837304,
        lng: -100.4458825,
      },
      locationMarkers: [],
      locPlaces: [],
      existingPlace: null,
    };
  },
  mounted() {
    this.existingPlace = this.$store.state.courses;
  },
  computed: {
    filteredCourses: function () {
      return this.courses.filter((course) => {
        return course.title.match(this.search);
      });
    },
  },
  methods: {
    initMarker(loc) {
      this.existingPlace = loc;
    },
    addLocationMarker() {
      if (this.existingPlace) {
        const marker = {
          lat: this.existingPlace.geometry.location.lat(),
          lng: this.existingPlace.geometry.location.lng(),
        };
        this.locationMarkers.push({ position: marker });
        this.locPlaces.push(this.existingPlace);
        this.center = marker;
        this.existingPlace = null;
      }
    },
  },
};
</script>
<style>
</style>
