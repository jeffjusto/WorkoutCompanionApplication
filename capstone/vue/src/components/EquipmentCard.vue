<template>
    <div class="card">
        <img v-bind:src="showImage ? equipment.imgSrc : equipment.instructionSrc" v-bind:alt="equipment.name" v-on:click="toggleImg">
        <h3>{{ equipment.name }}</h3>
        <p>{{ equipment.description }}</p>
        <button class="btn">Check into this machine</button>
    </div>
</template>

<script>

export default {
    name: 'equipment',
    props: ['equipment'],
    data() {
        return {
            showImage: true
        }
    },
    methods: {
        toggleImg() {
            this.showImage = !this.showImage;
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
        max-height: 50%;
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

    .btn {
        border:none;
        color:#ffffff;
        width:50%;
        font-size:16px;
        border-radius:5px;
        box-shadow: 0 13px 26px rgba(0,0,0,0.16), 0 3px 6px rgba(0,0,0,0.16);
        background: linear-gradient(to top right, #8162CE, #F54BA5);
    }

    .btn:hover{
        cursor: pointer;
        transform: scale(1.02);
    }
</style>