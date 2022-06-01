<template>
  <div class="home">
    <!-- <nav-bar /> -->
    
    <h1>Home</h1>
    <add-family />
    <family-page />
    <!-- <add-member /> -->
    <!-- <setup-family />
    <log-book /> -->

    <p>You must be authenticated to see this</p>
  </div>
</template>


<script>
// import NavBar from '../components/NavBar.vue';
import AddFamily from '@/components/AddFamily.vue'
// import AddMember from '../components/AddMember.vue';
import FamilyPage from './FamilyPage.vue';


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
  }
};
</script>
