<template>
  <div class="winner-page">
    <h1>Winners for {{prize.name}}!</h1>
    <div class="winner-container" >
    <member-card
      class="winner-card"
      v-bind:member="member"
      v-for="member in winners"
      v-bind:key="member.id"
    />
    </div>
  </div>
</template>

<script>
import MemberCard from "../components/MemberCard.vue";
import PrizeService from '../services/PrizeService.js';

export default {
  components: { MemberCard },
  name: "PrizeWinners",
  props: {
    prize: Object,
    // winners: Array,
  },
  component: {
    MemberCard,
  },
  data() {
    return {
      winners: []
    };
  },
  created() {
            PrizeService.getWinners(this.prize.prizeId)
            .then(
                response => {
                    console.log(response.data)
                    this.winners = response.data
                }
            )
            
        }
};
</script>

<style>
@import url('https://fonts.googleapis.com/css2?family=Dosis:wght@800&display=swap');


.winner-page {
  font-family: 'Dosis', sans-serif;
  /* width: 100vw; */
  display: flex;
  flex-direction: row;
  justify-self: space-between;
    flex-wrap: wrap;
    /* justify-content: space-evenly; */
  /* align-content: center; */
  border-top: 10px solid whitesmoke;

  height: 100vh;
  width: 100vw;
  background-image: url("../../images/confetti_white.gif");
  background-size: 100vw;
  /* repeat-y 100% 100% fixed ; */
}

.winner-page h1 {
  width: 100vw;
  text-align: center;
}

.winner-container {
  /* display: flex; */
  width: 100vw;
  align-content: center;
}

.winner-card
{
    display: inline-block;
    
    /* flex-wrap:wrap;
    justify-content: center;
    align-items: center; */
    align-items:center;
    /* justify-content: space-evenly; */
    flex-grow: 1;
    background: #008F7A;
    border: 1px green solid;
    border-radius: 60px;
    padding: 1rem;
    margin: 15px;
    text-align: center;
    box-shadow: 10px 10px blue;
    width: 40vw;
    text-align: center;
    

}
</style>