<template>
  <div class="container my-5">
    <form class="form-inline" @submit.prevent="search">
      <div class="form-group">
        <input type="text" class="form-control" v-model="lastName" placeholder="Last Name">
      </div>
      <div class="form-group mx-3">
        <input type="number" min="1" class="form-control" v-model="releasedFrom"
               placeholder="Released from">
      </div>
      <div class="form-group">
        <input type="number" min="1" class="form-control" v-model="releasedUntil"
               placeholder="Released until">
      </div>
      <button class="btn btn-outline-success mx-3 my-sm-2" type="submit">Search</button>
    </form>
    <table class="table table-bordered">
      <thead>
      <tr>
        <th scope="col">First Name</th>
        <th scope="col">Last Name</th>
        <th scope="col">Birth Date</th>
        <th scope="col">Film Name</th>
        <th scope="col">Release Date</th>
        <th scope="col">Genre</th>
      </tr>
      </thead>
      <tbody>
      <tr v-for="film in films" v-bind:key="film.text">
        <td>{{ film.directorFirstName }}</td>
        <td>{{ film.directorLastName }}</td>
        <td>{{ film.directorBirthDate }}</td>
        <td>{{ film.filmName }}</td>
        <td>{{ film.filmReleaseDate }}</td>
        <td>{{ film.filmGenre }}</td>
      </tr>
      </tbody>
    </table>
  </div>
</template>

<script>

import {AXIOS} from "@/backend-api";

export default {
  name: "ListFilms",
  data() {
    return {
      lastName: '',
      releasedFrom: '',
      releasedUntil: '',
      films: []
    }
  },
  methods: {
    search: function () {
      this.$router.push({
        name: 'ListFilms',
        query: {
          dir: this.lastName ? this.lastName : undefined,
          from: this.releasedFrom ? this.releasedFrom : undefined,
          until: this.releasedUntil ? this.releasedUntil : undefined
        }
      })
      this.loadFilmContent()
    },
    async loadFilmContent() {
      try {
        const {data} = await AXIOS.get('films', {
          params: {
            dir: this.$route.query.dir,
            from: this.$route.query.from,
            until: this.$route.query.until
          }
        })
        this.films = data;
      } catch (error) {
        console.log('ERROR: ' + error.response.data)
      }
    }
  },
  mounted() {
    this.loadFilmContent();
  }
}
</script>
<style scoped>

th, td {
  text-align: center;
}

.form-inline {
  align-items: center;
  justify-content: center;
  margin-bottom: 10px;
}

input::-webkit-outer-spin-button,
input::-webkit-inner-spin-button {
  /* display: none; <- Crashes Chrome on hover */
  -webkit-appearance: none;
  margin: 0; /* <-- Apparently some margin are still there even though it's hidden */
}

input[type=number] {
  -moz-appearance: textfield; /* Firefox */
}

</style>