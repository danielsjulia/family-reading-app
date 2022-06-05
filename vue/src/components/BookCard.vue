<template>
  <div class="card" v-bind:class="{ read: book.read }">
    <router-link to= "/bookDetail" >
        <h2 class="book-title" > {{ book.title }} </h2>
        
        <img v-if="book.isbn" v-bind:src="'http://covers.openlibrary.org/b/isbn/' + book.isbn + '-M.jpg'" />
        <h3 class="book-author">{{ book.author }}</h3>
    </router-link>
    <br>
    <assign-book v-if = " $route.path == '/allBooks'" />
  </div>

</template>

<script>

import AssignBook from './AssignBook.vue'

export default {
    name: 'book-card',
    // bookID: this.book.bookId,
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
    background-color:lavenderblush;
}

/* .card.read
{
    background-color: lightgray;
} */

.card .book-title
{
    font-size: 1.5rem;
}

.card .book-author
{
    font-size: 1rem;
}
</style>