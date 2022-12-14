
<template>
    <div class="card-container">
        <equipment-log-form />
    </div>
</template>

<script>
import EquipmentLogForm from '../components/EquipmentLogForm.vue'
import EquipmentLogService from '../services/EquipmentLogService'

export default {
    name: 'equipment-log',
    components: {
        EquipmentLogForm
    },
    data() {
        return {
            
        }
    },
    methods: {
        openUpdateProfile() {
             EquipmentLogService.create(this.equipmentLog);
        }
    }
}

</script>

<style scoped>
    .card-container {
        display: flex;
        flex-direction: row;
        justify-content: center;
    }

    .btn{
        margin-top: 100px;
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