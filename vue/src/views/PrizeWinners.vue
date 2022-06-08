<template>
  <div class="winner-page">
    <h1>Winners for {{prize.name}}!</h1>
    <member-card
      class="winner-card"
      v-bind:member="member"
      v-for="member in winners"
      v-bind:key="member.id"
    />
  </div>
</template>

<script>
import MemberCard from "../components/MemberCard.vue";

export default {
  components: { MemberCard },
  name: "PrizeWinners",
  props: {
    prize: Object,
    winners: Array,
  },
  component: {
    MemberCard,
  },
  data() {
    return {
      //winners: []
    };
  },
};
</script>

<style>
@import url('https://fonts.googleapis.com/css2?family=Dosis:wght@800&display=swap');


.winner-page {
  font-family: 'Dosis', sans-serif;
  width: 100%;
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
  /* repeat-y 100% 100% fixed ; */
}

.winner-card
{
    display: inline-block;
    
    /* flex-wrap:wrap;
    justify-content: center;
    align-items: center; */
    align-items:center;
    flex-grow: 1;
    background: #008F7A;
    border: 1px green solid;
    border-radius: 60px;
    padding: 1rem;
    margin: 15px;
    text-align: center;
    box-shadow: 10px 10px blue;
    width: 45vw;
    

}
</style>