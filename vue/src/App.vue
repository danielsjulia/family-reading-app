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
            <router-link v-bind:to="{ name: 'home' }">Prizes</router-link
            >&nbsp; | &nbsp;
          </li>
          <li>
            <router-link
              v-bind:to="{ name: 'all-books' }"
              v-if="$store.state.token != ''"
              >All Books</router-link
            >&nbsp; | &nbsp;
          </li>
          <li>
            <router-link
              v-bind:to="{ name: 'family-page' }"
              v-if="$store.state.token != ''"
              >Family Page</router-link
            >&nbsp; | &nbsp;
          </li>
          <li>
            <router-link
              v-bind:to="{ name: 'logout' }"
              v-if="$store.state.token != ''"
              >Logout</router-link
            >
          </li>
          <!-- <router-link v-bind:to="{ name: 'add-a-book' }" v-if="$store.state.token != ''">Add A Book</router-link>&nbsp;|&nbsp; -->
        </ul>
      </div>
    </div>
    <font size=4>


</font>
    <router-view />
  </div>
</template>

<script>
// import NavBar from '@/components/NavBar.vue'
import MemberService from "./services/MemberService"
import PrizeService from "./services/PrizeService"

export default {
  name: "app",
  component: {
    // NavBar
  },
  created() {
    MemberService.isParent().then(
              response => {
                console.log(response.data);
                if (response.data.parent) {
                  this.$router.push("/myFamily");
                  this.$store.commit("SET_IS_PARENT", true);
                  this.$store.commit("SET_CURRENT_MEMBER", response.data)
                } else if (!response.data.parent) {
                  this.$router.push("/myProfile");
                  this.$store.commit("SET_IS_PARENT", false);
                  this.$store.commit("SET_CURRENT_MEMBER", response.data)

                }
              }
    )
      PrizeService.getPrizesByFamilyId()
    .then(response =>
    {
      this.$store.commit("SET_ALL_PRIZES", response.data);
      //this.$router.push('/');
    })

    const promise = MemberService.getUserBooks(this.member.userId)
              promise.then(response => 
                    {
                      console.log(response.data);
                    this.userBooks = response.data
                    }
        )

    },

    
    
  
};
</script>


<style >
@import url('https://fonts.googleapis.com/css2?family=Dosis:wght@800&display=swap');


.header {
  font-family: 'Dosis', sans-serif;
  background-color: #83d8da;
  /* border: 5px solid black; */
  padding: 0 1em;
  border: 5px solid #45547A;
  border-radius: 10px;
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