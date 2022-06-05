<template>

  <div class="profile"> 
    <h1>{{member.username}}</h1>
    <h2>user's id: {{member.userId}}</h2> 

    <!-- list each book associated with the user (retrieved from MemberService) -->
    <!-- router link goes to book's detail page -->
    <!-- link params passes along the member and book objects - to be used in adding a log for book -->
    <router-link 
      :to="{name:'book-page', params:{book, member}}"  v-for="book in userBooks" v-bind:key="book.id"
    >
      <book-card   v-bind:book = "book" v-bind:member ="member" />
    </router-link>

    
     profile page-- need to setup so it takes Id and populates the profile 

     // total reading time in the app 
     
     // section of current Books - all books that has readinglog entry (userid && book_id) - ever read..Order By ...  largest date ~ RECENT DATE.... 

     // section all asigned books - all books that has user_id

     // section of completed books. 
  <!-- <update-picture v-bind:username='this.username' /> -->
  <!-- <add-reading-log v-bind:member ="member" /> -->
 
   </div>
</template>

<script>

// import UpdatePicture from '../components/UpdatePicture.vue'
import BookCard from '../components/BookCard.vue'
import MemberService from '../services/MemberService.js'
// import AddReadingLog from '../components/AddReadingLog.vue'

export default {

    name: 'profile',
    props: {
      member: Object,
    },
    data() {
      return {
        //this.$route.params.username,
        thisMember: this.member,
        username: this.member.username,
        userId: this.member.userId,
        userBooks: []
      }
    },
    components: {
      // UpdatePicture,
      BookCard,
      // AddReadingLog,
      
    },
    created() {
      MemberService.getUserBooks()
      .then(
        response => {
          this.userBooks = response.data;
        }
      )
    }
}
</script>

<style>
.profile{
  display: flex;
  flex-wrap: wrap;
  background-color: #FFE7D5;
}

</style>