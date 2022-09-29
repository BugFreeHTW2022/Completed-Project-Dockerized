<template>
  <Header class="nav">
    <div class="content">
      <router-link to="/"><img src="../assets/logo_transparent.png" alt="logo" class="logo"></router-link>
      <nav>
        <ul class="navigation">
          <li>
            <router-link to="/">Home</router-link>
          </li>
          <li>
            <router-link to="/about">About us</router-link>
          </li>
          <li>
            <router-link to="/recipes">Recipes</router-link>
          </li>
          <li v-if="!isLoggedIn">
            <router-link to="/login">Login</router-link>
          </li>
          <li v-if="isLoggedIn"><router-link to="/profile">{{ username }}</router-link></li>
          <li v-if="isLoggedIn"><a @click="logout">Logout</a></li>
        </ul>
      </nav>
    </div>
  </Header>
</template>

<script>
export default {
  name: "HeaderComponent",
  computed: {
    isLoggedIn() {
      const accessToken = localStorage.getItem('accessToken')
      return !!accessToken
    },
    username() {
      return localStorage.getItem('username')
    }
  },
  methods: {
    logout() {
      localStorage.clear()
      location.reload()
    }
  }
}
</script>

<style scoped>
.nav {
  background-color: #06070d;
  display: flex;
  justify-content: center;
}

.content {
  width: 960px;
  height: 54px;
  display: flex;
  justify-content: space-between;
  align-items: center;
}

.navigation {
  list-style: none;
  margin: 0;
  display: flex;
  justify-content: flex-end;
  font-family: "Poppins", sans-serif;
  text-transform: uppercase;
  font-size: 13px;
}

.navigation a {
  text-decoration: none;
  padding: 3em;
  color: #dbdbe2;
  cursor: pointer;
}

.logo {
  width: 180px;
}

li a {
  font-size: 13px;
  font-family: 'Comfortaa', cursive;
}

li a:hover {
  color: #ef9a9a;
}
</style>