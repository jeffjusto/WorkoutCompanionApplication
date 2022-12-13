<template>
    <div class="card">
        <div class="session-id">
            <h2>Session ID</h2>
            <h3>{{ gymLog.logId }}</h3>
        </div>
        <hr>
        <div class="user-id">
            <h2>User ID</h2> 
            <h3>{{ gymLog.userId }}</h3>
        </div>
        <hr>
        <div class="date">
            <h2>Date</h2>
            <h3>{{ gymLog.checkIn.substring(0, 10) }}</h3> 
        </div>
        <hr>
        <div class="duration">
            <h2>Duration</h2>
            <h2>{{ gymLog.difference }}</h2>  
        </div>
    </div>
</template>

<script>


export default {
    name: 'gymLog',
    props: ['gymLog']
}
</script>

<style scoped>

hr {
    border-color:#7C8097;
    width: 90%;
}

.card {
    display: flex;
    flex-direction: column;
    background-color: #31394D;
    border-radius: 6px;
    margin: 20px;
    padding: 20px;
    text-align: left;
    box-shadow: 0 12px 13px rgba(0,0,0,0.16), 0 12px 13px rgba(0,0,0,0.16);
    transition: all 0.3s cubic-bezier(.25,.8,.25,1);
    font-family: Arial, Helvetica, sans-serif;
    color: #FFFFFF;
}
</style>