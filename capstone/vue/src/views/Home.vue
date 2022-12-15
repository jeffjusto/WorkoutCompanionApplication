<template>
  <div class="home">
    <div class="title">
      <h1>WELCOME TO KEN'S GYM</h1>
      <img src="https://i.pinimg.com/originals/4c/8c/d7/4c8cd70f405973e8266f2daec824395a.png" alt="Gym Logo">
      <h2>The gym where not even death is an excuse</h2>
    </div>
   
    <div class="card-container">
      <div class="gym-log-div-container">
        <gym-log-div class="gym-log-div">
          <font-awesome-icon icon="fa-solid fa-stopwatch" size="6x" />
        </gym-log-div>
      </div>
      <div id="view-profile" class="card" v-on:click="openProfile">
        <font-awesome-icon icon="fa-solid fa-user" size="6x" />
        <h2>VIEW MY PROFILE</h2>
      </div>
      <div class="card" v-on:click="openEquipmentList">
        <font-awesome-icon icon="fa-solid fa-dumbbell" size="6x" />
        <h2>VIEW MACHINES</h2>
      </div>
      <div class="card" v-on:click="openMyMetrics">
        <font-awesome-icon icon="fa-solid fa-heart" size="6x" />
        <h2>VIEW MY METRICS</h2>
      </div>
      <div class="card" v-on:click="openCalendar">
        <font-awesome-icon icon="fa-solid fa-calendar-days" size="6x" />
        <h2>VIEW CALENDER</h2>
      </div>
      <div class="card" v-on:click="openGymLog">
        <font-awesome-icon icon="fa-solid fa-stopwatch" size="6x" />
        <h2>VIEW GYM LOG</h2>
      </div>
      <div class="card grey" v-on:click="openProfilesList">
        <font-awesome-icon icon="fa-solid fa-people-group" size="6x" />
        <h2>VIEW ALL PROFILES</h2>
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
    openProfile() {
      this.$router.push({
        name: 'my-profile',
        params:{ profileId: this.$store.state.user.id }
      });
    },

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
      this.$router.push({
        name: 'gymLog',
        params:{ userId: this.$store.state.user.id }
        });
    },
    openCalendar(){
      this.$router.push({name: 'calendar'});
    },
    openMyMetrics(){
      this.$router.push({name: 'myMetrics'});
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
    margin-top: 50px;
    text-align: center;
  }

  .card-container {
    margin-top: 100px;
    display: flex;
    flex-direction: row;
    justify-content: flex-start;
    gap: 10px;
    flex-wrap: wrap;
    width: 90%;
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

  .gym-log-div:hover {
    transform: scale(1.05);
    cursor: pointer;
  }

  .grey {
    background-color: #808B96;
  }

  .grey:hover {
    cursor: not-allowed;
  }

  .title {
    background: linear-gradient(to top right, #8162CE, #F54BA5);
    display: flex;
    flex-direction: column;
    border-radius: 6px;
    color: #FFFFFF;
    width: 30%;
    margin: auto;
    align-items: center;
  }

  img {
    max-width: 100px;
  }
</style>
