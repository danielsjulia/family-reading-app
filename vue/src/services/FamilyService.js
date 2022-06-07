import axios from 'axios';

export default {
createFamily(family) {
    return axios.post('/add-family', family)
  },

  getFamily(id) {
    return axios.get(`/${id}`)
  },

  getFamilyFromUser(userId){
    return axios.get(`/family/${userId}`)
  }

  


  

}