<template>
  <div id="login" class="text-center">
    <form class="form-signin" @submit.prevent="login"  > <!-- @submit="setIsParent" -->
      <!-- <h1 class="h3 mb-3 font-weight-normal">Sign In</h1> -->
      <div class="signin">
        <div id= "head">
          <h3 id="head1"> Welcome!</h3>
          <h4 id="head2">Sign in to ReadingFun!</h4>
        </div>
      <div
        class="alert alert-danger"
        role="alert"
        v-if="invalidCredentials"
      >Invalid username and password!</div>
      <div
        class="alert alert-success"
        role="alert"
        v-if="this.$route.query.registration"
      >Thank you for registering, please sign in.</div>
      <!-- <label for="username" class="sr-only">Username</label> -->
      <input
        type="text"
        id="username"
        class="form-control"
        placeholder="Username"
        v-model="user.username"
        required
        autofocus
      />
      <!-- <label for="password" class="sr-only">Password</label> -->
      <input
        type="password"
        id="password"
        class="form-control"
        placeholder="Password"
        v-model="user.password"
        required
      />
  
      <button id="submit" type="submit">Sign in</button>
      <div class ="new_account">
      <router-link :to="{ name: 'register' }">Need an account?</router-link>
      </div>
      </div>
    </form>
  </div>
</template>

<script>
import authService from "../services/AuthService";
import MemberService from '../services/MemberService';

export default {
  name: "login",
  components: {},
  data() {
    return {
      user: {
        username: "",
        password: ""
      },
      invalidCredentials: false,
      isParent : true
    };
  },
  // computed:{

  methods: {
    login() {
      authService
        .login(this.user)
        .then(response => {
          if (response.status == 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);

            // const promise = MemberService.isParent()
            // promise.then(response => this.isParent = response.data.parent)
            MemberService.isParent().then(
              response => {
                console.log(response.data);
                if (response.data.parent) {
                  this.$router.push("/myFamily");
                } else {
                  this.$router.push("/myProfile");
                }
              }
            )

            console.log(response.data);

            
          }
        })
        .catch(error => {
          const response = error.response;

          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
    },
        // setIsParent() {
        //     const promise = MemberService.isParent()
        //     promise.then(response => this.isParent = response.data.parent)
        //     this.$store.commit('SET_IS_PARENT', this.isParent )
        //     console.log(this.isParent)
        //     if(this.$store.state.isParent === true)
        //     {
        //       this.$router.push("/");
        //     }
        //     else this.$router.push("/myProfile")
  // },
  }
};
</script>

<style>


.form-signin{
  text-align: center;
  font-weight: 800;
  font-size: 20px;
  background-color: rgb(238, 237, 236);
}

.signin{
background-image: url("../../images/back-school.webp") ;
background-size: cover;
height: 100vh;
width: 100%;            
display: flex;
flex-direction: column;
justify-content: center;
border-radius: 20px;
}
#head{
  text-align: center;
display: flex;
flex-direction: column;
 flex-basis: 15%;
}
#head1,#head2,#head3{
 align-self: center;
/* padding-left: 15rem;
margin: 0px ; */
}

.form-signin,.form-register{
  display:block;
  }
#username,#password,#confirmPassword
{
  width: 50%;
  max-width: 400px;
  align-self: center;
  border-radius: 30px;
}

#submit{
    width: 50%;
    max-width: 400px;
  align-self: center;
    border-radius: 20px;
    background-color:#ffe135;
}


.new_account{
  align-self: center;
  margin-top: 10px;
}

</style>
