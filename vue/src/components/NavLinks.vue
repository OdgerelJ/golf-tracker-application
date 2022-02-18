<template>
  <div>
    <nav id="nav-header">
      <img src="../image/golf-logo.png" alt="golf-logo" class="logo-nav" />
      <h1 id="GolfTracker">Tee Shot</h1>
      <div id="myLinks">
      <router-link v-bind:to="{ name: 'home' }">Home</router-link>
      <router-link
        v-bind:to="{ name: 'register' }"
        v-if="$store.state.token == ''"
        >Register</router-link
      >
      <router-link v-bind:to="{ name: 'find-course' }"
        >Find Golf Course</router-link
      >
      <router-link
        v-bind:to="{ name: 'create-league' }"
        v-if="$store.state.token != ''"
      >
        Create League
      </router-link>
      <router-link v-bind:to="{name: 'match'}" v-if="$store.state.token != ''">
        Match
      </router-link>
      <router-link
        v-bind:to="{ name: 'logout' }"
        v-if="$store.state.token != ''"
        >Logout</router-link
      >
      </div>
      <img src="../image/menu.png" alt="hamburger icon" id="hamburger" v-on:click="clickHamburgerMenu"/>
    </nav>
  </div>
</template>

<script>
export default {
  name: "nav-links",
  methods: {
    clickHamburgerMenu() {
      let x = document.getElementById("myLinks");
      if (x.style.display === "block") {
        x.style.display = "none";
      } else {
        x.style.display = "block";
      }
    },
  },
};
</script>

<style>

.logo-nav {
  width: 40px;
  height: 40px;
  padding-right: 1rem;
}

#nav-header {
  width: 100%;
  height: 10%;
  background-color: #f7ecde;
  position: fixed;
  top: 0;
  display: flex;
  justify-content: left;
  font-size: 1.5rem;
  text-decoration: none;
  align-items: center;
  padding-left: 1rem;
  padding-right: 1rem;
}

#nav-header h1 {
  display: flex;
  text-align: left;
  padding-right: 2rem;
}

#nav-header a:hover {
  text-decoration: none;
  background-color: #926239;
  color: white;
}

#nav-header a {
  padding-left: 1rem;
  padding-right: 1rem;
  color: #926239;
  text-decoration: none;
}

#hamburger {
  display: none;
}

@media only screen and (max-width: 934px) {
  #GolfTracker {
    font-size: 1.7rem;
  }

  #nav-header {
    font-size: 1.2rem;
  }

  #nav-header a {
    padding-left: 0.5rem;
    padding-right: 0.5rem;
  }

  #hamburger {
    display: none;
  }
}

@media only screen and (max-width: 727px) {
  #GolfTracker {
    font-size: 1.3rem;
  }

  #nav-header {
    font-size: 0.9rem;
  }

  #hamburger {
    display: none;
  }
}

@media only screen and (max-width: 588px) {
  #nav-header {
    align-items: center;
    justify-content: space-between;
  }

  #nav-header a {
    display: none;
  }

  #GolfTracker {
    font-size: 2rem;
    display: flex;
    text-align: center;
    align-items: center;
    justify-content: center;
    margin-left: 2rem;
  }

  #hamburger {
    display: flex;
    width: 40px;
    height: 40px;
    margin-right: 2rem;
    padding: 1rem;
  }

  #hamburger:hover {
    background-color: #926239;
    cursor: pointer;
  }
}
</style>