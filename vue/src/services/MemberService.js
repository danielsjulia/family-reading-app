import axios from 'axios';

export default {
addMember(member) {

    return axios.post('/myFamily/add-member', member)
  },

//   getMembers(familyName) {
//     return axios.get(`/${familyName}/all`)
//   }
  

}