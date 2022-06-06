<template>
  <div class="card" v-bind:class="{ read: book.read }">
    <router-link to= "/bookDetail" >
        <h2 class="book-title" > {{ book.title }} </h2>
        <img  v-if="book.isbn" v-bind:src="'http://covers.openlibrary.org/b/isbn/' + book.isbn + '-M.jpg'" />
        <h3 class="book-author">{{ book.author }}</h3>
    </router-link>
    <!-- <br> -->
    <assign-book v-if = " $route.path == '/allBooks'" />
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

@import url('https://fonts.googleapis.com/css2?family=Barlow+Condensed:wght@300');
.card
{
    border: 2px solid black;
    border-radius: 10px;
    width: 200px;
    height: 260px;
    margin: 20px;
    padding: 5px;
    text-align: center;
    background-color:rgba(248, 222, 245, 0.603);
    font-family: 'Barlow Condensed', sans-serif;
   
}

/* .card.read
{
    background-color: lightgray;
} */

.card .book-title
{
    font-size: 1rem;
}

.card .book-author
{
    font-size: 1rem;
    margin:0
}
.card:hover{
      box-shadow: 1px 1px 5px 3px #c699d1;
}
img{
    width:120px;
    height:120px;
}
</style>