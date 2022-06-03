<template>

  <div> 
    <h1>{{username}}</h1>
     profile page-- need to setup so it takes Id and populates the profile 
  <update-picture v-bind:username='this.username' />
  </div>
</template>

<script>

import UpdatePicture from '../components/UpdatePicture.vue'

export default {

    name: 'profile',
    data() {
      return {
        username: this.$route.params.username
      }
    },
    components: {
      UpdatePicture
    }
    }
</script>

<style>

</style>