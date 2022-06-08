<template>
  <div>
    i am winners page
    <member-card
      class="winner-page"
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
.winner-page {
  height: 100vh;
  width: 100vw;
  background-size: cover;
  background-image: url("../../images/confetti.gif");
}


.member-card
{
    display: block;
    
    /* flex-wrap:wrap;
    justify-content: center;
    align-items: center; */

    flex-grow: 1;
    background: #008F7A;
    border: 1px green solid;
    border-radius: 60px;
    padding: 1rem;
    margin: 15px;
    text-align: center;
    box-shadow: 10px 10px blue;
    width: 100vw;
    

}
</style>