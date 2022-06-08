<template>
  <div class="winner-page">
    i am winners page</div>
</template>

<script>
export default {
    name : "PrizeWinners",
    props: {
      winners: []
    }

}
</script>

<style>

.winner-page {
  height: 100vh;
  width: 100vw;
  background-image: url("../../images/confetti.jpg") , url("../../images/confetti1.jpg");
}
</style>