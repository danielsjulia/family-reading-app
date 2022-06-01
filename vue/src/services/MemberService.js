import axios from 'axios';

export default {
addMember(member) {
  //do we make the name unique later to use the name? (we also have the optional leaderboard to consider)
    return axios.post('/${familyName}/add-member', member)
  },

//   getMembers(familyName) {
//     return axios.get(`/${familyName}/all`)
//   }
  

}