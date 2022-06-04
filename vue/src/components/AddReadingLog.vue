<template>
  <div>
      <button @click="showForm()">Add ReadingLog</button>

    <form  @submit="addReadingLog()">
        <input type="range" min="0" max="60" step="15" placeholder="MinutesRead"/>
        <select>
        <option value="Paper">Paper</option>
        <option value="Audio">Audio</option>
        <option value="Digital">Digital</option>
        <option value="Reader">Reader</option>
        <option value="Listener">Listener</option>
        <option value="Other">Other</option>
      </select>
       <input type="date" placeholder="date"/>
        <input type="number" placeholder="StartingPage"/>
         <input type="number" placeholder="EndingPage"/>
          <input type="text" placeholder="Notes"/>
          <button>NewReadingLog</button>
          <button>Cancel</button>
     
    </form>
  </div>
</template>

<script>
export default {
    name:"add-reading-lod",
    data(){
        return{
            readingLod:{
                minutes:'',
                format:'',
                date:'',
                starting_page:'',
                end_page:'',
                book_id:'',
                user_id:'',
                notes:''
            }
        }
  
    },
    methods:{
            
        }

}
</script>

<style>

</style>