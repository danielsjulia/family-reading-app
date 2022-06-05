import axios from 'axios';

export default {
addBookToUser(userBook) {
    return axios.post('/userBook', userBook)
  },


}