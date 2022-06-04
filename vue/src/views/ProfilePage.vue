<template>

  <div> 
    <h1>{{username}}</h1>
     profile page-- need to setup so it takes Id and populates the profile 

     // total reading time in the app 
     
     // section of current Books - all books that has readinglog entry (userid && book_id) - ever read..Order By ...  largest date ~ RECENT DATE.... 

     // section all asigned books - all books that has user_id

     // section of completed books. 
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