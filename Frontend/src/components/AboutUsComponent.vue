<template>
  <header class="head">
    <p class="head-intro">Hi, we're</p>
    <h1 class="head-heading">Baking mama!</h1>
  </header>
  <section class="section">
    <p>We are Dahye, Graf and Mareike. We are software developers and also love to bake. The goal of this website is
      to inspire many people to bake and just help you to have fun in the kitchen. Happy baking!</p>
  </section>
</template>

<script>
export default {
  name: "AboutUsComponent"
}
</script>

<style scoped>
body {
  color: #222222;
  font-size: 1em;
}

.head, .head-intro, .head-heading, .section {
  text-align: center;
}

.head-intro {
  margin-bottom: 0.1em;
  font-family: 'Comfortaa', cursive;
  margin-top: 0.1em;
  font-size: 5em;
  color: #9ADBB3;
  letter-spacing: 0.1em;
  text-shadow: 2px 2px #000;
}

.head-heading {
  margin-top: -0.2em;
  font-weight: bold;
  font-family: 'Comfortaa', cursive;
  font-size: 6em;
  letter-spacing: -0.02em;
  text-transform: uppercase;
  color: #FFC0CB;
  text-shadow: 2px 2px #000;
}

.head {
  padding: 6em 0;
  background-image: url(../assets/aboutUs.jpg);
  background-size: cover;
  background-repeat: no-repeat;
  border-top: solid 1em #B0E0E6;
}

.head-intro {
  margin-bottom: 0.1em;
}

.head-heading {
  margin-bottom: -0.2em;
}

.section {
  font-family: 'Comfortaa', cursive;
  max-width: 38em;
  margin-right: auto;
  margin-left: auto;
  margin-top: 2em;
  letter-spacing: 0.05em;
  font-size: 18px;
}


</style>