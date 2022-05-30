<template>
  <div class="home">
    <nav-bar />
    
    <h1>Home</h1>
    
    
    <!-- <setup-family />
    <log-book /> -->

    <p>You must be authenticated to see this</p>
  </div>
</template>


<script>
import NavBar from '../components/NavBar.vue';


export default {
  name: "home",
  components: {
    // SetupFamily,
    // LogBook,
    NavBar
    // NavBar, 
  }
};
</script>
