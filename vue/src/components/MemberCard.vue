<template>

  <div 
    class= "member-card" 
    v-bind:class="{parent : thisMember.parent,  child: !thisMember.parent} "
  >
    <h1 id="username">{{thisMember.username}}</h1>
    <img class="profile-img" src="../../images/girl-avatar-over10.png" />
      <div id="name-container">
        
        <h2 id= "parent">{{member.parent ? "Parent" : "Child" }}</h2>
        <h3 id="userId">UserId: {{thisMember.userId}}</h3>
      <!-- <h3 id= "familyId">family_id: {{member.familyId }}</h3> -->
      </div>
      
  </div>

</template>

<script>

export default {
    name: 'member-card',
    props: {
      member: Object,
      winners: []
    },
    data() {
      return {
        thisMember : this.member
      }
    }
    
}

</script>


<style>

.profile-img {
    border: 1px solid black;
    border-radius: 100px;
}
.parent {
  background:palegreen !important;
}
.child {
  background:peru !important;
}
h1 {
  text-align: center;
  display:block;
  align-self: center;
  margin: 0px 20% 10px 20% !important;
}

</style>