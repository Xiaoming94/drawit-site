<template>
  <div id="app">
    <div class="grid-container">
        <img src="./assets/logo.png">
        <router-view/>
    </div>
  </div>
</template>

<script>
export default {
  name: 'App'
}
</script>

<style lang="scss">
    @import "styles/main.scss";
    img {
      width: 20%;
    }
</style>
