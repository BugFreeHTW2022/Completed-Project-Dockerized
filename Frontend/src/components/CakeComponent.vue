<template>
  <div class="oval"></div>
  <div class="cherry">
    <div class="stem"></div>
    <div class="reflection"></div>
  </div>
  <div class="top_cake"></div>
  <div class="center"></div>
</template>

<script>
export default {
  name: "CakeComponent"
}
</script>

<style scoped>
.oval {
  height: 150px;
  width: 300px;
  border-radius: 50%;
  left: 50%;
  transform: translatex(-50%);
  z-index: -1;
}

.cherry {
  position: absolute;
  top: 155px;
  left: 48%;
  transform: translatex(-50%);
  height: 30px;
  width: 30px;
  border: 4px solid darkred;
  border-radius: 50%;
  background: #ff1744;
  box-sizing: border-box;
}

.cherry .stem {
  height:25px;
  width: 20px;
  border-left: 5px solid darkred;
  border-right: 5px solid rgba(255, 0, 0, 0);
  border-top: 5px solid rgba(255, 0, 0, 0);
  border-bottom: 5px solid rgba(255, 0, 0, 0);
  border-radius: 50%;
  transform: rotate(45deg);
  top: -25px;
  left: 10px;
  position: relative;
}

.cherry .reflection {
  width: 12px;
  height: 12px;
  background: white;
  border-radius: 50%;
  top: -30px;
  position: relative;
}

.top_cake {
  width: 0;
  height: 0;
  border-top: 100px solid #ef9a9a;
  border-right: 100px solid transparent;
  transform: rotate(107deg) scale(0.3, -1) translatey(-50%);
  position: absolute;
  left: 50%;
  top: 155px;
  z-index: -1;
  border-radius: 9px;
}

.center {
  height: 50px;
  width: 105px;
  border-top: 15px solid #ffccbc;
  border-left: 10px solid #ffccbc;
  border-bottom: 15px solid #ffccbc;
  background: #ef9a9a;
  box-sizing: border-box;
  border-radius: 5px;
  position: absolute;
  left: 50.1%;
  transform: translatex(-50%);
  top: 189px;
}

</style>