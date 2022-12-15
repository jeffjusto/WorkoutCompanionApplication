<template>
  <form class="card" v-on:submit.prevent="logEntry()">
    <div class="field">
      <label for="weight">Weight</label>
      <input type="text" placeholder="Weight" v-model="equipmentLog.weight">
    </div>
    <div class="field">
      <label for="reps">Reps</label>
      <input type="text" placeholder="Reps" v-model="equipmentLog.reps">
    </div>
    <div class="actions">
      <button class="btn" type="button" v-on:click="cancel()">Cancel</button>&nbsp;
      <button class="btn" type="submit">Log Workout</button>
    </div>
  </form>
</template>

<script>
import EquipmentLogService from '../services/EquipmentLogService';
import { differenceInMinutes } from 'date-fns';

export default {
  name: "equipment-log-form",
  data() {
    return {
      equipmentLog: {
        entryId: 0,
        userId: this.$store.state.user.id,
        equipmentId: 3,
        equipmentCheckIn: this.$store.state.equipmentCheckIn,
        equipmentCheckOut: "",
        equipmentTimeInterval: "",
        weight: "",
        reps: ""
      }
    }
  },
  methods: {
    cancel() {
      this.$router.push({name: 'equipment'});
    },
    setCheckInTimestamp() {
      this.$store.commit("SET_EQUIPMENT_LOG_CHECK_IN", Date.now());
    },
    logEntry() {
      this.equipmentLog.equipmentCheckOut = Date.now();
      this.equipmentLog.equipmentTimeInterval = differenceInMinutes(this.equipmentLog.equipmentCheckOut, this.equipmentLog.equipmentCheckIn);
      EquipmentLogService.create(this.equipmentLog).then(response => {
        if (response.status === 201) {
          this.$router.push({name: 'equipment'});
        }
      });
      this.equipmentLog = {
        entryId: 0,
        userId: this.$store.state.user.id,
        equipmentId: this.equipmentLog.equipmentId,
        equipmentCheckIn: "",
        equipmentCheckOut: "",
        equipmentTimeInterval: "",
        weight: "",
        reps: ""
      };
      this.$store.commit("SET_EQUIPMENT_LOG_SESSION");
    }
  }
} 

</script>

<style scoped>
  input {
    display: flex;
    margin-top: 2px;
    margin-bottom: 20px;
    height: 30px;
    width: 100%;
    background-color: FFFFFF;
  }

  label {
    color: #FFFFFF;
  }

  .card {
    display: flex;
    flex-direction: column;
    background-color: #31394D;
    border-radius: 6px;
    height: 500px;
    width: 300px;
    margin: 20px;
    padding: 40px 20px 20px 20px;
    text-align: center;
    box-shadow: 0 12px 13px rgba(0,0,0,0.16), 0 12px 13px rgba(0,0,0,0.16);
    transition: all 0.3s cubic-bezier(.25,.8,.25,1);
    font-family: Arial, Helvetica, sans-serif;
  }

  .container {
    display: flex;
    flex-direction: row;
    width: 80%;
    justify-content: center;
  }

  .btn{
    margin-top: 100px;
    border:none;
    height:30px;
    max-width: 300px;
    color:#ffffff;
    width:35%;
    font-size:16px;
    border-radius:10px;
    box-shadow: 0 13px 26px rgba(0,0,0,0.16), 0 3px 6px rgba(0,0,0,0.16);
    background: linear-gradient(to top right, #8162CE, #F54BA5);
    }

  .btn:hover{
    cursor: pointer;
    transform: scale(1.02);
  }
</style>