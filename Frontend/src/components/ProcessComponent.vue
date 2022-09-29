<template>
  <div class="wrapper">
    <div class="left-side">
      <ul v-for="(item, index) in items" :key="index" class="items">
        <li><i class="icon">{{ index + 1 }}</i>{{ Object.keys(item)[0] }} - {{ Object.values(item)[0] }}</li>
      </ul>
    </div>
  </div>
</template>

<script>
export default {
  name: "ProcessComponent",
  props: {
    items: Array
  }
}
</script>

<style scoped>

.left-side {
  width: 70%;
}

.left-side .items {
  flex: 1;
  display: flex;
  flex-flow: row wrap;
}

.left-side .items li {
  display: flex;
  padding: 10px;
  background-color: white;
  border: 2px solid #f2f6f8;
  border-radius: 8px;
  margin-right: 15px;
  margin-bottom: 15px;
  font-weight: 600;
  align-items: center;
  width: 44%;
  transition: all 100ms cubic-bezier(0.87, 0, 0.13, 1);
}

.left-side .items .icon {
  display: flex;
  justify-content: center;
  align-items: center;
  border-radius: 8px;
  width: 40px;
  height: 40px;
  background-color: white;
  margin-right: 10px;
  font-style: normal;
}
</style>