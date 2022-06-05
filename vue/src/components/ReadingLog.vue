<template>
  <div>
    <table class="readingLogTable">
        <tr>
            <th>ReadingLogId</th>
            <th>UserId</th>
            <th>BookId</th>
            <th>date</th>
            <th>minutes</th>
            <th>format</th>
            <th>Title</th>
            <th>username</th>
            <th>StartingPage</th>
            <th>EndingPage</th>
            <th>PagesRead</th>
            <th>Notes</th>
        
        </tr>
        <tr v-for= "readingLog in readingLogs" :key="readingLog.readingLogId" >
            <td>{{readingLog.readingLogId}}</td>
            <td>{{readingLog.userId}}</td>
            <td>{{readingLog.bookId}}</td>
            <td>{{readingLog.date}}</td>
            <td>{{readingLog.minutes}}</td>
            <td>{{readingLog.format}}</td>
            <td>{{readingLog.title}}</td>
            <td>{{readingLog.username}}</td>
            <td>{{readingLog.startingPage}}</td>
            <td>{{readingLog.endingPage}}</td>
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
    border: 1px solid black;
}

</style>