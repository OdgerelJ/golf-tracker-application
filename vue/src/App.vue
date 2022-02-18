<template>
  <div id="app">
    <!-- <locations></locations>  -->
    <nav-links />
   
      <header id="showcase">
        <router-view />
      </header>
    <golf-info v-if="$store.state.token == ''"/>
      
    
  </div>
</template>

<script>

import GolfInfo from './components/golf-info.vue';
import NavLinks from "./components/NavLinks.vue";

export default {
  components: {GolfInfo, NavLinks},
  data() {
    return {
    
    };
  },
};
</script>


<style>
body {
  margin: 0;
  font-family: Arial, "Helvetica Neue", Helvetica, sans-serif;
  font-size: 17px;
  color: #926239;
  line-height: 1.6;
}

/* This adds background image */
#showcase {
  background-image: url(./image/course-img.jpg);
  height: 100vh;
  background-size: cover;
  background-position: center;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  padding: 0 20px;
  text-align: center;
}
</style>
 
