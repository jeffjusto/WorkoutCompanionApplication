<template>
    <form v-on:submit.prevent>
      <div class="field">
        <label for="name">Name</label>
        <input type="text">
      </div>
      <div class="field">
        <label for="email">E-mail Address</label>
        <input type="text">
      </div>
      <div class="goals">
        <label for="goals">Goals</label>
        <input type="text">
      </div>
      <div class="actions">
        <button type="button">Cancel</button>&nbsp;
        <button type="submit">Save Document</button>
      </div>
    </form>
</template>

<script>
export default {
  
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