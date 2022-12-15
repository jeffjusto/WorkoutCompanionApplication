<template>
    <div class="card">
        <img v-bind:src="showImage ? equipment.imgSrc : equipment.instructionSrc" v-bind:alt="equipment.name" v-on:click="toggleImg">
        <h3>{{ equipment.name }}</h3>
        <p>{{ equipment.description }}</p>
        <button class="btn-machine inactive" v-on:click.prevent="setCheckInTimestamp">Check into this machine</button>
    </div>
</template>

<script>

export default {
    name: 'equipment',
    props: ['equipment'],
    data() {
        return {
            showImage: true,
            equipmentId: this.equipment.id
        }
    },
    methods: {
        toggleImg() {
            this.showImage = !this.showImage;
        },
        setCheckInTimestamp() {
            this.$store.commit("SET_EQUIPMENT_LOG_SESSION", this.equipmentId);
            this.$store.commit("SET_EQUIPMENT_LOG_CHECK_IN", Date.now());
            this.$router.push({name: 'equipmentLog'});
            this.$store.commit("SET_CURRENT_EQUIPMENT_ID", this.equipmentId);
         }
    }
}

</script>

<style scoped>
    h3 {
        margin-top: 30px;
    }

    p {
        flex-grow: 2;
    }

    img {
        width: 80%;
        height: auto;
    }

    img:hover {
        cursor: pointer;
    }

    .card {
        display: flex;
        flex-direction: column;
        align-items: center;
        color: #31394D;
        background-color: white;
        border: 1px solid #31394D;
        border-radius: 6px;
        height: 500px;
        width: 300px;
        margin: 20px;
        padding: 20px;
        text-align: center;
        box-shadow: 0 12px 13px rgba(0,0,0,0.16), 0 12px 13px rgba(0,0,0,0.16);
        transition: all 0.3s cubic-bezier(.25,.8,.25,1);
        font-family: Arial, Helvetica, sans-serif;
    }

    .btn-machine {
        border:none;
        color:#ffffff;
        width:50%;
        font-size:16px;
        border-radius:5px;
        box-shadow: 0 13px 26px rgba(0,0,0,0.16), 0 3px 6px rgba(0,0,0,0.16);
        background: linear-gradient(to top right, #8162CE, #F54BA5);
        height: 40px;
    }

    .btn-machine:hover{
        cursor: pointer;
        transform: scale(1.02);
    }

    .active {
        background: linear-gradient(to bottom right, #5E5AEC, #3F9EFC);
    }

    .inactive {
        background: linear-gradient(to top right, #8162CE, #F54BA5);
    }
</style>