<template>
  <div class="prize-card">
    <router-link :to="{name:'PrizeWinners', params:{prize, winners}}" >  
        <h1 class="prize-name">{{prize.name}}</h1>
        <h4 class="description">{{prize.description}}</h4>
        <table>
            <tr>
                <td><h2>GOAL:</h2></td>
                <td><p>Read {{prize.milestone}} minutes </p></td>
            </tr>
            <tr>
                <td> <h2>WHEN:</h2> </td>
                <td> <p>Between {{prize.startDate}} and {{prize.endDate}}</p> </td>
            </tr>
            <tr>
                <td> <h2>WINNERS:</h2></td>
                <td><p>Only {{prize.numberOfWinners}} member{{prize.numberOfWinners === 1 ? '' : 's'}} can win the prize</p> </td>
            </tr>
        </table>
        <!-- <h3 class="end-date">from {{prize.startDate}} to {{prize.endDate}}</h3> -->
        <!-- <h4 class="num-of-winners">Only {{prize.numberOfWinners}} can win the prize</h4> -->
    </router-link>

        <div id="participants-container">
            <display-participants id="participants" v-bind:prize= "prize" />
        </div>
        
        <div v-if="this.$store.state.isParent == true">
        <button v-if="prize.isActive === false" @click.prevent="deletePrize(prize.prizeId)">Delete</button>
        <button @click.prevent="showUpdateForm=true">Edit</button>
        </div>
        <form v-if="showUpdateForm==true" @submit="updatePrize()" >
            <input class="boxes" type="text" placeholder= "Name" v-model="updatedPrize.name" />
            <input class="boxes" type="text" placeholder="Description" v-model="updatedPrize.description" />
            <input class="boxes" type="date" placeholder="Start Date" v-model="updatedPrize.startDate" />
            <input class="boxes" type="date" placeholder="End Date" v-model="updatedPrize.endDate" />
            <input class="boxes" type="number" placeholder="Milestone in minutes" v-model="updatedPrize.milestone" />
            <input class="boxes" type="number" placeholder="Number Of Winners" v-model="updatedPrize.numberOfWinners" />
            <br>
        <div class="button-container">
            <button type="submit">Edit Prize</button>
            <button type="reset" @click.prevent="clearPrize()">Cancel</button>
        </div> 
        </form>
  </div>
</template>

<script>
import PrizeService from "../services/PrizeService"
import DisplayParticipants from './DisplayParticipants.vue'
export default {
      components: { DisplayParticipants },
    name: "PrizeCard",
    props: {
        prize: Object,
        winners:[]
    },
    data() {
        return {
            thisPrizeWinners : this.winners,
            thisPrize: this.prize,
            showUpdateForm: false,
            updatedPrize: {
                prizeId: this.prize.prizeId,
                name:"",
                description: "",
                startDate: Date,
                endDate: Date,
                milestone: "",
                numberOfWinners: ""
            }
        }
    },
    methods: {
        deletePrize(id) {
            PrizeService.deletePrize(id).then(response => {
                if (response.status == 200) {
                    this.$router.push('/');
                }
            })
        },
        updatePrize() {
            PrizeService.updatePrize(this.updatedPrize, this.updatedPrize.prizeId).then(response => {
                if(response.status == 200) {
                    this.$router.push('/');
                }
            }) 
        },
        clearPrize() {
            this.showUpdateForm = false;
            this.updatedPrize = {};
        }
    }

}
</script>

<style>
@import url('https://fonts.googleapis.com/css2?family=Dosis:wght@800&display=swap');


.prize-card{ 
    /* text-decoration: none; */
    width: 100%;
    height: 100%;
    /* display: inline-flex;
    flex-direction: row;
    flex-wrap: wrap;
    justify-content: space-evenly;
    align-content: center; */
    border-top: 10px solid whitesmoke;
    font-family: 'Dosis', sans-serif;
    /* text-decoration: none; */
}

.prize-card a {
    text-decoration: none;
}

.prize-name {
    text-transform: uppercase;
}

.prize-card table {
    text-align: left;
}

.prize-card table tr td p {
    padding-left: 10px;
}

#participants {
    width: 80%;
}

</style>