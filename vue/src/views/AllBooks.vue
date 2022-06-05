<template>
  <div class="book-container" >
    <!-- <p>test text</p>
    <router-link to= "/bookDetail" > -->
      <book-card v-bind:book="book" v-for="book in $store.state.allBooks" v-bind:key="book.id" /> <!-- v-on:click.native="details(book.isbn)"/> -->
    <!-- </router-link> -->
    <add-a-book />
  </div>
</template>

<script>
import BookCard from '@/components/BookCard.vue';
import AddABook from './AddABook.vue';


export default {
    name: 'all-books',
    components: {
        BookCard,
        AddABook
        
    }

}
</script>

<style>
.book-container
{
    display: flex;
    justify-content: space-evenly;
    flex-wrap: wrap;
}
</style>