<template>
  <div class="addMemberForm" >
    <button class= "memberButton" type="button" @click="showForm()">Add Family Member</button>

    <form
      class="grid-box"
      v-show="addMember == true"
      @submit="addMemberToFamily()"
    >
      <div class="addName">
        <label for="userName">Username: </label>
        <input type="text" placeholder="userName" v-model="member.username" />
      </div>
      <div class="password">
        <label for="password">Password: </label>
        <input
          type="password"
          placeholder="password"
          v-model="member.password"
        />
      </div>
      <div class="confirm">
        <label for="confirmPassword">Confirm Password: </label>
        <input
          type="password"
          placeholder="confirmPassword"
          v-model="member.confirmPassword"
        />
      </div>
      <div class="isParent">
        <label for="isParent">Is this a parent account?</label>
        <input
          type="checkbox"
          placeholder="isParent"
          :checked="member.isParent"
          @change="checkParent()"
        />
      </div>
      <!-- <input type="checkbox" placeholder="isParent" v-model="member.isParent" /> -->
      <div >
        <input class="memberButton"  type="submit" value="submit" />
        <input class="memberButton" @click="cancel()" type="button" value="cancel" />
      </div>
    </form>
  </div>
</template>

<script>
import memberService from "../services/MemberService";

export default {
  name: "add-member",
  data() {
    return {
      member: {
        username: "",
        password: "",
        confirmPassword: "",
        isParent: false,
        familyId: "",
        familyName: "", //fix this for when we get the familyName to the page
        role: "user",
      },
      // isParent: false,
      addMember: false,
    };
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
      this.addMember = true;
    },
    checkParent() {
      this.member.isParent = true;
    },
    cancel() {
      this.member = {};
      this.addMember = false;
    },
    addMemberToFamily() {
      this.member.familyId = this.$store.state.family.familyId;
      this.member.familyName = this.$store.state.family.familyName;
      // this.member.isParent = this.isParent;
      memberService.addNewMember(this.member).then((response) => {
        if (response.status == 200) {
          this.$router.push("/MyFamily");
        }
      });
    },
  },
};
</script>

<style>

.addMemberForm {
 
   /* background-image: url("../../images/header-image.jpg"); */
   background-repeat: no-repeat;
   background-position: center;
   background-size: stretch;
  justify-content: center;
  align-content: center;
  background-color: #B1EEEE;
  /* width: 100%; */
}

.grid-box {
  display: grid;
  grid-template-columns: 1fr;
  grid-template-areas:
    "name"
    "password"
    "confirm"
    "parent"
    "buttons"
    ;
  gap: 10px;
  margin: 10px;
  font-size: 18px;
  font-weight: 600;

}

.memberButton {
  background-color:#FF8F65;
  border-radius: 35%;
  margin: 5px;
  padding: 15px;
  font-size: 14px;
  font-weight: 700;
}

.memberButton:hover {
  font-size: 16px;
  border: 2px solid black;
}

/* .submitButton {
  margin: 5px;
  padding: 5px;
  font-size: 16px;
  font-weight: 800;
} */

input[type=text] {
  padding: 5px;
  margin: 5px;
}

input[type=password] {
  padding: 5px;
  margin: 5px;
}

.addName {
  grid-area: name;
}

.password {
  grid-area: password;
}

.confirm {
  grid-area: confirm;
}

.isParent {
  grid-area: parent;
}

.buttons {
  grid-area: buttons;
}
</style>