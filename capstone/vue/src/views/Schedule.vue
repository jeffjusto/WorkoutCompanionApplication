<template>
    <div id="schedule" class="card-container">
        <class-schedule/>
    </div>
</template>

<script>
import ClassSchedule from '../components/ClassSchedule.vue';
export default {
   name: 'schedule',
   components: {
       ClassSchedule
   },
};
</script>