<template>
  <div>
    <button @click="showForm()">Add Member</button>

    <form v-show="addMember == true" @submit="addMemberToFamily()">
      <label for="userName">Username: </label>
      <input type="text" placeholder="userName" v-model="member.username" />
      <label for="password">Password: </label>
      <input type="password" placeholder="password" v-model="member.password" />
      <label for="confirmPassword">Confirm Password: </label>
       <input type="password" placeholder="confirmPassword" v-model="member.confirmPassword" />
      <!-- <input type="checkbox" placeholder="isParent" v-model="member.isParent" /> -->
      <label for="isParent">Is this a parent account?</label>
      <input type="checkbox" placeholder="isParent" :checked="member.isParent"  @change="checkParent()"/>
       <input type="submit" value="submit" />
       <input @click="cancel()" class="button2" type="button" value="cancel" />
    </form>
  </div>
</template>

<script>
import memberService from '../services/MemberService';

export default {

    name: "add-member",
      data () {
      return {
        member : {
          username: "",
          password: "",
          confirmPassword: "",
          isParent: false,
          familyId: "",
          familyName: "", //fix this for when we get the familyName to the page
          role: "user"
        },
        // isParent: false,
        addMember : false
      }
    },
    // props: [
    //   'familyName',
    // ],
    created() {
      this.member.familyName = this.$store.state.family.familyName;
      this.member.familyId = this.$store.state.family.familyId;
    },
    methods: {
      showForm() {
        this.addMember =true
      },
      checkParent(){
          this.member.isParent = true
      },
          cancel() {
      this.member = {};
      this.addMember = false;
    },
      addMemberToFamily() {
        this.member.familyId = this.$store.state.family.familyId;
        this.member.familyName = this.$store.state.family.familyName;
        // this.member.isParent = this.isParent;
        memberService.addNewMember(this.member)
          .then(response => {
            if(response.status == 200) {
              this.$router.push("/MyFamily")
            }
          })

      }
    }
};
</script>

<style>
</style>