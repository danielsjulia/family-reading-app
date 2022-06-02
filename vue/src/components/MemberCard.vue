<template>
  <div class= "member-card">
    <img src="https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.vectorstock.com%2Froyalty-free-vector%2Fhappy-kid-cartoon-vector-20988209&psig=AOvVaw3GvrpWYN6to6-S7NOvfvvh&ust=1654287540284000&source=images&cd=vfe&ved=0CAwQjRxqFwoTCOid8bvLj_gCFQAAAAAdAAAAABAD" />
    
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