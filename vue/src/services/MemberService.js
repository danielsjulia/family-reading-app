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

  getAllMembers(familyId) {
    return axios.get('/myFamily', familyId)
  },

  getUserBooks(id) {
    return axios.get(`/myBooks/${id}`);
  },

  getAllBooks() {
    return axios.get('/books');
  },
  
  addBook(book){
    return axios.post('/add-book',book)
  }

}