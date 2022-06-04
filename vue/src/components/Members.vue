<template>
  <div class= 'member'>
    <router-link 
        :to = "{ name : 'profile', params:{username: member.username}}" 
        v-for="member in members" 
        v-bind:key="member.id"
    >
      <member-card v-bind:member = "member" />
    </router-link>
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

.member {
    /* background-color: #FFC75F; */
    display: inline-flex;
    flex-wrap: wrap;
    justify-content:space-between;
    align-content: center;
    border: 1px solid black;
}
.member .member-card
{
    background: #008F7A;
    border: 1px green solid;
    border-radius: 60px;
    padding: 1rem;
    margin: 15px;
    text-align: center;
    box-shadow: 10px 10px #EC5C67;

}


</style>