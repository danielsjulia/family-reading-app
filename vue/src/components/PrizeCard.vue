<template>
  <div class="prize-card">
    <router-link to="{ path = '/winnerPage'                                                                           ,l" v-bind:winners="winners">
        <h1 class="prize-name">{{prize.name}}</h1>
        <h3 class="description">{{prize.description}}</h3>
        <h3 class="end-date">Expires on {{prize.endDate}}</h3>
        <h4 class="num-of-winners">Only {{prize.numberOfWinners}} can win the prize</h4>
        <h1>Read {{prize.milestone}} minutes</h1>
    </router-link>
  </div>
</template>

<script>
export default {
    name: "PrizeCard",
    props: {
        prize: {},
        winners:[]
    },
    data() {
        return {
            thisPrizeWinners : this.winners
        }
    }

}
</script>

<style>
.prize-card{ 
    width: 100vw;
    display: flex;
    flex-direction: row;
    flex-wrap: wrap;
    justify-content: space-evenly;
    align-content: center;
    border-top: 10px solid whitesmoke;
    
}

</style>