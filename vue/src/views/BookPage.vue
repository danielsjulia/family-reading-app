<template>
  <div>
    this is book page
    <p>Detail</p> 
    - author <br>
    - published date <br>
    - publisher name <br>
    - target audience <br>
    
    
    <h1>{{book.title}}</h1>
    <h2>{{book.author}}</h2>
    <h2>book id: {{book.bookId}}</h2>

    <p>------------------------------------</p>

    <h1>{{member.username}}'s Book Log</h1>
    <h2> user id: {{member.userId}}</h2>

    <assign-book />
    




  </div>

</template>

<script>
import AssignBook from '../components/AssignBook.vue'
export default {
  components: { AssignBook },
  name: 'BookPage',
  props: {
    book: Object,
    member: Object
  }

}
</script>

<style>

</style>