<template>
    <div class="card">
        <div class="session-id">
            <h2 class="color-a">Log ID: {{ equipmentLog.entryId }}</h2>
        </div>
        <!-- <hr> -->
        <!-- <div class="user-id">
            <h2 class="color-a">User ID</h2> 
            <h3 class="color-a">{{ gymLog.userId }}</h3>
        </div> -->
        <hr>
        <div class="date">
            <h2 class="color-b">Date: {{ equipmentLog.equipmentCheckIn.substring(0, 10) }}</h2>
        </div>
        <hr>
        <div class="duration color-c">
            <h2 class="color-c">Duration: {{ equipmentLog.equipmentTimeInterval }} minutes</h2>
        </div>
        <hr>
        <div class="weight-reps color-a">
            <h2 class="color-a">Machine: {{ equipmentLog.equipmentId }}</h2>
            <h2 class="color-a">Weight: {{ equipmentLog.weight }}</h2>
            <h2 class="color-a">Reps: {{ equipmentLog.reps }}</h2>
        </div>
    </div>
</template>

<script>


export default {

    name: 'equipment-log-card',
    props: ['equipmentLog']
}
</script>

<style scoped>
h2 {
    margin-left: 10px;
}

h3 {
    margin-left: 10px;
}

hr {
    border-color:#7C8097;
    width: 90%;
}

.card {
    display: flex;
    flex-direction: column;
    background-color: #31394D;
    border-radius: 6px;
    width: 230px;
    margin: 10px;
    padding: 20px;
    text-align: left;
    box-shadow: 0 12px 13px rgba(0,0,0,0.16), 0 12px 13px rgba(0,0,0,0.16);
    transition: all 0.3s cubic-bezier(.25,.8,.25,1);
    font-family: Arial, Helvetica, sans-serif;
    color: #FFFFFF;
}

.color-a {
    color: #8162CE;
}

.color-b {
    color: #C90A6D;
}

.color-c {
    color: #5E5AEC;
}
</style>