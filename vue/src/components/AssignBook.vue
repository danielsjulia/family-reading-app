<template>
  <div>
      <input type="text" v-model = "username" value= "username">
      assign book</div>
</template>

<script>
export default {
    name: 'AssignBook',
    data() {
        return {
            username: ''
        }
    },
    methods: {
        // get the id from username 
        // add to user_book with (book_id, user_id) in user_book table on the database..
    }


}
</script>

<style>

</style>
