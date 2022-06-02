<template>
  <div>
    <button @click="showForm()">Add Member</button>

    <form v-show="addMember == true" @submit="addMemberToFamily()">
      <input type="text" placeholder="userName" v-model="member.user_name" />
      <input type="password" placeholder="password" v-model="member.password" />
       <input type="password" placeholder="confirmPassword" v-model="member.confirmPassword" />
      <input type="checkbox" placeholder="isParent" v-model="member.isParent" />
      <input type="submit" value="submit" />
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
          user_name: "",
          password: "",
          confirmPassword: "",
          isParent: false,
          familyId: "",
          familyName: "", //fix this for when we get the familyName to the page
          role: "user"
        },
        addMember : false
      }
    },
    props: [
      'familyName',
    ],
    created() {
      this.member.familyName = this.$store.state.family.familyName;
      this.member.familyId = this.$store.state.family.familyId;
    },
    methods: {
      showForm() {
        this.addMember =true

      },
      addMemberToFamily() {
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