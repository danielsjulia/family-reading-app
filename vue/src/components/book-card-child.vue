<template>
  <div class="card" v-bind:class="{ read: book.read }">
    
      <h2 class="book-title">{{ book.title }}</h2>
      <img
        id="img"
        v-if="book.isbn"
        v-bind:src="
          'http://covers.openlibrary.org/b/isbn/' + book.isbn + '-M.jpg'
        "
      />
      <h3 class="book-author">{{ book.author }}</h3>
    
    <!-- <div id="assign-book" >
      <label for="uname">Assign Book:</label>
      <input
        class="text"
        type="text"
        v-model="userBook.username"
        value="username"
      /><br />
      <input class="submit" type="submit" value="submit" />
    </div> -->

    <!-- <br> -->
    <!-- <assign-book v-bind:book="book" v-if = " $route.path == '/allBooks'" /> -->
  </div>
</template>

<script>
import userBookService from "@/services/UserBookService";
// import AssignBook from './AssignBook.vue'

export default {
  name: "book-card-child",
  props: {
    book: Object,
    member: Object,
  },
  data() {
    return {
      userBook: {
        username: "",
        bookId: this.book.bookId,
      },
    };
  },
  components: {
    // AssignBook
  },
  // enableAdd: {
  //         type: Boolean,
  //         default: false
  //     },
  methods: {
    addBook() {
      userBookService.addBookToUser(this.userBook).then((response) => {
        if (response.status == 200) {
          this.$router.push("/allBooks");
          this.userBook.username = "";
          this.userBook.bookId = "";
        } else {
          window.alert("Check if username matches or error occurred");
        }
        this.userBook = {};
      });
    },
    // addToReadingList(book) {
    //     let addedBook = Object.assign({ read: false }, book);
    //     this.$store.commit('SAVE_BOOK', addedBook);
    // }
  },
};
</script>

<style>
@import url("https://fonts.googleapis.com/css2?family=Barlow+Condensed:wght@300");
.card {
  border: 2px solid black;
  border-radius: 10px;
  width: 200px;
  height: 260px;
  margin: 20px;
  padding: 5px;
  padding-bottom: 10px;
  text-align: center;
  background-color: #83d8da;
  font-family: "Barlow Condensed", sans-serif;
}

/* .card.read
{
    background-color: lightgray;
} */

.card .book-title {
  font-size: 1rem;
}

.card .book-author {
  font-size: 1rem;
  margin: 0;
}
.card:hover {
  box-shadow: 1px 1px 5px 3px #c699d1;
}
#img {
  width: 120px;
  height: 120px;
}

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