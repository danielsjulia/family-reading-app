<template>
  <div class= "member-card">
      <h1 class= "member-name">{{member.username}}</h1>
      <h2 class= "isParent">{{member.isParent ? "parent" : "child" }}</h2>
  </div>
</template>

<script>
export default {
    name: 'member-card',
    props: {
      member: Object
    }
    
}
</script>

<style>

</style>