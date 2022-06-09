<template>
  <div class="familyPage" >
    <!-- <add-family /> -->
      <h1>Welcome to {{this.$store.state.family.familyName}}'s home page!</h1>
      <div class="addMemberForm"  >
        <add-member id="add-member-form" v-show="this.$store.state.isParent" />
      </div>
      
      <members id="display-members" />
      
  </div>
</template>

<script>
import FamilyService from '@/services/FamilyService.js';
import addMember from "../components/AddMember"
import Members from '../components/Members.vue';
 
export default {

  
  name: "FamilyPage",
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
  components: { 
    addMember, 
    Members 
  },
  methods:{
    
  }

}
</script>

<style>
@import url('https://fonts.googleapis.com/css2?family=Dosis:wght@800&display=swap');


.familyPage {
  background-color: #FFE7D5;
  border-radius: 10px;
  font-family: 'Dosis', sans-serif;
  
}

.familyPage h1 {
  text-align: center;
  padding-top: 5vh;
}

.addMemberForm {
  /* width: 100vw;
  justify-content: center;
  margin: 20px; */
  text-align: center;
}

#add-member-form, #display-members {
  width: 100%;
}

</style>