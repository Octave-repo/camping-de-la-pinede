<template>
  <div class="home">
    <h1>Bienvenue aux Campings de la pinède !</h1>
    <img alt="Vue logo" src="../assets/logo.png">
    
    <HelloWorld msg="Welcome to Your Vue.js App"/>

  </div>
</template>

<script>
// @ is an alias to /src
import HelloWorld from '@/components/HelloWorld.vue'

export default {
  name: 'HomeView',
  components: {
    HelloWorld
  }
}
</script>
