<template>

  <div class="member-Profile" > 
    <span class = "name"> 
      <br>
      <h1>{{member.username}}'s page!</h1>
      <!-- <h2>user's id: {{member.userId}}</h2>  -->
      <br>
      
      <div class="log-container">
        
        <reading-log class="log" v-bind:member="member"  /> <!-- :key="logKey" @form-submitted="forceRerender()" -->

        
        <add-reading-log class="add-log" v-bind:member="member" v-bind:userBooks="userBooks" />

      </div>
      

      
      <!-- {{userBooks}}
      {{thisMember}} -->

    </span>
    <h2>Your Books</h2>
    <!-- list each book associated with the user (retrieved from MemberService) -->
    <!-- router link goes to book's detail page -->
    <!-- link params passes along the member and book objects - to be used in adding a log for book -->
    <router-link class="profile" :to="{name:'book-page', params:{book, member}}" v-for="book in userBooks" v-bind:key="book.id">
      <book-card   v-bind:book = "book" v-bind:member ="thisMember" />
    </router-link>

    
     <!-- profile page-- need to setup so it takes Id and populates the profile 

     // total reading time in the app 
     
     // section of current Books - all books that has readinglog entry (userid && book_id) - ever read..Order By ...  largest date ~ RECENT DATE.... 

     // section all asigned books - all books that has user_id

     // section of completed books.  -->
  <!-- <update-picture v-bind:username='this.username' /> -->
  <!-- <add-reading-log v-bind:member ="member" /> -->
 
   </div>
</template>

<script>

// import UpdatePicture from '../components/UpdatePicture.vue'
import BookCard from '../components/BookCard.vue'
//import BookService from '../services/BookService'
import AddReadingLog from '../components/AddReadingLog.vue'
import MemberService from '../services/MemberService.js'
// import AddReadingLog from '../components/AddReadingLog.vue'
import ReadingLog from '../components/ReadingLog.vue'

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
        userBooks: [],
        allBooks : this.$store.state.allBooks
        // logKey: 0
      }
    },
    components: {
      // UpdatePicture,
      BookCard,
      AddReadingLog,
      ReadingLog
      // AddReadingLog,
      
    },
    created() {
            const promise = MemberService.getUserBooks()
              promise.then(response => 
                    {
                    this.userBooks = response.data
                    }
        )
      },
    // methods: {
    //   forceRerender() {
    //     this.logKey += 1;
    //   }
    // }

        
    // created() {
    //   const promise= BookService.getAllBooksByUserId(this.thisMember.userId)
    //   promise.then(response => {
    //       this.userBooks = response.data;
    //     }
    //   )
    // }
}
</script>

<style>
@import url('https://fonts.googleapis.com/css2?family=Dosis:wght@800&display=swap');

.name {
  display: block;
  text-align: center;
  background-color:lavender;
  font-family: 'Dosis', sans-serif;
}

/* .member-profile {
  display: flex;
  flex-wrap: wrap;
  justify-content: space-evenly;
} */

.member-Profile {
  background-color: lavender;
}

.profile{
  display: inline-flex;
  flex-wrap: wrap;
}

.log-container {
  display: flex;
  flex-direction: column;
  align-items: center;
  width: 100%;
}

.log, .add-log {
  margin: 30px;
  width: 80%;
  align-self: center;
}

.member-Profile h2 {
  text-align: center;
  font-family: 'Dosis', sans-serif;
}



</style>