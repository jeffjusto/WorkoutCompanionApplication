<template>
  <div class="card-container">
      <equipment-card v-for="equipment in equipmentList" v-bind:key="equipment.equipmentId" v-bind:equipment="equipment" />
  </div>
</template>

<script>
import EquipmentCard from '../components/EquipmentCard.vue'
import EquipmentService from '../services/EquipmentService.js'

export default {
    name: 'equipmentList',
    components: {
        EquipmentCard
    },
    data() {
    return {
        equipmentList: []
    }
    },
    created() {
        EquipmentService.getAll().then(response => {
            this.equipmentList = response.data;
        });
        this.$store.commit("SET_EQUIPMENT_LIST", this.equipmentList);
    }
}
</script>

<style scoped>
    .card-container {
        width: 80%;
        display: flex;
        flex-wrap: wrap;
        justify-content: space-around;
        margin: auto;
    }
</style>