<template>
  <div class= 'member'>
      <div v-for= "member in members" v-bind:key = "member.id">{{member.username}} -- {{member.isParent}}</div>
  </div>
</template>

<script>
import MemberService from '../services/MemberService'
export default {
    name:"members",
    data(){
        return{
            members:[]
        }
    },
    created(){
        const promise = MemberService.getMembers()
        promise.then(response => {
            this.members = response.data
        })
    }


}
</script>

<style>

</style>