<template>
  <div class="form-container">
      <!-- <button @click="showForm()">Add ReadingLog</button> -->
    <h2>Add to your reading log</h2>

    <h3>Select reading Time</h3>
    <form  @submit.prevent="addNewReadingLog()" class="log-form form-display" >
    <span id = "minSelect" class= "options">
      <button value= 15 @click.prevent="readingLog.minutes = 15"><div class="minTime15 time"></div>15 min</button>
      <button value= 30 @click.prevent="readingLog.minutes = 30"><div class="minTime30 time"></div>30 min</button>
      <button value= 45 @click.prevent="readingLog.minutes = 45"><div class="minTime45 time"></div>45 min</button>
      <button value= 60 @click.prevent="readingLog.minutes = 60"><div class="minTime60 time"></div>60 min</button>
      <span>{{readingLog.minutes}} minutes</span>
    </span>
    <span>
      <h3>Select the Format of Book Reading</h3>
    </span>
    <span id = "format" class ="options">
        <button value="Paper" @click.prevent="readingLog.format = 'Paper' ">
          <div class="paper">
            <img src="../../images/bookFormatSimple.png" />
          </div>Paper</button>
        <button value= "Audio" @click.prevent="readingLog.format = 'Audio' "><div class="Audio"><img src="../../images/audioFormat.jpg" /></div>Audio</button>
        <button value= "Digital" @click.prevent="readingLog.format = 'Digital' "><div class="Digital"><img src="../../images/digitalFormat.jpg" /></div>Digital</button>
        <button value= "Reader" @click.prevent="readingLog.format = 'Reader'"><div class="Reader"><img src="../../images/readerIcon.jpg" /></div>Reader</button>
        <button value= "Listener" @click.prevent="readingLog.format = 'Listener'"><div class="Listener"><img src="../../images/listening-story.jpg" /></div>Listener</button>
        <button value= "Other" @click.prevent="readingLog.format = 'Other'"><div class="Other"><img src="../../images/kidsReading.jpg" /></div>Other</button>
        <span>{{readingLog.format}}</span>
      <br>
      <br>
      <br>
      <br>
      <br>
      <br>
      </span>
      <span >
        <select class="boxes"  v-model="selectedBook" @change="getBookIdFromTitle(selectedBook)"  > 
          
          <option value="" disabled selection >Book</option>
          <option v-for="book in userBooks" v-bind:key="book.id" >{{book.title}}</option>
        </select>
      </span>
    
    <span>Select Date</span>
    <span>
      <input class="boxes day" type="date" placeholder="date" v-model="readingLog.date" />
    </span>
    <span><input class="boxes" type="number" placeholder="StartingPage" v-model="readingLog.startingPage" /></span>
    <span><input class="boxes" type="number" placeholder="EndingPage" v-model="readingLog.endPage" /></span>
    <span><input class="boxes" type="text" placeholder="Notes" v-model="readingLog.notes" /></span>
    <div class="button-container">
        <button>NewReadingLog</button>
        <button>Cancel</button>
    </div> 
    </form>

    <!-- @click="$emit('formSubmitted')" -->
    <!-- <form  @submit.prevent="addNewReadingLog()" class="log-form" > 
      
     
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
      <select class="boxes"  v-model="selectedBook" @change="getBookIdFromTitle(selectedBook)"  > 
        
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
      
    </form> -->
    <!-- v-if = " $route.path == '/myProfile' " -->
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

          this.$emit('formSubmitted');

        //     readingLog.getReadingLogDTOByUserId(this.member.userId)
        // .then(
        //     response => {
        //         this.readingLogs = response.data;
        //     }
        // )

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
  align-items:center;
  font-size: 25px;
}
.form-container  * {
  margin-bottom: 10px;;
}
.form-display {
  display:flex;
  flex-direction: column;
}

/* .log-form {
  display: flex;
  flex-direction: row;
  
} */

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

button {
  background-color: rgb(240, 201, 102);
  border: none;
  border-radius: 50%;
}
button:hover {
  background: white;
  font-size: 25px;
}

.button-container {
  display: flex;
  width: 100%;
  justify-content: space-evenly;
  
}
.button-container > button {
  background-color: white;
  border: 2px dotted black;
  font-size: 20px;
}
.button-container >button:hover {
  background: white;
  font-size: 30px;
}
#minSelect {
  
  display: flex;
  flex-direction: row;
  align-items: center;
  justify-content: space-evenly;
 
}
.options {
  
  display: flex;
  flex-direction: row;
  align-items: center;
  justify-content: space-evenly;

}

.minTime15 {
  width: 10vw;
  height: 10vh;
  border-radius: 50%;
  background-color: green;
  background:repeating-conic-gradient(
    from 0deg,
    red 0deg 90deg,
    green 90deg 360deg
  )
}
.minTime30 {
  width: 10vw;
  height: 10vh;
  border-radius: 50%;
  background-color: green;
  background:repeating-conic-gradient(
    from 0deg,
    red 0deg 180deg,
    green 180deg 360deg
  )
}
.minTime45 {
  width: 10vw;
  height: 10vh;
  border-radius: 50%;
  background-color: green;
  background:repeating-conic-gradient(
    from 0deg,
    red 0deg 270deg,
    green 270deg 360deg
  )
}
.minTime60 {
  width: 10vw;
  height: 10vh;
  border-radius: 50%;
  background-color: green;
  background:repeating-conic-gradient(
    from 0deg,
    red 0deg 360deg
  )
}

.button-container button {
  margin: 5px;
  border-radius: 5px;
  border: none;
}

.time {
  height: 50px;
  width: 50px;
  border-radius: 50%;
}

span>button>div>img {
  height: 50px;
  width: 50px;
  border-radius: 50%;
}

/* .day {
  background: transparent;
  color: white;
}
.day::-webkit-calendar-picker-indicator {
  filter: invert(100%);
} */
</style>