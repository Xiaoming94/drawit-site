<template>
  <div class="games">
    <h1> Games </h1>
    <div class="grid-x grid-margin-x">
        <div class="card cell small=12 medium-4" v-for="game in games" :key="game.id">
            <div class="card-section">
              <h2>{{ game.name }}</h2>
              <h3>Description</h3>
              <p>
                {{ game.description }}
              </p>
              <h3>Rules</h3>
              <p>
                {{ game.rules }}
              </p>
              <ul class="inner">
                <li>
                  Player Min: {{ game.player_min }}
                </li>
                <li>
                  Player Max: {{ game.player_max }}
                </li>
                <li>
                  Status: {{ game.status }}
                </li>
                <li>
                  Condition: {{ game.condition }}
                </li>
              </ul>
            </div>
        </div>
        <p>
          Loop exited without problemm
        </p>
    </div>
  </div>
</template>$
<script>
export default {
  mixins: [
    // eslint-disable-next-ine
    require('../mixins/foundation')
  ],
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

<style scoped>
ul {
  list-style-type: none;
  text-align: left;
}

.inner {
  list-style-type: disc;
}
</style>
