<template>
  <div id="register" class="form-container">
    <form class="form-register" @submit.prevent="register">
      <h1 class="h3 mb-3 font-weight-normal">Create Account</h1>
      <div class="alert alert-danger" role="alert" v-if="registrationErrors">
        {{ registrationErrorMsg }}
      </div>
      <label for="username" class="sr-only">Username</label>
      <input
        type="text"
        id="username"
        class="form-control"
        placeholder="Username"
        v-model="user.username"
        required
        autofocus
      />
      <label for="password" class="sr-only">Password</label>
      <input
        type="password"
        id="password"
        class="form-control"
        placeholder="Password"
        v-model="user.password"
        required
      />
      <input
        type="password"
        id="confirmPassword"
        class="form-control"
        placeholder="Confirm Password"
        v-model="user.confirmPassword"
        required
      />
      <router-link id="login" :to="{ name: 'login' }">Have an account?</router-link>
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

<style>
 form {
    display: flex;
    flex-direction: column;
  }

  input {
    display: flex;
    margin-top: 2px;
    height: 25px;
    width: 400px;
    background-color: FFFFFF;
  }

  button {
    margin: auto;
    width: 80px;
  }

  label {
    color: #FFFFFF;
  }

  .form-container {
    display: flex;
    flex-direction: column;
    align-items: center;
    background-color: #31394D;
    border-radius: 6px;
    height: 350px;
    width: 600px;
    margin: 20px;
    padding: 40px 20px 20px 20px;
    text-align: center;
    box-shadow: 0 12px 13px rgba(0,0,0,0.16), 0 12px 13px rgba(0,0,0,0.16);
    transition: all 0.3s cubic-bezier(.25,.8,.25,1);
    font-family: Arial, Helvetica, sans-serif;
    color:#ffffff;
    margin: auto;
  }

  .btn {
    border:none;
    height:30px;
    max-width: 300px;
    margin-top: 20px;
    color:#ffffff;
    width:35%;
    font-size:16px;
    border-radius:10px;
    box-shadow: 0 13px 26px rgba(0,0,0,0.16), 0 3px 6px rgba(0,0,0,0.16);
    background: linear-gradient(to top right, #8162CE, #F54BA5);
    }

  .btn:hover {
    cursor: pointer;
    transform: scale(1.02);
  }

  #login {
       color:#ffffff;
       margin-top: 10px;
       font-size: 16px;
       align-self: flex-end;
  }

   #login:hover {
      color:#F54BA5;
  }
</style>
