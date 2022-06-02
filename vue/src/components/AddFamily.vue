<template>

  <div>
      <h1>Add Family </h1>
      <!-- add v-if to show only if no family in store, else redirect to familyPage if have family -->
      <form @submit.prevent="addFamily">
      <input type="text" placeholder="Family name" v-model ="family.familyName" />
        <input type="submit" value="Submit" />
        </form>
        <!-- <add-member /> -->
  </div>
</template>

<script>
import familyService from '@/services/FamilyService'
// import addMember from '@/components/AddMember'

export default {
    name : "add-family",
    component:{
        // addMember
    },
    data(){
        return {
            family:{
                familyName:""
            }
        }
    },
    methods:{
        addFamily(){
            familyService.createFamily(this.family)
            .then(response =>{
                if(response.status === 200) {
                    this.$router.push(`/MyFamily`)
                    this.$store.commit("SET_FAMILY", response.data)
                }
            })
        }
    }

}
</script>

<style>

</style>