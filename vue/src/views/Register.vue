<template>
  <div id="register" class="text-center">
    <form class="form-register" @submit.prevent="register">
      <img src="../image/golf-logo.png" alt="golf-logo" class="logo" />
      <h1 class="h3 mb-3 font-weight-normal">Create Account</h1>
      <div class="alert alert-danger" role="alert" v-if="registrationErrors">
        {{ registrationErrorMsg }}
      </div>
      <label for="username" class="sr-only">Username </label>
      <input
        type="text"
        id="username"
        class="form-control"
        placeholder="Username"
        v-model="user.username"
        required
        autofocus
      /> <br>
      <label for="password" class="sr-only">Password </label>
      <input
        type="password"
        id="password"
        class="form-control"
        placeholder="Password"
        v-model="user.password"
        required
      /> <br>
      <label for="confirmPassword" class="sr-only">Confirm Password </label>
      <input
        type="password"
        id="confirmPassword"
        class="form-control"
        placeholder="Confirm Password"
        v-model="user.confirmPassword"
        required
      /> <br>
      <label for="e-mail" class="sr-only">Email </label>
      <input
        type="email"
        id="emailAddress"
        class="form-control"
        placeholder="email@email.com"
        v-model="user.emailAddress"
        required
      /> <br>
      <label for="Zipcode" class="sr-only">Zipcode </label>
      <input
        type="zipcode"
        id="zipcode"
        class="form-control"
        placeholder="5 digits"
        v-model="user.zipcode"
        required
      /> <br>
      <!-- <label for="Role" class="sr-only"> User </label>
      <input type="checkbox" checked="unchecked"> <br> -->

      <router-link :to="{ name: 'login' }">Have an account? </router-link>
      <button class="btn btn-lg btn-primary btn-block" type="submit">
        Create Account
      </button>
    </form>
  </div>
</template>

<script>
import authService from '../services/AuthService';

export default {
  name: 'register',
  data() {
    return {
      user: {
        username: '',
        password: '',
        confirmPassword: '',
        role: 'user',
        emailAddress: '',
        zipcode:''
      },
      registrationErrors: false,
      registrationErrorMsg: 'There were problems registering this user.',
    };
  },
  methods: {
    register() {
      if (this.user.password != this.user.confirmPassword) {
        this.registrationErrors = true;
        this.registrationErrorMsg = 'Password & Confirm Password do not match.';
      } else {
        authService
          .register(this.user)
          .then((response) => {
            if (response.status == 201) {
              this.$router.push({
                path: '/login',
                query: { registration: 'success' },
              });
            }
          })
          .catch((error) => {
            const response = error.response;
            this.registrationErrors = true;
            if (response.status === 400) {
              this.registrationErrorMsg = 'Bad Request: Validation Errors';
            }
          });
      }
    },
    clearErrors() {
      this.registrationErrors = false;
      this.registrationErrorMsg = 'There were problems registering this user.';
    },
  },
};
</script>

<style scoped>
.logo {
  width: 80px;
}

#register {
  background-color: #F7ECDE;
  padding-top: 1rem;
  padding-bottom: 1rem;
  border-radius: 10px;
}

.form-register {
  background-color: #F7ECDE;
  padding: 1rem;
  margin: 1rem;
  border-radius: 10px;
}

@media only screen and (max-width: 534px) {

  #register {
    display: flex;
  }

  .form-register {
    margin: 0, auto;
    padding: 1rem;
  }

  input {
    display: block;
    margin: auto;
  }
}

@media only screen and (min-width: 949px) {

  #register {
    padding: 1rem;
  }
  
}

</style>
