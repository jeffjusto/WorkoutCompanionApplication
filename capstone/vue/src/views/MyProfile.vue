
<template>
    <div>
        <profile-card v-bind:profile="profile" />
        <button id="btn-edit-profile" v-on:click="openUpdateProfile">EDIT PROFILE</button>
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

<style>
    .card-container {
        width: 80%;
        display: flex;
        flex-wrap: wrap;
        justify-content: space-around;
        margin: auto;

    }
</style>