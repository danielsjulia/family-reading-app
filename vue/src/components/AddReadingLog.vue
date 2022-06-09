<template>
  <div class="form-container">
      <!-- <button @click="showForm()">Add ReadingLog</button> -->
    <h2 class="head1">Add to your reading log</h2>

    <!-- <FONT onMouseOver="this.innerHTML = 'WebNots Web Consulting Services'"
onMouseOut="this.innerHTML = 'WebNots'">WebNots</FONT> -->
<!-- 
    <h4 class="head1">Select reading Time</h4> -->
    <form  @submit.prevent="addNewReadingLog()" class="log-form form-display" >
    <span id = "minSelect" class= "options">
      <button value= 15 @click.prevent="readingLog.minutes = 15"><div class="minTime15 time"></div>15 min</button>
      <button value= 30 @click.prevent="readingLog.minutes = 30"><div class="minTime30 time"></div>30 min</button>
      <button value= 45 @click.prevent="readingLog.minutes = 45"><div class="minTime45 time"></div>45 min</button>
      <button value= 60 @click.prevent="readingLog.minutes = 60"><div class="minTime60 time"></div>60 min</button>
      <span>{{readingLog.minutes}} minutes</span>
    </span>
    <span>
      <!-- <h4 class="head1">Select the Format of Book Reading</h4> -->
    </span>
    <span id = "format" class ="options">
        <button class="format paper" value="Paper" @click.prevent="readingLog.format = 'Paper' ">
          <div class="Paper">
            <img src="../../images/bookFormatSimple.png" />
          </div></button>
        <button class="format audio " value= "Audio" @click.prevent="readingLog.format = 'Audio' "><div class="Audio"><img src="../../images/audioFormat.jpg" /></div></button> 
        <button class="format digital" value= "Digital" @click.prevent="readingLog.format = 'Digital' "><div class="Digital"><img src="../../images/digitalFormat.jpg" /></div></button> 
        <button class="format reader" value= "Reader" @click.prevent="readingLog.format = 'Reader'"><div class="Reader"><img src="../../images/readerIcon.jpg" /></div></button> 
        <button class="format listener" value= "Listener" @click.prevent="readingLog.format = 'Listener'"><div class="Listener"><img src="../../images/listening-story.jpg" /></div></button> 
        <button class="format other" value= "Other" @click.prevent="readingLog.format = 'Other'"><div class="Other"><img src="../../images/kidsReading.jpg" /></div></button>
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
    
    <!-- <span>Select Date</span> -->
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
  /* padding: 10px; */
  border-radius: 10px;
  box-shadow: 5px 5px teal;
  display: flex;
  flex-direction: column;
  flex-wrap: wrap;
  align-items:center;
  font-size: 20px;
}
.form-container  * {
  /* margin-bottom: 10px; */
  margin:0;

}
.form-display {
  display:flex;
  flex-direction: column;
}

/* .log-form {
  display: flex;
  flex-direction: row;
  
} */

.head1{
  padding:10px
}
.boxes {
  height: 30px;
  width: 80%;
  margin: 10px;
  border-radius: 10px;
  box-shadow: 2px 2px teal;
}

#minutes {
  box-shadow: none;
} 


.time:hover::after {
  font-size: 20px;
  color:white;
}

.format:hover {
  transition: all 800ms !important;

  inline-size: 120px;
  overflow-wrap: break-word !important;
}


.format:hover::after {
  font-size: 15px;
  color:white;

}
.audio:hover::after {
content: "Audio Books";
}
.paper:hover::after {
content: "Traditional Books";
}

.digital:hover::after {
content: "Reading on computer or kindle";
}

.reader:hover::after {
content: "Reading Aloud";
}

.listener:hover::after {
content: "Someone read to you"  ;
}

.other:hover::after {
content: "Any Other";
}
.button-container {
  display: flex;
  width: 100%;
  justify-content: space-around;
  
}
.button-container > button {

  background-color: white;
  border: 2px dotted black;
  font-size:20px;
}
.button-container >button:hover {
  /* background-color:turquoise; */
  font-size: 20px;
  /* border-radius: 50%; */
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
  background:repeating-conic-gradient(
    from 0deg,
    red 0deg 90deg,
    green 90deg 360deg
  )
}
.minTime30 {
  
  background:repeating-conic-gradient(
    from 0deg,
    red 0deg 180deg,
    green 180deg 360deg
  )
}
.minTime45 {
  
  background:repeating-conic-gradient(
    from 0deg,
    red 0deg 270deg,
    green 270deg 360deg
  )
}
.minTime60 {
  
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
  background-color: green;
  border-radius: 50%;
}

span>button>div>img {
  height: 50px;
  width: 50px;
  border-radius: 50%;
}
/* button {
  background-color: rgb(240, 201, 102);
  border: none;
  border-radius: 50%;
} */
/* button:hover {
  font-size: 20px;
  transition: all 400ms;
  
} */


</style>