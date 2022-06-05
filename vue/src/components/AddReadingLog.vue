<template>
  <div class="form-container">
      <!-- <button @click="showForm()">Add ReadingLog</button> -->
    <h2>Add to your reading log</h2>

    <form  @submit.prevent="addNewReadingLog()" class="log-form" > <!-- @click="$emit('formSubmitted')" -->
     
      <h1></h1>
      <input id="minutes" class="boxes" type="range" min="0" max="60" step="15" placeholder="MinutesRead" v-model="readingLog.minutes" />
      <select class="boxes" v-model="readingLog.format">
        <option value="" disabled selection >Format</option>
        <option value="Paper">Paper</option>
        <option value="Audio">Audio</option>
        <option value="Digital">Digital</option>
        <option value="Reader">Reader</option>
        <option value="Listener">Listener</option>
        <option value="Other">Other</option>
      </select>
      <select class="boxes"  v-model="selectedBook" @change="getBookIdFromTitle(selectedBook)"  > <!-- v-if = " $route.path == '/myProfile' " -->
        <option value="" disabled selection >Book</option>
        <option v-for="book in userBooks" v-bind:key="book.id" >{{book.title}}</option>
      </select>
      <input class="boxes" type="date" placeholder="date" v-model="readingLog.date" />
      <input class="boxes" type="number" placeholder="StartingPage" v-model="readingLog.startingPage" />
      <input class="boxes" type="number" placeholder="EndingPage" v-model="readingLog.endPage" />
      <input class="boxes" type="text" placeholder="Notes" v-model="readingLog.notes" />
      <div class="button-container">
        <button>NewReadingLog</button>
        <button>Cancel</button>
      </div>
      
    </form>
  </div>
</template>

<script>
import readingLogService from '@/services/readingLog.js'
export default {
    name:"add-reading-lod",
    props:{
      member:Object,
      book:Object,
      userBooks: Array
    },
    data(){
        return{
            readingLog : {
                minutes:"",
                format:"",
                date:"",
                startingPage:"",
                endPage:"",
                notes:"",
                bookId: "", 
                userId: this.member.userId,
            },
            selectedBook: ""
        }
    },
 
    methods:{
      addNewReadingLog(){
          readingLogService.addReadingLog(this.readingLog)
                            .then(response => {
                              if(response.status === 200){
                                console.log()
                   }
          this.readingLog = {
                minutes:"",
                format:"",
                date:"",
                startingPage:"",
                endPage:"",
                notes:"",
                bookId: "", 
                userId: this.member.userId,
            }

          })    
      },
      getBookIdFromTitle(title) {
        this.userBooks.forEach(book => {
          if (book.title === title) {
            this.readingLog.bookId = book.bookId;
          }
        })
          
      }
      

    }
}

</script>

<style>
.form-container {
  background-color: rgb(240, 201, 102);
  padding: 10px;
  border-radius: 10px;
  box-shadow: 5px 5px magenta;
  display: flex;
  flex-direction: column;
  flex-wrap: wrap;
}

.log-form {
  display: flex;
  flex-direction: row;
  /* align-items: center; */
}

.boxes {
  height: 30px;
  width: 80%;
  margin: 10px;
  border-radius: 10px;
  box-shadow: 2px 2px magenta;
}

#minutes {
  box-shadow: none;
} 

.button-container {
  display: flex;
}

.button-container button {
  margin: 5px;
  border-radius: 5px;
  border: none;
}
</style>