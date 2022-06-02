<template>
  <div class= 'member'>
      <member-card v-for="member in members" 
      v-bind:key="member.id"
       v-bind:member = "member" />
          
    </div>
</template>

<script>
import MemberService from '../services/MemberService'
import MemberCard from './MemberCard.vue'

export default {
    name:"members",
    data(){
        return{
            members:[]
        }
    },
    components: { 
      MemberCard
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