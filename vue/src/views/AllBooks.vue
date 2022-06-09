<template>
  <div class="book-container">
      <div class="head">
        <h1>Book Library</h1>
      </div>
    <div class="bookBar">
      <add-a-book />
    </div>

    <!-- <p>test text</p>
    <router-link to= "/bookDetail" > -->
  <div class ="book-card">
    <book-card 
      v-bind:book="book"
      v-for="book in $store.state.allBooks"
      v-bind:key="book.id"
    />
  </div>
    <!-- v-on:click.native="details(book.isbn)"/> -->
    <!-- </router-link> -->
  </div>
</template>

<script>
import BookCard from "@/components/BookCard.vue";
import AddABook from "./AddABook.vue";
import MemberService from '../services/MemberService.js';

export default {
  name: "all-books",
  components: {
    BookCard,
    AddABook,
  },
  created() {
    MemberService.getAllBooks()
    .then(
      response => {
        this.$store.commit("SET_ALL_BOOKS", response.data);
        this.userBooks = response.data
      }
    );
  }
};
</script>

<style>
@import url('https://fonts.googleapis.com/css2?family=Barlow+Condensed:wght@300');
.head{
  font-family: 'Barlow Condensed', sans-serif;
  text-align: center;

}
.book-container{
  background-color:  #aeeaea;
}

.book-card{
  display: flex;
  flex-direction: row;
  justify-content: space-evenly;
  flex-wrap: wrap;
}

.bookBar {

  display: block;
  text-align: center;
}
</style>