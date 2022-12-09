<template>
    <div class="card">
        <h2>{{ equipment.id }}</h2>
        <img v-bind:src="equipment.imgSrc" v-bind:alt="equipment.name">
        <h3>{{ equipment.name }}</h3>
        <h3>{{ equipment.description }}</h3>
    </div>
</template>

<script>

export default {
    name: 'equipment',
    props: ['equipment']
}
</script>

<style>
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