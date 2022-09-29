<template>
  <div class="panels">
    <div class="panel panel1">
      <p>Have</p>
    </div>
    <div class="panel panel2">
      <p>Fun</p>
    </div>
    <div class="panel panel3">
      <p>In</p>
    </div>
    <div class="panel panel4">
      <p>The</p>
    </div>
    <div class="panel panel5">
      <p>Kitchen</p>
    </div>
  </div>
</template>

<script>
export default {
  name: "PanelComponent"
}
</script>

<style scoped>

* {
  margin: 0;
  padding: 0;
}

.panels {
  min-height: 50vh;
  overflow: hidden;
  display: flex;
}

.panel {
  background-size: cover;
  background-position: center;
  box-shadow: inset 0 0 0 5px rgba(255, 255, 255, 0.1);
  color: white;
  text-align: center;
  align-items: center;
  transition:
      font-size 0.7s cubic-bezier(0.61,-0.19, 0.7,-0.11),
      flex 0.7s cubic-bezier(0.61,-0.19, 0.7,-0.11),
      background 0.2s;
  font-size: 20px;
  flex: 1;
  display: flex;
  flex-direction: column;
  justify-content: center;
}

.panel1 {
  background-image: url("../assets/1.jpg");
}

.panel2 {
  background-image: url("../assets/2.jpg");
}

.panel3 {
  background-image: url("../assets/3.jpg");
}

.panel4 {
  background-image: url("../assets/4.jpg");
}

.panel5 {
  background-image: url("../assets/5.jpg");
}

.panel > * {
  margin: 0;
  width: 100%;
  transition: transform 0.5s;
  flex: 1 0 auto;
  display: flex;
  align-items: center;
  justify-content: center;
}

.panel p {
  text-transform: uppercase;
  font-family: 'Yanone Kaffeesatz', sans-serif;
  text-shadow: 0 0 4px rgba(0, 0, 0, 0.08), 0 0 14px rgba(0, 0, 0, 0.45);
  font-size: 5em;
}

</style>