
<template>
    <div>
        <button id="btn-add-employee" class="btn" type="button" v-on:click="addNewEmployee()">ADD EMPLOYEE</button>
        <div class="card-container">
            <profile-card v-for="profile in profiles" v-bind:key="profile.profileId" v-bind:profile="profile" />
        </div>
  </div>
</template>

<script>
import ProfileCard from '../components/ProfileCard.vue';
import ProfilesService from '../services/ProfilesService'

export default {
    name: 'profiles',
    components: {
        ProfileCard
    },
    data() {
        return {
            profiles: []
        }
    },
    methods: {
        addNewEmployee(){
            this.$router.push({name: 'employee'})
        }
    },
    created() {
        ProfilesService.getAll().then(response => {
            this.profiles = response.data;
        });
    }
}
</script>

<style>
    .card-container {
        width: 80%;
        display: flex;
        flex-wrap: wrap;
        justify-content: space-around;
        margin: auto;
    }

    .btn {
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

    .btn:hover {
        cursor: pointer;
        transform: scale(1.02);
    }
</style>