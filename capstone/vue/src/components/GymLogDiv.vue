<template>
    <div class="container">
        <div class="card inactive" v-on:click.prevent="setCheckInTimestamp" v-if="this.$store.state.isInSession === false">
            <font-awesome-icon icon="fa-solid fa-stopwatch" size="6x" />
            <h2>START GYM SESSION</h2>  
        </div>
        <div class="card active" v-on:click.prevent="setCheckOutTimestamp" v-if="this.$store.state.isInSession === true">
            <font-awesome-icon icon="fa-solid fa-stopwatch" size="6x" />
            <h2>END GYM SESSION</h2>
        </div>
    </div>
</template>

<script>
import GymLogService from '../services/GymLogService'
import { differenceInMinutes } from 'date-fns'

export default {
    name: "gym-log-div",
    data() {
        return {
            gymLog: {
                logId: 0,
                userId: this.$store.state.user.id,
                checkIn: this.$store.state.gymLogCheckIn,
                checkOut: "",
                difference: ""
            }
        }
    },
    methods: {
        setCheckInTimestamp() {
            this.$store.commit("SET_GYM_LOG_SESSION");
            this.$store.commit("SET_GYM_LOG_CHECK_IN", Date.now());
        },
        setCheckOutTimestamp() {
            this.gymLog.checkOut = Date.now();
            this.gymLog.difference = differenceInMinutes(this.gymLog.checkOut, this.gymLog.checkIn);
            GymLogService.create(this.gymLog);
            this.gymLog = {
                logId: 0,
                userId: this.$store.state.user.id,
                checkIn: "",
                checkOut: "",
                difference: ""
            }
            this.$store.commit("SET_GYM_LOG_SESSION");
            this.$store.commit("SET_GYM_LOG_CHECK_IN", "");
        }
    }
}
</script>

<style scoped>
    .card {
        display: flex;
        flex-direction: column;
        justify-content: center;
        gap: 10px;
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
        text-align: center;
    }

    .active {
        background: linear-gradient(to bottom right, #5E5AEC, #3F9EFC);
    }

    .inactive {
        background: linear-gradient(to top right, #8162CE, #F54BA5);
    }

    .container:hover {
        cursor: pointer;
    }
</style>