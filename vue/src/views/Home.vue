<template>
  <div class="home">
    <!-- <nav-bar /> -->
    <div id="home-header">
      <h1>Welcome Home</h1>
    </div>
    
    <div id="familyFormContainer">
      <add-family />
    </div>
    
    <family-page  />
    <!-- <add-member /> -->
    <!-- <setup-family />
    <log-book /> -->
  

  </div>
</template>


<script>
// import NavBar from '../components/NavBar.vue';
import AddFamily from '@/components/AddFamily.vue'
// import AddMember from '../components/AddMember.vue';
import FamilyPage from './FamilyPage.vue';
import FamilyService from '@/services/FamilyService.js';

export default {
  name: "home",
  components: {
    AddFamily,
    // AddMember
    FamilyPage
    // SetupFamily,
    // LogBook,
    // NavBar
    // NavBar, 
  },
  data() {
    return {
          showForm: false
    }
  },
  
  created() {
    //get family info and put in store
    FamilyService.getFamilyFromUser(this.$store.state.user.id)
    .then(
      response => {
          this.$store.commit("SET_FAMILY", response.data)
      }
    )

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
