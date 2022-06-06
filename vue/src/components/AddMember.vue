<template>
  <div class="addMemberForm" >
    <button class= "button" type="button" @click="showForm()">Add Family Member</button>

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
      <div class="buttons">
        <input class="button"  type="submit" value="submit" />
        <input class="button" @click="cancel()" type="button" value="cancel" />
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
 
   background-image: url("../../images/header-image.jpg");
   background-repeat: no-repeat;
   background-position: center;
   background-size: stretch;
  justify-content: center;
  align-content: center;
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

.button {
  background-color: #F3C5FF;
  border-radius: 50%;
  margin: 5px;
  padding: 15px;
  font-size: 16px;
  font-weight: 800;
}

.button:hover {
  box-shadow: 1px 1px 5px 3px #c699d1;
}

.submitButton {
  background-color: #F3C5FF;
  margin: 5px;
  padding: 5px;
  font-size: 16px;
  font-weight: 800;
}

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