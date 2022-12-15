<template>
  <div id="app">
    <div id="nav">
      <router-link v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
    </div>
    <router-view />
  </div>
</template>

<style>
  html {

    background-image: url(https://i.stack.imgur.com/sBoeM.jpg);
    background-attachment: fixed;
    background-position: center;
    height: 100vh;
  }

  label {
    margin-top: 10px;
  }

  a {
    font-family: Arial, Helvetica, sans-serif;
    font-size: 1.5em;
    text-decoration: none
  }

  a:hover {
    text-decoration: none;
    color:#F54BA5;
  }

  a:focus {
    text-decoration: none;
    color:#F54BA5;
  }

  .router-link-active {
    text-decoration: none;
  }

  .router-link-visited {
    text-decoration: none;
  }
</style>