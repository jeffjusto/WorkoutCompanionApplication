<template>
    <div id="calendar" class="calender-container">
        <calendar-month/>
        <button id="btn-schedule" type="button" v-on:click="openSchedule()">
          View Schedule
        </button>
    </div>
</template>
<script>
import CalendarMonth from '../components/CalendarMonth.vue';
export default {
    name: 'calendar',
    components: {
        CalendarMonth
    },
    methods: {
      openSchedule(){
        this.$router.push({name: 'schedule'});
      }
    }
};
</script>

<style scoped>
#app {
  font-family: "Avenir", Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2C3E50;
  margin-top: 60px;
}
body {
  font-family: sans-serif;
  font-weight: 100;
  --grey-100: #E4E9F0;
  --grey-200: #CFD7E3;
  --grey-300: #B5C0CD;
  --grey-800: #3E4E63;
  --grid-gap: 1px;
  --day-label-size: 20px;
}
ol,
li {
  padding: 0;
  margin: 0;
  list-style: none;
}

.calender-container {
  display: flex !important;
  flex-direction: column;
}

.calendar-month {
  margin-left: auto;
  margin-right: auto;
}

.calendar-month-header {
  display: flex;
  justify-content: space-between;
  background-color: #fff;
  padding: 10px;
}

.button{
  justify-content: center;
  gap: 50px;
  background-color: whitesmoke;
  border-color: thistle;
  height: 50px;
  width: 50px;
  margin: 50px;
  padding: 50px 50px 50px 50px;
}

#btn-schedule {
  margin: 50px auto 0 auto;
  border:none;
  height:50px;
  max-width: 300px;
  color:#ffffff;
  width:35%;
  font-size:16px;
  border-radius:30px;
  box-shadow: 0 13px 26px rgba(0,0,0,0.16), 0 3px 6px rgba(0,0,0,0.16);
  background: linear-gradient(to top right, #8162CE, #F54BA5);
}

.btn:hover{
  cursor: pointer;
  transform: scale(1.02);
}
</style>