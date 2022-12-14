<template>
    <div class="container">
        <input type="file" accept="image/" class="hidden" ref="file" @change="change">
        <div class="img-container">
            <img :src="src" alt="">
        <div >
        <!-- <button @click="browse()" type="button" class="button"></button> -->
        
        </div>
        </div>
    </div>
</template>

<script>
export default {
    props:{
    value: File,
    defaultSrc: String
    },

    data(){
        return {
            src: this.defaultSrc,
            file: null
        }
    },

    methods: {
        browse(){
            this.$refs.file.click();
        },
        change(event){

            this.file = event.target.files[0];
            this.$emit('input', this.file);

            let reader = new FileReader();

            reader.readAsDataURL(event.target.files[0]);

            reader.onload = (event) => {
                this.src = event.target.result;
            }
        }
    }
}
</script>

<style scoped>
img {
   width: 100px;
    height: 100px;
    border-radius: 50%;
}

button {
    align-items: center;
    text-align: center;
    display: flex;
    display: grid;
}

input {
    width: 30%;
    margin-bottom: 10px;
}

.container {
    display: flex;
    flex-direction: column;
    align-items: center;
}

.btn {
    
    }

  .btn:hover {
    cursor: pointer;
    transform: scale(1.02);
  }
</style>