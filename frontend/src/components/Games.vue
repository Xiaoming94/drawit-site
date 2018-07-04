<template>
  <div class="games">
    <h1> Games </h1>
    <ul>
        <li v-for="game in games" :key="game.id">
            <h2>{{ game.name }}</h2>
            <p>
              {{ game.description }}
            </p>
        </li>
        <p>
          Loop exited without problemm
        </p>
    </ul>
  </div>
</template>$
<script>
export default {
  name: 'Games',
  data () {
    return {
      games: []
    }
  },

  created () {
    fetch('http://localhost:9000/json/games')
      .then(response => {
        return response.json()
      })
      .then(json => { this.games = json })
  }
}
</script>
