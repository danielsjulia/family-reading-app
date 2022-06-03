<template>
    
  <div>
    <h1>Add A Book</h1>

 <form class="new-book-form" v-on:submit.prevent="saveBook">
        <input
            class="title-input"
            type="text"
            placeholder="Title"
            v-model="book.title"
        />
        <input
            class="author-input"
            type="text"
            placeholder="Author"
            v-model="book.author"
        />
        <input
            class="isbn-input"
            type="text"
            placeholder="ISBN"
            v-model="book.isbn"
        />
        <button>Save</button>
    </form>

  </div>
</template>

<script>
export default {
    name: 'AddABook',
    data() {
		return {
			book: {
				title: '',
				author: '',
				read: false,
				isbn: ''
   
			}
		}
	},
	methods: {
	saveBook(){
			this.$store.commit('SAVE_BOOK', this.book);
			this.book = {
			title: '',
			author: '',
        isbn: ''
		};
			this.goBack()
		},
		goBack(){
			const route = {name:'allBooks'}
			this.$router.push(route)
		}
		
	}

}
</script>

<style>
.new-releases-list
{
    display: flex;
    justify-content: space-evenly;
    flex-wrap: wrap;
}
</style>