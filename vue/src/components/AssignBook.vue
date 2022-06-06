<template>
  <div>
    <!--v-if="this.$store.state.isParent === true"-->
    <form  class="assign-book" @submit.prevent="addBook()">
      <label for="uname">Assign Book:</label>
      <input class="text" type="text" v-model="userBook.username" value="username" /><br>
      <input class="submit" type="submit" value="submit" />
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
        bookId: this.book.bookId,
      },
    };
  },
  props: ['book'],
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
@import url('https://fonts.googleapis.com/css2?family=Barlow+Condensed:wght@300');

.assign-book{
  font-family: 'Barlow Condensed', sans-serif;
  margin:0;
  font-weight: bold; 
}
.text{
    width:100px;
    height:10px;
    border-radius: 10px;
    border:2px solid pink;
}
.submit{
    border:2px solid pink;
    border-radius: 10px;

}

</style>
