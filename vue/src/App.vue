<template>
  <div id="app">
    <h1>Family Reading</h1>
    <!-- <home /> -->
    <!-- <nav-bar/> -->
    <!-- add conditions for nav bar based on parent or child -->
    <div id="nav">
      <router-link v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'add-a-book' }" v-if="$store.state.token != ''">Add A Book</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{name: 'all-books'}" v-if="$store.state.token != ''">All Books</router-link>
     
    </div>
    <router-view />
  </div>
</template>

<script>
// import NavBar from '@/components/NavBar.vue'

export default {
  name:'app',
  component: {
    // NavBar
  }
}
</script>


<style >

#nav {
  display: flex;
  justify-content: center;
  border: 1px solid black;
  padding: 30px;
  text-align: center;
}

#nav a {
  font-weight: bold;
  color: #2c3e50;
}

#nav a.router-link-exact-active {
  color: #42b983;
}
</style>