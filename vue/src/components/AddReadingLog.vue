<template>
  <div>
      <!-- <button @click="showForm()">Add ReadingLog</button> -->

    <form  @submit="addNewReadingLog()">
     
      <h1></h1>
        <input type="range" min="0" max="60" step="15" placeholder="MinutesRead" v-model="readingLog.minutes"/>
        <select v-model="readingLog.format">
        <option value="Paper">Paper</option>
        <option value="Audio">Audio</option>
        <option value="Digital">Digital</option>
        <option value="Reader">Reader</option>
        <option value="Listener">Listener</option>
        <option value="Other">Other</option>
      </select>
       <input type="date" placeholder="date" v-model="readingLog.date"/>
        <input type="number" placeholder="StartingPage" v-model="readingLog.startingPage"/>
         <input type="number" placeholder="EndingPage" v-model="readingLog.endPage"/>
          <input type="text" placeholder="Notes" v-model="readingLog.notes"/>
          <button>NewReadingLog</button>
          <button>Cancel</button>
     
    </form>
  </div>
</template>

<script>
import readingLogService from '@/services/readingLog.js'
export default {
    name:"add-reading-lod",
    props:{
      member:Object,
      book:Object
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
                bookId: this.book.bookId,
                userId:this.member.userId,
            }
        }
    },
 
    methods:{
      addNewReadingLog(){
          readingLogService.addReadingLog(this.readingLog)
                            .then(response => {
                              if(response.status === 200){
                                console.log()
                   }

          })    
      }

    }
}

</script>

<style>

</style>