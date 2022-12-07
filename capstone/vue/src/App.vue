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
  #app {
    background-color: #E2E1E0;
    /* background-image: url("https://images.unsplash.com/photo-1558611848-73f7eb4001a1?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MTh8fGd5bXxlbnwwfHwwfHw%3D&w=1000&q=80");
    background-repeat: no-repeat;
    background-size: cover;
    height: 100vh; */

  }
</style>