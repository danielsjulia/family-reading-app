<template>
<div>
  <member-card class="winner-page" v-for= "member in thisPrizeWinners" 
  v-bind:key= "member.id" />
    i am winners page 
    </div>
</template>

<script>
import MemberCard from '../components/MemberCard.vue'
export default {
  components: { MemberCard },
    name : "PrizeWinners",
    props: {
      thisPrizeWinners: []
    },
    component: {
      MemberCard
    }

}
</script>

<style>

.winner-page {
  height: 100vh;
  width: 100vw;
  background-image: url("../../images/confetti.gif") ;
}
</style>