<template>
  <div class="heading">
    <span>the</span>
    <h1>{{ title }}</h1>
  </div>
</template>

<script>
export default {
  name: "TitleComponent",
  props: {
    title: String
  }
}
</script>

<style scoped>
.heading {
  font-weight: 900;
  font-size: 22px;
  color: #283439;
  display: flex;
  justify-content: center;
  align-items: center;
  width: 30%;
}

.heading h1 {
  display: block;
}

.heading span {
  display: block;
  color: #ff3482;
  font-size: 0.9rem;
  text-transform: uppercase;
  margin-right: 14px;
}

</style>