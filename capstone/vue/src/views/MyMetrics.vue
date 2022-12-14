<template>
    <div class="card-container">
        <equipment-log-card v-for="equipmentLog in equipmentLogs" v-bind:key="equipmentLog.entryId" v-bind:equipmentLog="equipmentLog"></equipment-log-card>
    </div>
</template>

<script>
import EquipmentLogCard from '../components/EquipmentLogCard'
import EquipmentLogService from '../services/EquipmentLogService'

export default {
    name: 'my-metrics',
    components: {
        EquipmentLogCard
    },
    data() {
        return {
            equipmentLogs: []
        }
    },
    created() {
        EquipmentLogService.getAllById(this.$store.state.user.id).then(response => {
            this.equipmentLogs = response.data;
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