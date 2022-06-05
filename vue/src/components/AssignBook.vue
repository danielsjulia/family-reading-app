<template>
  <div ><!--v-if="this.$store.state.isParent === true"-->
      <p>Enter username to assign book to: </p>
      <input type="text" v-model = "userBookConnection.username" value= "username">

    </div>
</template>

<script>

export default {
    
    name: 'AssignBook',
    data() {
        return {
            userBookConnection: {
                username: '',
                // bookId: this.bookId
            } 
        }
    },
    // props: [book],
    methods: {
        // get the id from username 
        // add to user_book with (book_id, user_id) in user_book table on the database..
    }


}
</script>

<style>

</style>
