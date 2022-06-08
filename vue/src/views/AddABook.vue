<template>
    
  <div>
    

 <form class="new-book-form" v-on:submit.prevent="addBookToLibrary()">
     <h3 id = "title">Add A Book</h3>
    <input class="title-input" type="text" placeholder="Title" v-model="book.title" />
    <input class="author-input" type="text" placeholder="Author" v-model="book.author" />
    <input class="isbn-input" type="text" placeholder="ISBN" v-model="book.isbn" />
    <button>Save</button>
    <button v-on:click="clearForm()" >Cancel</button>
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
        clearForm() {
            this.book = {};
        },
        addBookToLibrary(){
            MemberService.addBook(this.book)
                        .then(response =>{
                            if(response.status === 200){
                                console.log(this.book)
                                this.$router.push("/allBooks")
                            }
            this.book ={
            title: '',
			author: '',
		isbn: ''
   
                            }
                        })
        }
    }

}
</script>

<style>
@import url('https://fonts.googleapis.com/css2?family=Barlow+Condensed:wght@300');
.new-book-form {
    background-color: lightsalmon;
    box-shadow: 1px 1px 5px 3px #c699d1;
    border-radius: 10px;
    border-width: 50%;
    margin:0 20rem;
    font-family: 'Barlow Condensed', sans-serif;
    padding-bottom: 10px;
    
     
}

.new-book-form input, .new-book-form button {
    margin: 10px;
    font-size: .8rem;
    border-radius: 30px;
    border:2px solid pink;
    
}
#title{
    padding-top: 10px;
    margin:0;
}
</style>