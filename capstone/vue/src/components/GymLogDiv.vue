<template>
    <div class="gym-log-div">
        <!-- <button>{{gymLog.checkIn === '' ? 'START GYM SESSION' : 'END GYM SESSION'}}</button> -->
        <div class="start-session" v-on:click.prevent="setCheckInTimestamp" v-if="this.gymLog.checkIn === '' ">START GYM SESSION</div>
        <div class="end-session" v-on:click.prevent="setCheckOutTimestamp" v-if="this.gymLog.checkIn !== '' ">END GYM SESSION</div>
    </div>
</template>

<script>
import GymLogService from '../services/GymLogService'

export default {
    name: "gym-log-div",
    data() {
        return {
            gymLog: {
                logId: "",
                userId: this.$store.state.user.id,
                checkIn: "",
                checkOut: "",
                difference: ""
            }
        }
       
    },
    methods: {
        setCheckInTimestamp() {
            this.gymLog.checkIn = Date.now();
            // GymLogService.create(this.gymLog)
            
        },
        setCheckOutTimestamp() {
            this.gymLog.checkOut = Date.now();
            GymLogService.create(this.gymLog);
            this.gymLog = {
                logId: "",
                userId: this.$store.state.user.id,
                checkIn: "",
                checkOut: "",
            }
        }
    }
}
</script>

<style>
    .gym-log-div {
        text-align: center;
    }
</style>