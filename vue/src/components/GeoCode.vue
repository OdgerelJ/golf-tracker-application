<template>
  <div></div>
</template>
<script>
import geocodeService from "../services/GeoCodeService";
export default {
  data() {
    return {
      lat: 0,
      lng: 0,
    };
  },
  created() {
    let address = "5601 Boulder Blvd., Sarasota, FL, 34233";
    geocodeService.getLatLng(address).then((data) => {
      this.lat = data.data.results[0].geometry.location.lat;
      this.lng = data.data.results[0].geometry.location.lng;
      console.log("lat: " + this.lat);
      console.log("lng: " + this.lng);
    });
  },
};
</script>
<style>
</style>