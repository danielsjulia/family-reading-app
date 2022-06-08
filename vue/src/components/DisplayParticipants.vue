<template>
  <div class="participants">

       <table class="participants-table">
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
      PrizeService.getParticipants(1)
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
  margin: 5% 30%;
  justify-content: center;
  align-content: center;
  width: 40vw;
  position: 500px;;
}
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
}

</style>