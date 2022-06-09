<template>
  <div class="participants">
      <h3>THE COMPETITORS:</h3>
       <table class="participants-table">
         <!-- <tr>
           <td>The</td>
           <td>Competitors</td>
         </tr> -->
        <tr id="header">
            <th>User</th>
            <th>Minutes Read</th>
        
        </tr>
        <tr v-for="participant in participants" v-bind:key="participant.id" >
        
            <td>{{participant.username}}</td>
            <td>{{participant.minutes}}</td>
        </tr>
    </table>

    <!-- <h1 v:bind:prize ="prize" 
      v-for="participant in participants"
       v-bind:key="participant.id">
       {{participant.username}} : {{participant.minutes}} mins
    </h1> -->
  </div>
</template>

<script>
import PrizeService from "../services/PrizeService.js";

export default {
  name: "display-participants",
  props: {
    prize: {},
  },
  data() {
    return {
      participants:[]
    };
  },
  created() {
      PrizeService.getParticipants(this.prize.prizeId)
      .then(
          response => {
           
                 this.participants = response.data
             
          }
      )
  }
};
</script>

<style>

.participants {
  /* margin: 5% 30%; */
  margin:auto;
  justify-content: center;
  align-content: center;
  width: 40vw;
  position: 500px;
  text-align: center;
}

.participants h3 {
  text-shadow: 2px 2px #FFE7D5;
  color: #EC5C67;
}

.participants-table {
  padding-left: 20%;
  width: 100%;
  margin-bottom: 1vh;
}

/* .participants h4 {
  margin: 5% 30%;
  align-content: left;
} */
/* 
.participants-table {
   border-collapse: collapse;
    border-radius: 10px;
    margin: 25px 0;
    font-size: 0.9em;
    font-family: sans-serif;
    min-width: 400px;
    width: 100%;
    box-shadow: 0 0 20px rgba(0, 0, 0, 0.15);
    border-bottom: 2px solid teal;
}
#header {
    background-color: teal;
    color: #ffffff;
    text-align: left;
}

.participants-table th,
.participants-table td {
    padding: 12px 15px;
}

tr:nth-of-type(even) {
    background-color: #f3f3f3;;
} */

</style>