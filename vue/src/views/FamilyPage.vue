<template>
  <div>
    <!-- <add-family /> -->
      <h1>{{this.$store.state.family.familyName}}</h1>
      <add-member/>


      <h2>members</h2>
  </div>
</template>

<script>

import addMember from "../components/AddMember"
 
export default {

  components: { addMember },
    name: "FamilyPage"

}
</script>

<style>

</style>