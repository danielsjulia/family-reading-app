<template>
  <div>
      <h1 v:bind:prize ="prize" v-for="participant in participants" v-bind:key="participant.id">{{participant.username}} : {{participant.minutes}} mins</h1>
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
</style>