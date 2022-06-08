<template>
  <div class="prize-card">
    <router-link :to="{name:'PrizeWinners', params:{prize, winners}}" >  
        <h1 class="prize-name">{{prize.name}}</h1>
        <h3 class="description">{{prize.description}}</h3>
        <h3 class="end-date">Win by {{prize.endDate}}</h3>
        <h4 class="num-of-winners">Only {{prize.numberOfWinners}} can win the prize</h4>
        <h1>Read {{prize.milestone}} minutes</h1>
    </router-link>
    <display-participants v-bind:prize= "prize" />
  </div>
</template>

<script>
import DisplayParticipants from './DisplayParticipants.vue'
export default {
  components: { DisplayParticipants },
    name: "PrizeCard",
    props: {
        prize: Object,
        winners:[]
    },
    data() {
        return {
            thisPrizeWinners : this.winners,
            thisPrize: this.prize
        }
    }

}
</script>

<style>
@import url('https://fonts.googleapis.com/css2?family=Dosis:wght@800&display=swap');


.prize-card{ 
    width: 100%;
    height: 100%;
    /* display: inline-flex;
    flex-direction: row;
    flex-wrap: wrap;
    justify-content: space-evenly;
    align-content: center; */
    border-top: 10px solid whitesmoke;
    font-family: 'Dosis', sans-serif;
    /* text-decoration: none; */
}

.prize-name {
    text-transform: uppercase;
}

</style>