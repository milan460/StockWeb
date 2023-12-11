<template>
  <div class="home">
    <h1>Home</h1>
    <p>You must be authenticated to see this</p>
    <stockPage/>
  </div>
</template>

<script>
import stockPage from "../components/StockData.vue"
export default {
  name: "home",
  components: {
    stockPage
  }
};
</script>
