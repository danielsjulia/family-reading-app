import Vue from 'vue'
import Vuex from 'vuex'
import axios from 'axios'
// import MemberService from '../services/MemberService.js'

Vue.use(Vuex)

/*
 * The authorization header is set for axios when you login but what happens when you come back or
 * the page is refreshed. When that happens you need to check for the token in local storage and if it
 * exists you should set the header so that it will be attached to each request
 */
const currentToken = localStorage.getItem('token')
const currentUser = JSON.parse(localStorage.getItem('user'));

if(currentToken != null) {
  axios.defaults.headers.common['Authorization'] = `Bearer ${currentToken}`;
}

export default new Vuex.Store({
  state: {
    token: currentToken || '',
    user: currentUser || {},
    isParent: false , 
    //check this later - might need to derive this somewhere upon log-in --MemberService.isParent().then((response) => { return this.state.isParent=response.data})
    family: {
      familyId: "",
      familyName: "",
    },
    allBooks: [],
    allReadingLogs: [],
    dataHasChanged: false,
    currentMember: {
      userId: "",
      username: "",
      familyId: "",
      parent: false
    },
    familyMembers : []
  },
  mutations: {
    SET_FAMILY_MEMBERS(state, familyMembers)
    {
      state.familyMembers = familyMembers
    },
    SET_READING_LOGS(state, readingLogs)
    {
      state.allReadingLogs = readingLogs
    },
    SET_FAMILY(state, family) {
      state.family = family;
    },
    SET_CURRENT_MEMBER(state, member) {
      state.currentMember = member;
    },
    // SET_USER_BOOKS(state, books) {
    //   state.userBooks = books;
    // },
    SET_ALL_BOOKS(state, books) {
      state.allBooks = books;
    },
    SET_IS_PARENT(state, isParent) {
      state.isParent = isParent;
    },
    SET_AUTH_TOKEN(state, token) {
      state.token = token;
      localStorage.setItem('token', token);
      axios.defaults.headers.common['Authorization'] = `Bearer ${token}`
    },
    SET_USER(state, user) {
      state.user = user;
      localStorage.setItem('user',JSON.stringify(user));
    },
    LOGOUT(state) {
      localStorage.removeItem('token');
      localStorage.removeItem('user');
      state.token = '';
      state.user = {};
      axios.defaults.headers.common = {};
    }
  }
})
