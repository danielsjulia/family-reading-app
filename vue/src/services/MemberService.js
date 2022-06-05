import axios from 'axios';

export default {
  isParent() {
    return axios.get('/isParent')
  },

  addMember(member) {
    return axios.post('/myFamily/add-member', member)
  },

  addNewMember(member) {

    return axios.post('/myFamily/add-new-member', member)
  },

  getMembers() {
    return axios.get(`/myFamily/all-member`)
  },

  getUserBooks() {
    return axios.get('/myBooks');
  },

  getAllBooks() {
    return axios.get('/books');
  },
  
  addBook(book){
    return axios.post('/add-book',book)
  }

}