<template>
    <form class="card" v-on:submit.prevent="saveProfile()">
      <div class="avatar-container">
        <avatar-input />
      </div>
      <div class="field">
        <label for="name">Employee Name</label>
        <input type="text" placeholder="Name" v-model="profile.name">
      </div>
      <div class="field">
        <label for="email">E-mail Address</label>
        <input type="text" placeholder="E-mail Address" v-model="profile.email">
      </div>
      <div class="field">
        <label for="specialties">Employee Specialties</label>
        <input type="text" placeholder="Specialties" v-model="profile.goals">
      </div>
      <div class="actions">
        <button class="btn" type="button" v-on:click="cancel()">Cancel</button>&nbsp;
        <button class="btn" type="submit">Save Profile</button>
      </div>
    </form>
</template>

<script>
import EmployeeProfileService from '../services/EmployeeProfileService';
import AvatarInput from '../components/AvatarInput.vue'

export default {
  name: "employee-card-form",
  components: {
    AvatarInput
  },
  data() {
      return {
        profile: {
          profileId: "",
          userId: this.$store.state.user.id,
          name: "",
          email: "",
          goals: "",
        }
      }
  },
  methods: {
    saveProfile() {
      EmployeeProfileService.update(this.$store.state.user.id, this.profile)
      .then(response => {
        if (response.status === 201) {
          this.$router.push("/")
        }
      })
      .catch(error => {
        console.error(error);
      });
    },
    cancel() {
      this.$router.push({ name: 'profiles' });
    }
  }
} 

</script>

<style scoped>
  label {
    color: #FFFFFF;
  }

  input {
    display: flex;
    margin-top: 2px;
    margin-bottom: 20px;
    height: 30px;
    width: 100%;
    background-color: FFFFFF;
  }

  .card {
    display: flex;
    flex-direction: column;
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
    margin-left: auto;
    margin-right: auto;
  }

  .btn{
    margin-top: 100px;
    border:none;
    height:30px;
    max-width: 300px;
    color:#ffffff;
    width:35%;
    font-size:16px;
    border-radius:10px;
    box-shadow: 0 13px 26px rgba(0,0,0,0.16), 0 3px 6px rgba(0,0,0,0.16);
    background: linear-gradient(to top right, #8162CE, #F54BA5);
    }

  .btn:hover{
    cursor: pointer;
    transform: scale(1.02);
  }

  .avatar-container {
    margin-bottom: 40px;
  }

  .actions {
    margin-top: -30px;
  }

</style>