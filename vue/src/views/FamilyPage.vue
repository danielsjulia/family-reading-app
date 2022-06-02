<template>
  <div>
    <!-- <add-family /> -->
      <h1>{{this.$store.state.family.familyName}}</h1>
      <add-member/>


      <h2>members</h2>
  </div>
</template>

<script>
import FamilyService from '@/services/FamilyService.js';
import addMember from "../components/AddMember"
 
export default {

  components: { addMember },
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

}
</script>

<style>

</style>