<template>
  <div class= 'member'>
    <router-link 
        :to = "{ name : 'profile', params:{member}}" 
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
    width: 100vw;
    display: flex;
    flex-direction: row;
    flex-wrap: wrap;
    justify-content: space-evenly;
    align-content: center;
    border-top: 10px solid whitesmoke;
    
}
.member .member-card
{
    display: block;
    
    /* flex-wrap:wrap;
    justify-content: center;
    align-items: center; */

    flex-grow: 1;
    background: #008F7A;
    border: 1px green solid;
    border-radius: 60px;
    padding: 1rem;
    margin: 15px;
    text-align: center;
    box-shadow: 10px 10px blue;
    

}
img {
    height: 200px;
    width: 200px;
    /* align-content: center; */
}
.familyPage {
    height: 100vh;
}

</style>