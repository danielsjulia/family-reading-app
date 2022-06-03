<template>
  <div class="card" v-bind:class="{ read: book.read }">
    <h2 class="book-title">{{ book.title }}</h2>
    
    <img v-if="book.isbn" v-bind:src="'http://covers.openlibrary.org/b/isbn/' + book.isbn + '-M.jpg'" />
    <h3 class="book-author">{{ book.author }}</h3>
    <!-- <div class="button-container" v-if="! enableAdd">
        <button class="mark-read" v-on:click.prevent="setRead(true)" v-if=" ! book.read">Mark Read</button>
        <button class="mark-unread" v-on:click.prevent="setRead(false)" v-if="book.read">Mark Unread</button>
    </div> -->
    <br>
    <!-- <router-link :to="{name: 'bookDetails', params: {isbn: book.isbn}}">Details</router-link> -->
    <!-- <button v-if="enableAdd" v-on:click.prevent="addToReadingList(book)">Add to Reading List</button> -->
  </div>

</template>

<script>
export default {
    name: 'book-card',
    props: {
        book: Object
    },
    // enableAdd: {
    //         type: Boolean,
    //         default: false
    //     },
    methods: {
        // addToReadingList(book) {
        //     let addedBook = Object.assign({ read: false }, book);
        //     this.$store.commit('SAVE_BOOK', addedBook);
        // }

    }

}
</script>

<style>

</style>