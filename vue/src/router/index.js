import Vue from 'vue'
import Router from 'vue-router'
import Home from '../views/Home.vue'
import Login from '../views/Login.vue'
import Logout from '../views/Logout.vue'
import Register from '../views/Register.vue'
import store from '../store/index'
import AddABook from '../views/AddABook.vue'
import FamilyPage from '../views/FamilyPage.vue'
import ProfilePage from '../views/ProfilePage.vue'
import AllBooks from '../views/AllBooks.vue'
import BookPage from '../views/BookPage.vue'
import AssignBook from '../components/AssignBook.vue'
import PrizeWinners from "../views/PrizeWinners.vue"


Vue.use(Router)

/**
 * The Vue Router is used to "direct" the browser to render a specific view component
 * inside of App.vue depending on the URL.
 *
 * It also is used to detect whether or not a route requires the user to have first authenticated.
 * If the user has not yet authenticated (and needs to) they are redirected to /login
 * If they have (or don't need to) they're allowed to go about their way.
 */

const router = new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: [
    {
      path: '/',
      name: 'home',
      component: Home,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: "/login",
      name: "login",
      component: Login,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/logout",
      name: "logout",
      component: Logout,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/register",
      name: "register",
      component: Register,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/addABook",
      name: "add-a-book",
      component: AddABook,
      meta : {
        requiresAuth : false
      }
    },
    {
        path: "/MyFamily",
        name: "family-page",
        component: FamilyPage,
        meta: {
          requiresAuth: false
        }

    },
    {
      path: "/myProfile",
      name: "profile",
      component: ProfilePage,
      meta: {
        requiresAuth: false
      },
      props: true

  },
  {
    path: "/profilePicture/",
    name: "profilePicture",
    component: ProfilePage,
    meta: {
      requiresAuth: false
    },
  },
  {
    path: "/allBooks",
    name: "all-books",
    component: AllBooks,
    meta: {
      requiresAuth: false
    }
  },
  {
    path: "/bookDetail",
    name: "book-page",
    component: BookPage,
    meta: {
      requiresAuth: false
    },
    props: true
  },
  {
    path: "/userBook",
    name: "AssignBook",
    component: AssignBook,
    meta: {
      requiresAuth: true
    }
  },
  {
    path : "/winnerPage",
    name: "PrizeWinners",
    component: PrizeWinners,
    meta: {
      requiresAuth: true
    },
    props: true
  }
  ]
})

router.beforeEach((to, from, next) => {
  // Determine if the route requires Authentication
  const requiresAuth = to.matched.some(x => x.meta.requiresAuth);

  // If it does and they are not logged in, send the user to "/login"
  if (requiresAuth && store.state.token === '') {
    next("/login");
  } else {
    // Else let them go to their next destination
    next();
  }
});

export default router;
