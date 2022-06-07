<template>
  <div>
      <table class="prize-display">
        <tr id="header">
            <!-- <th>ReadingLogId</th> -->
            <!-- <th>UserId</th> -->
            <!-- <th>BookId</th> -->
            <th>Name</th>
            <th>Description</th>
            <th>Start Date</th>
            <th>End Date</th>
            
            <!-- <th>username</th> -->
            <th>Milestone</th>
            <th>Number Of Winners</th>

        
        </tr>
        <tr v-for= "prize in prizes" :key="prize.id" >
            <!-- <td>{{readingLog.readingLogId}}</td> -->
            <!-- <td>{{readingLog.userId}}</td> -->
            <!-- <td>{{readingLog.bookId}}</td> -->
            <td>{{prize.name}}</td>
            <td>{{prize.description}}</td>
            <td>{{prize.startDate}}</td>
            <td>{{prize.endDate}}</td>
            
            <!-- <td>{{readingLog.username}}</td> -->
            <td>{{prize.milestone}}</td>
            <td>{{prize.numberOfWinners}}</td>
            <td> {{winners}} </td>

        </tr>
      </table>
  </div>
</template>

<script>
import PrizeService from '../services/PrizeService.js';


export default {
    name: "prizeDisplay",
    props: {
        prize: Object, 
        prizes:[]
    },
    data() {
        return {
            winners: []
            
        }
    },
    methods: {
        prizeWinners(prizeId) {

            PrizeService.getWinners(prizeId)
            .then(
                response => {
                    console.log(response.data)
                    this.winners = response.data
                }
            )
            // return null
        }

    }
    // created() {

    //     PrizeService.getWinners(this.prizes.id) {

    //     }
    // }
    
}
</script>

<style>

.prize-display {
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

.prize-display #header {
    background-color: teal;
    color: #ffffff;
    text-align: left;
}

.prize-display th,
.prize-display td {
    padding: 12px 15px;
}

.prize-display tr {
    border-bottom: 1px solid #dddddd;
}

.prize-display tr:nth-of-type(even) {
    background-color: #f3f3f3;;
}

.prize-display {
    border-bottom: 2px solid teal;
}

</style>