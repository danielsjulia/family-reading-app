<template>
  <div>
      <h3></h3>
    <form  class="add-prize" @submit.prevent="addPrize()">
        <input class="boxes" type="text" placeholder= "Name" v-model="prize.name" />
        <input class="boxes" type="text" placeholder="Description" v-model="prize.description" />
        <input class="boxes" type="date" placeholder="Start Date" v-model="prize.startDate" />
        <input class="boxes" type="date" placeholder="End Date" v-model="prize.endDate" />
        <input class="boxes" type="number" placeholder="Milestone in minutes" v-model="prize.milestone" />
        <input class="boxes" type="number" placeholder="Number Of Winners" v-model="prize.numberOfWinners" />
        <div class="button-container">
            <button type="submit">Add Prize</button>
            <button type="reset" @click.prevent="clearPrize()">Cancel</button>
        </div> 
         <!-- type="cancel" value="cancel" type="submit" -->

    </form>
  </div>
</template>

<script>
import PrizeService from "../services/PrizeService"

export default {
    name: "AddPrize",
    data() {
        return{
            prize :{
                name:"",
                description: "",
                startDate: "",
                endDate: "",
                milestone: "",
                numberOfWinners: ""
            }
        }
        
    },
    methods: {
        addPrize() {
            PrizeService.addPrize(this.prize)
            .then(response =>
            {
                if(response.status == 200){
                    this.$store.commit("Set_prize", response.data)
                    window.alert("Prize added")
                    this.prize ={
                        name:"",
                        description: "",
                        startDate: "",
                        endDate: "",
                        milestone: "",
                        numberOfWinners: ""
            }
                }
                
            })
        },
        clearPrize() {
            this.prize = {};
        }
    }  
}
</script>

<style>

</style>