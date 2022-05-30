<template>
    <div>
        <!-- <h1>Family Reading</h1> -->

        <div id="nav">
      <router-link v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'add-a-book' }" v-if="$store.state.token != ''">Add A Book</router-link>
    </div>

    </div>
</template>

<script>
    export default {
        name: 'nav-bar',
    }
</script>

<style scoped>

</style>