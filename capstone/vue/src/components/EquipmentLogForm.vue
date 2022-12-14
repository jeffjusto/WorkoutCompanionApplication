<template>
    <form v-on:submit.prevent="logEntry()">
      <div class="field">
        <label for="name">Weight</label>
        <input type="text" v-model="equipmentLog.weight">
      </div>
      <div class="field">
        <label for="email">Reps</label>
        <input type="text" v-model="equipmentLog.reps">
      </div>
      <div class="actions">
        <button type="button" v-on:click="cancel()">Cancel</button>&nbsp;
        <button type="submit">Log Workout</button>
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
        equipmentId: 1,
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
  .card {
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
</style>

 // saveProfile() {
    //   this.$store.commit('SAVE_PROFILE', this.profile);
    //   this.profile = {
    //     name: '',
    //     email: '',
    //     goals: '',
    // };