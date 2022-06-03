<template>
  <div 
    class= "member-card" 
    v-bind:class="{ parent: member.parent}"
  >
    <img class="profile-img" src="../../images/girl-avatar-over10.png" />
    
      <h1 id="username">{{member.username}}</h1>
      <h2 id= "parent">{{member.parent ? "Parent" : "Child" }}</h2>
      <h3 id="userId">UserId: {{member.userId}}</h3>
      <!-- <h3 id= "familyId">family_id: {{member.familyId }}</h3> -->
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

.profile-img {
    border: 1px solid black;
    border-radius: 100px;
}
.member-card {
  text-align: center;
}
.parent {
  background : blue !important;
}
</style>