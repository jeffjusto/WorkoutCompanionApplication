<template>
    <form v-on:submit.prevent>
      <div class="field">
        <label for="name">Name</label>
        <input type="text" v-model="profile.name">
      </div>
      <div class="field">
        <label for="email">E-mail Address</label>
        <input type="text" v-model="profile.email">
      </div>
      <div class="goals">
        <label for="goals">Goals</label>
        <input type="text" v-model="profile.goals">
      </div>
      <div class="actions">
        <button type="button" v-on:click="cancel">Cancel</button>&nbsp;
        <button type="submit" v-on:click="saveProfile">Save Document</button>
      </div>
    </form>
</template>

<script>
import ProfilesService from '../services/ProfilesService';
export default {
  name: "profile-card-form",
    data() {
        return {
          profile: {
            profile_id: 1,
            user_id: 1,
            name: 'test',
            email: 'test',
            goals: 'test',
          }
        }
    },
  method: {
    saveProfile() {
      const current = this.$store.state.activeProfile;
      const profile = {
        id: current.id,
        name: current.name,
        email: current.email,
        goals: current.goals,
      }
      ProfilesService.update(profile.id, profile)
      .then(response => {
        if (response.status === 200) {
          this.$router.push("/")
        }
      })
      .catch(error => {
        console.error(error);
      });
    },
    cancel() {
      this.$router.push("/");
    }
  }
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

 // saveProfile() {
    //   this.$store.commit('SAVE_PROFILE', this.profile);
    //   this.profile = {
    //     name: '',
    //     email: '',
    //     goals: '',
    // };