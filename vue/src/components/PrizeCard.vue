<template>
  <div class="prize-card">
    <router-link :to="{name:'PrizeWinners', params:{prize, winners}}" >  
        <h1 class="prize-name">{{prize.name}}</h1>
        <h3 class="description">{{prize.description}}</h3>
        <h3 class="end-date">Win by {{prize.endDate}}</h3>
        <h4 class="num-of-winners">Only {{prize.numberOfWinners}} can win the prize</h4>
        <h1>Read {{prize.milestone}} minutes</h1>
    </router-link>
  </div>
</template>

<script>
export default {
    name: "PrizeCard",
    props: {
        prize: Object,
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
    width: 100%;
    height: 100%;
    /* display: inline-flex;
    flex-direction: row;
    flex-wrap: wrap;
    justify-content: space-evenly;
    align-content: center; */
    border-top: 10px solid whitesmoke;
}

.prize-name {
    text-transform: uppercase;
}

</style>