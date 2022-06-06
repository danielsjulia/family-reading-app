<template>
  <div class="readingLog-Display">
    <table class="readingLogTable">
        <tr id="header">
            <!-- <th>ReadingLogId</th> -->
            <!-- <th>UserId</th> -->
            <!-- <th>BookId</th> -->
            <th>Title</th>
            <th>Date</th>
            <th>Minutes Read</th>
            <th>Format</th>
            
            <!-- <th>username</th> -->
            <th>StartingPage</th>
            <th>EndingPage</th>
            <th>Pages Read</th>
            <th>Notes</th>
        
        </tr>
        <tr v-for= "readingLog in readingLogs" :key="readingLog.readingLogId" >
            <!-- <td>{{readingLog.readingLogId}}</td> -->
            <!-- <td>{{readingLog.userId}}</td> -->
            <!-- <td>{{readingLog.bookId}}</td> -->
            <td>{{readingLog.title}}</td>
            <td>{{readingLog.date}}</td>
            <td>{{readingLog.minutes}}</td>
            <td>{{readingLog.format}}</td>
            
            <!-- <td>{{readingLog.username}}</td> -->
            <td>{{readingLog.startingPage}}</td>
            <td>{{readingLog.endPage}}</td>
            <td>{{readingLog.pagesRead}}</td>
            <td>{{readingLog.notes}}</td>
        </tr>
    </table>
  </div>
</template>

<script>
import readingLog from '../services/readingLog.js';

export default {
    name: 'reading-log',
    props: {
        member: Object
    },
    data() {
        return {
            readingLogs: []
        }
    },
    created() {
        readingLog.getReadingLogDTOByUserId(this.member.userId)
        .then(
            response => {
                this.readingLogs = response.data;
            }
        )
    },
    // methods: {
    //     readingLog() {
    //          readingLog.getReadingLogDTOByUserId(this.member.userId)
    //     .then(
    //         response => {
    //             this.readingLogs = response.data;
    //         }
    //     )
       
    // }
    // }


}
</script>

<style>
.readingLogTable {
    /* border: 3px solid black; */
    /* display:block; */
    

    border-collapse: collapse;
    border-radius: 10px;
    margin: 25px 0;
    font-size: 0.9em;
    font-family: sans-serif;
    min-width: 400px;
    width: 100%;
    box-shadow: 0 0 20px rgba(0, 0, 0, 0.15);
}

.readingLogTable #header {
    background-color: teal;
    color: #ffffff;
    text-align: left;
}

.readingLogTable th,
.readingLogTable td {
    padding: 12px 15px;
}

.readingLogTable tr {
    border-bottom: 1px solid #dddddd;
}

.readingLogTable tr:nth-of-type(even) {
    background-color: #f3f3f3;;
}

.readingLogTable {
    border-bottom: 2px solid teal;
}

</style>