<template>
  <div class="book-container" >
    <p>test text</p>
    <book-card v-bind:book="book" v-for="book in $store.state.allBooks" v-bind:key="book.isbn" /> <!-- v-on:click.native="details(book.isbn)"/> --> 
  </div>
</template>

<script>
import BookCard from '@/components/BookCard.vue';

export default {
    name: 'all-books',
    components: {
        BookCard
    }

}
</script>

<style>

</style>