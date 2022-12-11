<template>
    <div class="card">
        <div class="profile-info">
             <div class="img-container">
                <img src="https://www.pngkey.com/png/full/787-7877336_rand-romas-circular-headshot-gentleman.png" alt="photo">
            </div>
            <h3 class="account-id grey-text">Account ID# {{ profile.profileId }}</h3>
            <h3 class="white-text heavy">{{ profile.name }}</h3>
            <h3 class="grey-text light">{{ profile.email }}</h3>
            <h3 class="white-text">{{ profile.goals }}</h3>
        </div>
        <hr>
        <div class="profile-metrics">
            <div class="metric-container">
                <div class="metric-graphic color-a">
                    <h3>200 minutes this week</h3>
                </div>
            </div>
            <div class="metric-container">
                <div class="metric-graphic color-b">
                    <h3>XXX steps this month</h3>
                </div>
            </div>
            <div class="metric-container">
                <div class="metric-graphic color-c">
                    <h3>XXX lbs lost</h3>
                </div>
            </div> 
        </div>
  </div>
</template>

<script>


export default {
    name: 'profile',
    props: ['profile']
}
</script>

<style>
img {
    max-height: 100%;
    max-width: 100%;
}

hr {
    border-color:#7C8097;
    width: 90%;
}

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

.img-container {
    width: 150px;
    height: 150px;
    border-radius: 50%;
}

.profile-info {
    display: flex;
    flex-direction: column;
    align-items: center;
}

.profile-metrics {
    display: flex;
    justify-content: space-around;
}

.white-text {
    color: #FFFFFF;
}

.grey-text {
    color:#7C8097;
}

.heavy {
    font-weight: 300;
    font-size: 2em;
}

.metric-container h3 {
    color:#FFFFFF;
    text-align: center;
}

.metric-graphic {
    width: 50px;
    height: 50px;
    border-radius: 50%;
}

.color-a {
    background: linear-gradient(to top right, #8162CE, #F54BA5);
}

.color-b {
    background: linear-gradient(to bottom right, #C90A6D, #FF48A0);
}

.color-c {
    background: linear-gradient(to bottom right, #5E5AEC, #3F9EFC);
}
</style>