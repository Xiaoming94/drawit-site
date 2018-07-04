<template>
  <div>
    <h1>Add a Game</h1>
    <label>Name: </label>
    <input type="text" v-model="gameName">
    <label>Description: </label>
    <input type="text" v-model="gameDescription">

    <button class="button" @click="submit"> Submit </button>
  </div>
</template>
<script>
export default{
  name: 'AddGame',
  data () {
    return {
      gameName: [],
      gameDescription: [],
      response: []
    }
  },
  methods: {
    submit () {
      var xhr = new XMLHttpRequest()
      var url = 'http://localhost:9000/json/games/create'
      xhr.open('POST', url, true)
      xhr.setRequestHeader('Content-Type', 'application/json')
      var data = JSON.stringify({'name': this.gameName, 'description': this.gameDescription})
      xhr.send(data)
    }
  }
}
</script>
