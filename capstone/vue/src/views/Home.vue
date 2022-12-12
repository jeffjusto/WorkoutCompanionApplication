<template>
  <div class="home">
    <div class="title">
      <h1>WELCOME TO KEN'S GYM</h1>
      <h2>The gym where not even death is an excuse</h2>
      <h3>Your user id is {{ this.$store.state.user.id }}</h3>
    </div>
   
    <div class="card-container">
      <div class="gym-log-div-container">
        <gym-log-div class="gym-log"></gym-log-div>
      </div>
      <div id="update-profile" class="card" v-on:click="openForm">
        <font-awesome-icon icon="fa-solid fa-user" size="6x" />
        <h2>UPDATE PROFILE</h2>
      </div>
      <div class="card">
        <font-awesome-icon icon="fa-solid fa-heart" size="6x" />
        <h2>VIEW MY METRICS</h2>
      </div>
      <div class="card" v-on:click="openCalendar">
        <font-awesome-icon icon="fa-solid fa-calendar-days" size="6x" />
        <h2>VIEW CALENDER</h2>
      </div>
      <div class="card" v-on:click="openProfilesList">
        <font-awesome-icon icon="fa-solid fa-people-group" size="6x" />
        <h2>VIEW ALL PROFILES</h2>
      </div>
      <div class="card" v-on:click="openEquipmentList">
        <font-awesome-icon icon="fa-solid fa-dumbbell" size="6x" />
        <h2>VIEW MACHINES</h2>
      </div>
      <div class="card">
        <font-awesome-icon icon="fa-solid fa-stopwatch" size="6x" />
        <h2>LOG WORKOUT</h2>
      </div>
      <div class="card" v-on:click="openGymLog">
        <font-awesome-icon icon="fa-solid fa-stopwatch" size="6x" />
        <h2>VIEW GYM LOG</h2>
      </div>
    </div>
  </div>
</template>

<script>
import GymLogDiv from '../components/GymLogDiv'

export default {
  name: "home",
  components: {
    GymLogDiv
  },
  methods: {
    openForm() {
      this.$router.push({name: 'updateProfile'});
    },

    openProfilesList() {
      this.$router.push({name: 'profiles'});
    },

    openEquipmentList() {
      this.$router.push({name: 'equipment'});
    },

     openGymLog() {
      this.$router.push({name: 'gymLog'});
    },
    openCalendar(){
      this.$router.push({name: 'calendar'});
    }
  }
};
</script>

<style scoped>
  * {
     font-family: Arial, Helvetica, sans-serif;
     
  }
  i {
    color: white;
  }

  .title {
    margin-top: 100px;
    text-align: center;
  }

  .card-container {
    margin-top: 100px;
  }
  
  .card {
    display: flex;
    flex-direction: column;
    justify-content: center;
    gap: 10px;
    background-color: #31394D;
    border-radius: 6px;
    height: 250px;
    width: 250px;
    margin: 20px;
    padding: 40px 20px 20px 20px;
    box-shadow: 0 12px 13px rgba(0,0,0,0.16), 0 12px 13px rgba(0,0,0,0.16);
    transition: all 0.3s cubic-bezier(.25,.8,.25,1);
    color: #FFFFFF;
  }

  .gym-log-div {
    display: flex;
    flex-direction: column;
    justify-content: center;
    gap: 10px;
    background-color: #31394D;
    border-radius: 6px;
    height: 250px;
    width: 250px;
    margin: 20px;
    padding: 40px 20px 20px 20px;
    box-shadow: 0 12px 13px rgba(0,0,0,0.16), 0 12px 13px rgba(0,0,0,0.16);
    transition: all 0.3s cubic-bezier(.25,.8,.25,1);
    color: #FFFFFF;
  }

   .active {
    background-color: #c2496c;
  }

   .inactive {
    background-color: #8cc66f;
  }

  .card:hover {
    transform: scale(1.05);
    cursor: pointer;
  }

   .gym-log:hover {
    transform: scale(1.05);
    cursor: pointer;
  }
</style>
