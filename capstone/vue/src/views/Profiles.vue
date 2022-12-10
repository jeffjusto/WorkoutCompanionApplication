
<template>
  <div class="card-container">
      <profile-card v-for="profile in profiles" v-bind:key="profile.profileid" v-bind:profile="profile" />
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
</style>