<template>
  <div class="home">
    <!-- <nav-bar /> -->
    <div id="home-header">
      <h1>Welcome Home</h1>
    </div>
    
    <div id="familyFormContainer">
      <add-family />
    </div>
    
    <router-link :to= "{name : 'family-page' }" ><strong>Go to Family Page</strong></router-link> 
    <add-prize v-if= "this.$store.state.isParent" />
    <prize-display v-bind:prizes="prizes" />
    
    <book-card v-for="book in allBooks" :key="book.bookId" />
    <br><br><br><br><br><br><br><br><br><br><br>
    <!-- // we can add all the family logs here... also store the family log in the store.  -->
    <!-- <family-page  /> -->
    <!-- <add-member /> -->
    <!-- <setup-family />
    <log-book /> -->
  

  </div>
</template>


<script>
// import NavBar from '../components/NavBar.vue';

// import AddMember from '../components/AddMember.vue';
// import FamilyPage from './FamilyPage.vue';
import PrizeService from "../services/PrizeService"
import FamilyService from '@/services/FamilyService.js';
import MemberService from '@/services/MemberService.js';
// import BookService from '../services/BookService';
import AddFamily from '@/components/AddFamily.vue'
import BookCard from '../components/BookCard.vue';
import readingLog from '../services/readingLog'
import AddPrize from '../components/AddPrize.vue';
import PrizeDisplay from '../components/PrizeDisplay.vue';

export default {
  name: "home",
  components: {
    AddFamily,
    BookCard,
    AddPrize,
    PrizeDisplay,
    // AddMember
    // FamilyPage
    // SetupFamily,
    // LogBook,
    // NavBar
    // NavBar, 
  },
  data() {
    return {
          showForm: false,
          // userBooks: [],
          allBooks: [],
          prizes: this.$store.state.allPrizes,
    }
  },
  // computed: {
  //   userBooks = this.allBooks.filter((book) =>
  //   {

  //   }

  // },
  
  created() {
    //get family info and put in store
    FamilyService.getFamilyFromUser(this.$store.state.user.id)
    .then(
      response => {
          this.$store.commit("SET_FAMILY", response.data)
          
      }
    );

    MemberService.getMembers()
    .then( response => 
    {
      this.$store.commit("SET_FAMILY_MEMBERS", response.data)
    }
    
    ),
    PrizeService.getPrizeByFamilyId()
    .then(response =>
    {
      this.$store.commit("SET_ALL_PRIZES", response.data)
    }),

    

    
    // MemberService.getUserBooks()
    // .then(
    //   response => {
    //     this.$store.commit("SET_USER_BOOKS", response.data)
    //     this.userBooks = response.data
    //   }
    // );

    MemberService.getAllBooks()
    .then(
      response => {
        this.$store.commit("SET_ALL_BOOKS", response.data);
        this.userBooks = response.data
      }
    );
// this is throwing null pointer error right now.. 
    readingLog.getReadingLogByFamilyId()
    .then( response =>
    {
      this.$store.commit("SET_READING_LOGS", response.data)
    });
    //this.checkForFamily()
  },
  
  methods: {
    checkForFamily() {
      if(this.$store.state.family != {}) {
        this.showForm = false;
      } else {
        this.showForm = true;
      }
      //return this.showForm
    }
  }
 
};
</script>

<style>
@import url('https://fonts.googleapis.com/css2?family=Dosis:wght@800&display=swap');

.home {
  background-color: #FFE7D5;
}

.home h1 {
  font-family: 'Dosis', sans-serif;
  font-size: xx-large;
}

#home-header h1 {
  text-shadow: 2px 2px #45547A;
  color: #FFE7D5;
}

#home-header {
  display: flex;
  justify-content: space-evenly;
  background-color: #EC5C67;
  border: 5px solid #45547A;
  border-radius: 10px;
  margin-top: 1vh;
}

#familyFormContainer {
  display: flex;
  justify-content: center;
}



</style>
