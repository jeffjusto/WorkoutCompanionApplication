<template>
  <div id="login" class="form-container">
    <form class="form-signin" @submit.prevent="login">
      <h1 class="h3 mb-3 font-weight-normal">Please Sign In</h1>
      <div
        class="alert alert-danger"
        role="alert"
        v-if="invalidCredentials"
      >Invalid username and password!</div>
      <div
        class="alert alert-success"
        role="alert"
        v-if="this.$route.query.registration"
      >Thank you for registering, please sign in.</div>
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
      <router-link id="register" :to="{ name: 'register' }">Need an account?</router-link>
      <button class="btn" type="submit">Sign in</button>
    </form>
  </div>
</template>

<script>
import authService from "../services/AuthService";

export default {
  name: "login",
  components: {},
  data() {
    return {
      user: {
        username: "",
        password: ""
      },
      invalidCredentials: false
    };
  },
  methods: {
    login() {
      authService
        .login(this.user)
        .then(response => {
          if (response.status == 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
            this.$router.push("/");
          }
        })
        .catch(error => {
          const response = error.response;

          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
    }
  }
};
</script>

<style scoped>
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
    height: 300px;
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

  #register {
       color:#ffffff;
       margin-top: 10px;
       font-size: 16px;
       align-self: flex-end;
  }

   #register:hover {
      color:#F54BA5;
  }
</style>