import axios from 'axios';

export default {
addMember(member) {
    return axios.post('/myFamily/add-member', member)
  },

  addNewMember(member) {

    return axios.post('/myFamily/add-new-member', member)
  },

  getMembers() {
    return axios.get(`/myFamily/all-member`)
  }
  

}