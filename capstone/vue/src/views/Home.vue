<template>
  <div class="home">
    <div class="card-container">
      <div id="update-profile" class="card" v-on:click="openForm">
        <font-awesome-icon icon="fa-solid fa-user" size="6x"/>
        <h2>UPDATE PROFILE</h2>
      </div>
      <div class="card">
        <font-awesome-icon icon="fa-solid fa-heart" size="6x"/>
        <h2>VIEW MY METRICS</h2>
      </div>
      <div class="card">
        <font-awesome-icon icon="fa-solid fa-calendar-days" size="6x"/>
        <h2>VIEW CALENDER</h2>
      </div>
    </div>
  </div>
</template>

<script>

export default {
  name: "home",
  methods: {
    openForm() {
      this.$router.push({name: 'updateProfile'});
    }
  }
};
</script>

<style scoped>
  i {
    color: white;
  }

  .card {
    display: flex;
    flex-direction: column;
    justify-content: center;
    gap: 30px;
    background-color: #31394D;
    border-radius: 6px;
    height: 500px;
    width: 300px;
    margin: 20px;
    padding: 40px 20px 20px 20px;
    box-shadow: 0 12px 13px rgba(0,0,0,0.16), 0 12px 13px rgba(0,0,0,0.16);
    transition: all 0.3s cubic-bezier(.25,.8,.25,1);
    font-family: Arial, Helvetica, sans-serif;
    color: #FFFFFF;
  }

  .card:hover {
    transform: scale(1.05);
    cursor: pointer;
  }
</style>
