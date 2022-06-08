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
  background-image: url("../../images/confetti.gif") repeat-y 100% 100% fixed ;
}
</style>