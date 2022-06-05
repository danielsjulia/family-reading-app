<template>
  <div class="familyPage" >
    <!-- <add-family /> -->
      <h1>{{this.$store.state.family.familyName}}</h1>
      <div class="addMemberForm"  >
        <add-member />
      </div>
      
      <members />
      
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

.familyPage {
  background-color: #83d8da;
}

.addMemberForm {
  margin: 20px;
  text-align: center;
}

</style>