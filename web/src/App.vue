<template>
  <div class="header">
    <profile></profile>
    <br/>
    <br/>
    <nav>
      <router-link to="/">Accueil</router-link> |
      <router-link to="/campings">Nos Campings</router-link>
    </nav>
  </div>
<router-view/>
</template>
<script>
import Profile from './components/Profile.vue';
 export default{
  components:{
    Profile
  }
 };
</script>
<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

nav {
  padding: 30px;
}
/*
body{
  background: radial-gradient(circle at -1% 57.5%, rgb(19, 170, 82) 0%, rgb(0, 102, 43) 90%);
}*/
  

nav a {
  font-weight: bold;
  color: #2c3e50;
}

nav a.router-link-exact-active {
  color: #42b983;
}

.header{
  width: 100%;
  margin-top: 0;
  height: 100px;
  background-color: lightskyblue;
}
</style>
