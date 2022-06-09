<template>
  <div id="div">
    <h2>Add a new prize</h2>
    <form  class="add-prize" @submit.prevent="addPrize()">
        <div class="input-container">
            <label for="name">Name your prize</label>
            <input id="name" class="boxes" type="text" placeholder= "Name" v-model="prize.name" />  
        </div>
        <div class="input-container">
            <label for="description">Description</label>
            <input id="description" class="boxes" type="text" placeholder="Description" v-model="prize.description" />
        </div>
        <div class="input-container">
            <label for="startDate">Prize available</label>
            <input id="startDate" class="boxes" type="date" placeholder="Start Date" v-model="prize.startDate" />
        </div>
        <div class="input-container">
            <label for="endDate">Prize deactivates</label>
            <input class="endDate" type="date" placeholder="End Date" v-model="prize.endDate" />
        </div>
        <div class="input-container">
            <label for="milestone">Minutes required</label>
            <input class="milestone" type="number" placeholder="Milestone in minutes" v-model="prize.milestone" />
        </div>
        <div class="input-container">
            <label for="maxWinners">Max number of winners</label>
            <input class="maxWinners" type="number" placeholder="Number Of Winners" v-model="prize.numberOfWinners" />
        </div>
        <br>
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
                prizeId:"",
                name:"",
                description: "",
                startDate: Date,
                endDate: Date,
                milestone: "",
                numberOfWinners: "",
                isActive: ""
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
                        numberOfWinners: "",
                        isActive: ""
            }
            
                }
                this.$router.push('/');
                
            })
        },
        clearPrize() {
            this.prize = {};
        }
    }  
}
</script>

<style>
@import url('https://fonts.googleapis.com/css2?family=Dosis:wght@800&display=swap');

#div h2 {
    text-align: center;
    text-shadow: 2px 2px #45547A;
    color: #FFE7D5;
}

#div {
    background-color: #EC5C67;;
    padding: 10px;
    border: 3px solid #45547A;
    border-radius: 10px;
    box-shadow: 5px 5px #B1EEEE;
    font-family: 'Dosis', sans-serif;
    margin-top: 50px;
    margin-bottom: 50px;
    margin-left: 40px;
    margin-right: 40px;
}

.add-prize {
    display:flex;
    align-items: flex-start;
    justify-content: space-evenly;
}

.input-container input, label {
    display: block;
}

.input-container {
    float:left;
    width: 100vw;
    text-align: center;
}

.input-container input {
    height: 40px;
    width: 80%;
    margin: 10px;
    border-radius: 10px;
    box-shadow: 2px 2px #B1EEEE;
}

.button-container {
    display: block;
    justify-content: flex-end;
    margin: auto;
    align-items: flex-end;
}

.button-container button {
    height: 40px;
}

</style>