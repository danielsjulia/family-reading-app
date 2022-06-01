<template>
  <div>
    <!-- <add-family /> -->
      <h1>{{familyName}}</h1>
      <button @click="showForm()">Add Member</button>
      
      <form v-show= "addMember == true" @submit="addMemberToFamily()">
        <input type="text" placeholder="user_id" v-model = "member.user_id" >
        <input type="text" placeholder="userName" v-model = "member.user_name" >
        <input type="password" placeholder="password" v-model = "member.password">
        <input type="checkbox" placeholder="isParent" v-model = "member.isParent" >
        <input type="submit" value="submit">
      </form>


      <h2>members</h2>
  </div>
</template>

<script>

import memberService from "../services/MemberService.js"



export default {

  // components: { AddFamily },
    name: "FamilyPage",
    
    data () {
      return {
        member : {
          user_id: "",
          user_name: "",
          password: "",
          isParent: false,
          familyName: this.familyName
        },
        addMember : false
      }
    },
    props: [
      'familyName',
      
    ],
    methods: {
      showForm() {
        this.addMember =true

      },
      addMemberToFamily() {
        memberService.addMember(this.member)
          .then(response => {
            if(response.status == 200) {
              this.$router.push("/MyFamily")
            }
          })

      }
    }

}
</script>

<style>

</style>