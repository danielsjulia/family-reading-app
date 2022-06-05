<template>
  <div class="card" v-bind:class="{ read: book.read }">
    <router-link to= "/bookDetail" >
    <h2 class="book-title">{{ book.title }}</h2>
    </router-link>
    <img v-if="book.isbn" v-bind:src="'http://covers.openlibrary.org/b/isbn/' + book.isbn + '-M.jpg'" />
    <h3 class="book-author">{{ book.author }}</h3>
    <!-- <div class="button-container" v-if="! enableAdd">
        <button class="mark-read" v-on:click.prevent="setRead(true)" v-if=" ! book.read">Mark Read</button>
        <button class="mark-unread" v-on:click.prevent="setRead(false)" v-if="book.read">Mark Unread</button>
    </div> -->
    <br>
    <assign-book to:v-if = "{this.$route.name == 'all-books'}" />
    <!-- <router-link :to="{name: 'bookDetails', params: {isbn: book.isbn}}">Details</router-link> -->
    <!-- <button v-if="enableAdd" v-on:click.prevent="addToReadingList(book)">Add to Reading List</button> -->
  </div>

</template>

<script>

import AssignBook from './AssignBook.vue'

export default {
    name: 'book-card',
    props: {
        book: Object,
        member: Object
    },
    components: {
        AssignBook

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
.card
{
    border: 2px solid black;
    border-radius: 10px;
    width: 250px;
    height: 450px;
    margin: 20px;
    text-align: center;
}

.card.read
{
    background-color: lightgray;
}

.card .book-title
{
    font-size: 1.5rem;
}

.card .book-author
{
    font-size: 1rem;
}
</style>