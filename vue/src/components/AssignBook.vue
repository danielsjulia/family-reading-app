<template>
  <div>
    <!--v-if="this.$store.state.isParent === true"-->
    <form @submit.prevent="addBook()">
      <p>Enter username to assign book to:</p>
      <input type="text" v-model="userBook.username" value="username" />
      <input type="submit" value="submit" />
    </form>
  </div>
</template>

<script>
import userBookService from "@/services/UserBookService";

export default {
  name: "AssignBook",
  data() {
    return {
      userBook: {
        username: "",
        bookId: 3,
      },
    };
  },
  // props: [book],
  methods: {
    // get the id from username
    // add to user_book with (book_id, user_id) in user_book table on the database..
    addBook() {
      userBookService.addBookToUser(this.userBook).then((response) => {
        if (response.status == 201) {
          this.$router.push("/allBooks");
          this.userBook.username = "";
        } else {
          alert("Check if username matches or error occurred");
        }
      });
    },
  },
};
</script>

<style>
</style>
