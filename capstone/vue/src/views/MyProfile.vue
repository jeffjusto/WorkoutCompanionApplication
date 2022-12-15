
<template>
    <div class="card-container">
        <profile-card v-bind:profile="profile" />
        <button id="btn-edit-profile" class="btn" v-on:click="openUpdateProfile">EDIT PROFILE</button>
    </div>
</template>

<script>
import ProfileCard from '../components/ProfileCard.vue';
import ProfilesService from '../services/ProfilesService'

export default {
    name: 'my-profile',
    components: {
        ProfileCard
    },
    data() {
        return {
            profile: {}
        }
    },
    created() {
        ProfilesService.getProfile(this.$store.state.user.id).then(response => {
            this.profile = {...response.data};
        });
    },
    methods: {
        openUpdateProfile() {
             this.$router.push({name: 'updateProfile'});
        }
    }
}

</script>

<style scoped>
    .card-container {
        display: flex;
        flex-direction: column;
        align-items: center;
    }

    .card {
        margin-top: 100px;
        transform: scale(1.2);
    }
    #btn-edit-profile {
        margin-top: 50px;
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

    #btn-edit-profile:hover {
        cursor: pointer;
        transform: scale(1.02);
    }
</style>