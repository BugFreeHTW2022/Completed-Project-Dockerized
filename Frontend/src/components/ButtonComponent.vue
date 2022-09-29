<template>
  <button class="btn"> {{ name }}</button>
</template>

<script>
export default {
  name: "ButtonComponent",
  props:
      {
        name: String
      }
}
</script>

<style scoped>

.btn {
  cursor: pointer;
  background-color: white;
  display:inline-block;
  position:relative;
  padding:10px 20px;
  border:2px solid #ef9a9a;
  font-family: 'Comfortaa', cursive;
  font-weight: 200;
  font-size:30px;
  text-decoration:none;
  margin:20px auto;
  transition: color 0.4s
}

.btn:after {
  content:" ";
  border:2px solid rgba(0,0,0,0);
  display:inline-block;
  width:100%;
  height:100%;
  position:absolute;
  top:0;
  left:0;
  right:0;
  bottom:0;
  margin:auto;
  transition:all 0.4s;
}

.btn:hover:after {
  border:2px solid #ef9a9a;
  width: calc(100% - 10px);
  height: calc(100% + 10px);
}

</style>