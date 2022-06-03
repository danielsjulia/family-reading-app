<template>
  <div>
      <form>
          <input type="url" placeholder="picture Link" v-model= 'pictureUrl' >
      </form>
  </div>
</template>

<script>
export default {
    name : 'update-picture',
    pictureUrl : URL,

}
</script>

<style>

</style>