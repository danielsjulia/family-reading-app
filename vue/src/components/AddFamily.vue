<template>

  <div>
      <h1>Add Family </h1>
      <form @submit.prevent="addFamily">
      <input type="text" placeholder="Family name" v-model ="family.familyName" v-bind:familyName = "familyName" />
        <input type="submit" value="Submit" />
        </form>
  </div>
</template>

<script>
import familyService from '@/services/FamilyService'
export default {
    name : "add-family",
    component:{

    },
    data(){
        return{
            family:{
                familyName:""
            }
        }
    },
    methods:{
        addFamily(){
            familyService.createFamily(this.family)
            .then(response =>{
                if(response.status=== 200) {
                    this.$router.push("/MyFamily")
                }
            })
        }
    }

}
</script>

<style>

</style>