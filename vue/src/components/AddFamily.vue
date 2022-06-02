<template>

  <div id="formContainer" v-if="!familyName">
    <h1>Name Your Family!</h1>
      <!-- add v-if to show only if no family in store, else redirect to familyPage if have family -->
    <form id="familyForm" @submit.prevent="addFamily">
        <label for="familyName"></label>
        <input id="input" type="text" placeholder="Family name" v-model ="family.familyName" />
        <input id="button" type="submit" value="Create" />
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
            },
            showForm: ""
        }
    },
    // created () {
    //     setTimeout(() => {}, 100);

    //     if (this.$store.state.family.familyName == "") {
                
    //             this.showForm = true;
    //         }

    // },
    computed: {
        familyName() {
            return this.$store.state.family.familyName
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
        },
        toggleForm() {
            return this.showForm
        }
    }

}
</script>

<style>
@import url('https://fonts.googleapis.com/css2?family=Dosis:wght@800&display=swap');
@import url('https://fonts.googleapis.com/css2?family=Dosis:wght@500&display=swap');

#formContainer {
    display: flex;
    flex-direction: column;
    justify-content: space-evenly;
    flex-wrap: wrap;
    margin-top: 4vh; 
    background-color: #00B7A3;
    width: 33%;
    text-align: center;
    padding: 10px;
    border: 5px solid #45547A;
    border-radius: 20px;
    box-shadow: 10px 10px #EC5C67;
    text-shadow: 3px 3px #45547A;
    color: #FFE7D5;
    font-size: larger;
}

#formContainer h1 {
    display: block;
}

#familyForm {
    display: flex;
    justify-content: center;
}

#input {
    border: 3px solid #45547A;
    border-radius: 10px;
    height: 25px;
    font-size: medium;
    margin: 5px;
}

#button {
    font-family: 'Dosis', sans-serif;
    font-size: medium;
    background-color: #45547A;
    border: 3px solid #45547A;
    border-radius: 10px;
    color: white;
    margin: 5px;
}


</style>