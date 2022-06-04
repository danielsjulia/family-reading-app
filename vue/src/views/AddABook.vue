<template>
    
  <div>
    <h1>Add A Book</h1>

 <form class="new-book-form" v-on:submit.prevent="addBookToLibrary()">
    <input class="title-input" type="text" placeholder="Title" v-model="book.title" />
    <input class="author-input" type="text" placeholder="Author" v-model="book.author" />
    <input class="isbn-input" type="text" placeholder="ISBN" v-model="book.isbn" />
    <button>Save</button>
  </form>

  </div>
</template>

<script>

import MemberService from '@/services/MemberService'
export default {
    name: 'add-a-book',
    data() {
		return {
			book: {
				title: '',
				author: '',
				isbn: ''
   
			}
		}
	},
	methods: {
        addBookToLibrary(){
            MemberService.addBook(this.book)
                        .then(response =>{
                            if(response.status === 200){
                                console.log(this.book)
                                this.$router.push("/allBooks")
                            }
                        })
        }
    }

}
</script>

<style>
.new-book-form {
    margin: 20px;
}

.new-book-form input, .new-book-form button {
    margin: 10px;
    font-size: 1rem;
}
</style>