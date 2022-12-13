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

  nav {
    font-family: Arial, Helvetica, sans-serif;
  }

  a:hover { text-decoration: none; color:yellow; }
a:focus { text-decoration: none; color:orange; }
a:active { text-decoration: none; color:teal; }
</style>