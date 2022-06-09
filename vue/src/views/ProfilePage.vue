<template>

  <div class="member-Profile" > 
      
           <div class = "name">  
        <h1 class="head1" >{{member.username}}'s page!</h1>
        <!-- <h2>user's id: {{member.userId}}</h2>  -->
      
      </div>
     
      <div class="log-container" >

        <add-reading-log class="add-log" v-bind:member="member" v-bind:userBooks="userBooks" @formSubmitted="forceRerender()" />
        <div class= "logTable">

        <h3 class="head2" >Total Minutes Read: {{this.readingLogTime}} minutes</h3>
        <reading-log class="log" v-bind:member="member" v-bind:readingLogs="readingLogs" /> 
        </div>

      </div>
      

      
      <!-- {{userBooks}}
      {{thisMember}} -->
    <h2>Your Books</h2>

    <div class="books">
    <!-- list each book associated with the user (retrieved from MemberService) -->
    <!-- router link goes to book's detail page -->
    <!-- link params passes along the member and book objects - to be used in adding a log for book -->
    <router-link class="profile" :to="{name:'book-page', params:{book, member}}" v-for="book in userBooks" v-bind:key="book.id">
      <book-card   v-bind:book = "book" v-bind:member ="thisMember" />
    </router-link>
    </div>
    
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
import readingLog from '../services/readingLog'

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
        allBooks : this.$store.state.allBooks,
        readingLogTime: 0,
        logKey: 0,
        readingLogs: [],
        //member: Object
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

          //if member is empty, redirect to profile? get info f
          if (this.member == undefined) {
              //this.member = this.$store.state.currentMember;
              this.$router.push('/MyFamily');
              //get info from server
          }

          readingLog.getReadingLogDTOByUserId(this.member.userId)
          .then(
            response => {
                this.readingLogs = response.data;
            }
          )

            const promise = MemberService.getUserBooks(this.member.userId)
              promise.then(response => 
                    {
                      console.log(response.data);
                    this.userBooks = response.data
                    }
        )
            const promise1 = readingLog.getTotalReadingTime(this.userId)
              promise1.then(response => 
              {
                console.log(response.data)
                this.readingLogTime = response.data
              })
      },
    methods: {
      forceRerender() {
        //this.logKey += 1;
        //window.alert('it worked!');
        readingLog.getReadingLogDTOByUserId(this.member.userId)
          .then(
            response => {
                this.readingLogs = response.data;
            }
          );
      }
    }

        
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
  /* display: block; */
  /* width: 100vw; */
  /* padding: 0px !important; */
  text-align: center;
  font-family: 'Dosis', sans-serif;
  margin:0;
  padding:0;
}

.head1 , .head2{
  margin:0;
}
.member-Profile{
  background-color:  #aeeaea;
}
/* .member-profile {
  display: flex;
  flex-direction: column;
  flex-wrap: wrap;
  justify-content: space-evenly;
} */

/* .member-Profile {
  background-color: lavender;
  padding: 1% 25%;
  display: block;
  justify-content: center;
  align-self: center;
  height: 100vh;

} */

/* .profile{
  display: inline-flex;
  flex-wrap: wrap;
} */

.log-container {
  /* display: flex;
  flex-direction: row;
  align-items: center; */
  /* justify-content:space-evenly; */
  /* height:100vh;  */
  /* width: 80%; */
  display:grid;
  grid-template-columns: 1fr 1fr;
  grid-template-areas: "add-log   logTable" ;  
  justify-items: center;
  }
/* .log {
  width: 100vw;
} */

.logTable {

  /* width: 100%; */
 
 margin:50px 20px  0 0 ;
  
}
.add-log{
  height:80vh;
  width: 35vw;
  justify-content: center;
}

.member-Profile h2,.head2 {
  text-align: center;
  font-family: 'Dosis', sans-serif;
}

.books{
  display: flex;
  flex-direction:row;
  margin-left: 7rem;
}

</style>