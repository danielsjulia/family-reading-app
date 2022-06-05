<template>
  <div id="app">
    <!-- <home /> -->
    <!-- <nav-bar/> -->
    <!-- add conditions for nav bar based on parent or child -->
    <div class="header">
      <div class="nav">
        <h2>Family Reading Tracker</h2>
        <ul>
          <li>
            <router-link v-bind:to="{ name: 'home' }">Home</router-link
            >&nbsp;|&nbsp;
          </li>
          <li>
            <router-link
              v-bind:to="{ name: 'all-books' }"
              v-if="$store.state.token != ''"
              >All Books</router-link
            >&nbsp;|&nbsp;
          </li>
          <li>
            <router-link
              v-bind:to="{ name: 'family-page' }"
              v-if="$store.state.token != ''"
              >Family Page</router-link
            >&nbsp;|&nbsp;
          </li>
          <li>
            <router-link
              v-bind:to="{ name: 'logout' }"
              v-if="$store.state.token != ''"
              >Logout</router-link
            >&nbsp;|&nbsp;
          </li>
          <!-- <router-link v-bind:to="{ name: 'add-a-book' }" v-if="$store.state.token != ''">Add A Book</router-link>&nbsp;|&nbsp; -->
        </ul>
      </div>
    </div>
    <router-view />
  </div>
</template>

<script>
// import NavBar from '@/components/NavBar.vue'

export default {
  name: "app",
  component: {
    // NavBar
  },
};
</script>


<style >
.header {
  background-color: #83d8da;
  border: 5px solid black;
  padding: 0 1em;
}
.nav {
  display: flex;
  justify-content: space-between;
  align-items: center;
}

ul {
  list-style-type: none;
}

.header h1 {
  color: #ffffff;
  font-size: 15px;
}

.nav li {
  color: #ffffff;
  display: inline-block;
}
</style>