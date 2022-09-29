<template>
  <div class="footer">
    <div class="row">
      <ul>
        <li><a href="#">Contact us</a></li>
        <li><a href="#">Our Services</a></li>
        <li><a href="#">Privacy Policy</a></li>
        <li><a href="#">Terms & Conditions</a></li>
        <li><a href="#">Career</a></li>
      </ul>
    </div>

    <div class="row">
      Baking MAMA Copyright © 2022 - All rights reserved || Designed By: Dahye
    </div>
  </div>
</template>

<script>
export default {
  name: "FooterComponent"
}
</script>

<style scoped>
body {
  margin: 0;
  overflow-x: hidden;
}

.footer {
  background: #000;
  padding: 30px 0px;
  font-family: 'Yanone Kaffeesatz', sans-serif;
  text-align: center;
}

.footer .row {
  margin: 1% 0;
  padding: 0.6% 0;
  font-size: 0.8em;
  color: whitesmoke;
}

.footer .row a {
  text-decoration: none;
  transition: 0.5s;
  color: whitesmoke;
}

.footer .row a:hover{
  color: #ef9a9a;
}

.footer .row ul li {
  display: inline-block;
  margin: 0 30px;
}

</style>