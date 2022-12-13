<template>
    <div class="card-container">
        <gym-log-card v-for="gymLog in gymLogs" v-bind:key="gymLog.logId" v-bind:gymLog="gymLog"></gym-log-card>
    </div>
</template>

<script>
import GymLogCard from '../components/GymLogCard.vue'
import GymLogService from '../services/GymLogService'

export default {
    name: 'gymLog',
    components: {
        GymLogCard
    },
    data() {
        return {
            gymLogs: []
        }
    },
    created() {
        GymLogService.getAllById(this.$store.state.user.id).then(response => {
            this.gymLogs = response.data;
        });
    }
}
</script>

<style scoped>
    .card-container {
        width: 80%;
        display: flex;
        flex-direction: row;
        flex-wrap: wrap;
        justify-content: space-around;
        margin: auto;
    }
</style>