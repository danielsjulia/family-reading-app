<template>
  <div class="prize-display">
      
        <prize-card class="prize-card" v-for="prize in prizes" 
        v-bind:key="prize.id" v-bind:prize="prize" 
        v-bind:winners="winners" />
        <!-- <display-participants v-bind:prize= "prize" /> -->
      
<!-- 
      <table class="prize-display">
        <tr id="header">
   
            <th>Name</th>
            <th>Description</th>
            <th>Start Date</th>
            <th>End Date</th>
  
            <th>Milestone</th>
            <th>Number Of Winners</th>
            <th>Winners!</th>

        
        </tr>
        <tr v-bind:prize="prize" v-for= "prize in prizes" :key="prize.id" >
          
            <td>{{prize.name}}</td>
            <td>{{prize.description}}</td>
            <td>{{prize.startDate}}</td>
            <td>{{prize.endDate}}</td>
            
         
            <td>{{prize.milestone}}</td>
            <td>{{prize.numberOfWinners}}</td>
           
            <td v-for="winner in winners" v-bind:key="winner.id" > {{winners.username, }} </td>

        </tr>
      </table> -->
  </div>
</template>

<script>
import PrizeService from '../services/PrizeService.js';
import PrizeCard from "../components/PrizeCard.vue"
// import DisplayParticipants from "../components/DisplayParticipants.vue"


export default {
    name: "prizeDisplay",
    props: {
        //prize: Object, 
        prizes:[]
    },
    components: {
        PrizeCard,
        // DisplayParticipants
    },
    data() {
        return {
            winners: [],
            prize: {},
            //prizes:[]
            
        }
    },
    // computed: {
    //     winners(prize-Id) {

    //          return getWinners(prize-Id)
    //     }

    // },
    // methods: {
    //     getWinners(prizeId) {
    //         PrizeService.getWinners(prizeId)
    //         .then(
    //             response => {
    //                 console.log(response.data)
    //                 this.winners = response.data
    //             }
    //         )
    //     }
    // },
    created() {
            PrizeService.getWinners(1)
            .then(
                response => {
                    console.log(response.data)
                    this.winners = response.data
                }
            )
            
        }
    }
</script>

<style>

.prize-display {
    /* border: 3px solid black; */
    /* display:block; */
    width: 100vh;
    display: flex;
    flex-direction: row;
    justify-self: space-between;
    /* flex-wrap: wrap; */
    /* justify-content: space-evenly; */
    align-content: center;
    border-top: 10px solid whitesmoke;
    
/* 
    border-collapse: collapse;
    border-radius: 10px;
    margin: 25px 0;
    font-size: 0.9em;
    font-family: sans-serif;
    min-width: 400px;
    width: 100%;
    box-shadow: 0 0 20px rgba(0, 0, 0, 0.15);
     */
}

.prize-display .prize-card {
    display: inline-block;
    flex-grow: 1;
    background: #449aeb;
    border: 1px green solid;
    border-radius: 60px;
    padding: 1rem;
    margin: 15px;
    text-align: center;
    box-shadow: 10px 10px rgb(240, 100, 65);
    width: 45vw;

}
/* 
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
} */

</style>