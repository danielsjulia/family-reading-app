<template>
  <div 
    class= "member-card" 
    v-bind:class="{parent : thisMember.parent,  child: !thisMember.parent} "
  >
    <img class="profile-img" src="../../images/girl-avatar-over10.png" />
      <h1 id="username">{{thisMember.username}}</h1>
      <!-- <h2 id= "parent">{{member.parent ? "Parent" : "Child" }}</h2> -->
      <h3 id="userId">UserId: {{thisMember.userId}}</h3>
      <!-- <h3 id= "familyId">family_id: {{member.familyId }}</h3> -->
  </div>
</template>

<script>
export default {
    name: 'member-card',
    props: {
      member: Object
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
/* .member-card 
  /* display: grid;
  grid-template-columns: 1fr 1fr;
  grid-template-areas: 
  "parent parent"
  "child child"
  "child child"
  ;
  grid-area: member-card; */

.parent {
  /* display: grid; */
  grid-area: parent;
  background : #0089BA !important;
  /* grid-area: parent; */
}
.child {
  /* grid-area: child; */
  background:#F3C5FF !important;
}

</style>