<template>
  <div class="hello">
    <h1>{{ msg }}</h1>
    <p>
      For a guide and recipes on how to configure / customize this project,<br>
      check out the
      <a href="https://cli.vuejs.org" target="_blank" rel="noopener">vue-cli documentation</a>.
    </p>
    <h3>Installed CLI Plugins</h3>
    <ul>
      <li><a href="https://github.com/vuejs/vue-cli/tree/dev/packages/%40vue/cli-plugin-babel" target="_blank" rel="noopener">babel</a></li>
      <li><a href="https://github.com/vuejs/vue-cli/tree/dev/packages/%40vue/cli-plugin-router" target="_blank" rel="noopener">router</a></li>
    </ul>
    <h3>Essential Links</h3>
    <ul>
      <li><a href="https://vuejs.org" target="_blank" rel="noopener">Core Docs</a></li>
      <li><a href="https://forum.vuejs.org" target="_blank" rel="noopener">Forum</a></li>
      <li><a href="https://chat.vuejs.org" target="_blank" rel="noopener">Community Chat</a></li>
      <li><a href="https://twitter.com/vuejs" target="_blank" rel="noopener">Twitter</a></li>
      <li><a href="https://news.vuejs.org" target="_blank" rel="noopener">News</a></li>
    </ul>
    <h3>Ecosystem</h3>
    <ul>
      <li><a href="https://router.vuejs.org" target="_blank" rel="noopener">vue-router</a></li>
      <li><a href="https://vuex.vuejs.org" target="_blank" rel="noopener">vuex</a></li>
      <li><a href="https://github.com/vuejs/vue-devtools#vue-devtools" target="_blank" rel="noopener">vue-devtools</a></li>
      <li><a href="https://vue-loader.vuejs.org" target="_blank" rel="noopener">vue-loader</a></li>
      <li><a href="https://github.com/vuejs/awesome-vue" target="_blank" rel="noopener">awesome-vue</a></li>
    </ul>
    <Map :pos1="[50.349998, 3.53333]" :pos2="[50.633333, 3.066667]" :zoom=9></Map>
    <CarouselAvis :elements="tempData" />
    <CarouselActivites :elements="tempDataImg"/>
    <StarRate/>
  </div>
</template>

<script>
import Map from '@/components/Map.vue';
import CarouselAvis from '@/components/CarouselAvis.vue';
import StarRate from  '@/components/StarRate.vue';
import CarouselActivites from '@/components/CarouselActivites.vue'
export default {
  name: 'HelloWorld',
  props: {
    msg: String
  },
  components: {
    Map,
    CarouselAvis,
    StarRate,
    CarouselActivites
},
data(){
  return {
    tempData:[{id:1, title:"C'est bien", text:"Lorem Ipsum Amogus"},
      {id:2, title:"C'était très bien", text:"Lorem Ipsum Amogus"},
      {id:3, title:"Blablabla", text:"Lorem Ipsum Amogus"},
      {id:4, title:"fgzjfghejfz", text:"Lorem Ipsum Amogus"},
      {id:5, title:"hkj", text:"Lorem Ipsum Amogus"}
      ],
      tempDataImg:[{id:1, link:"https://i.imgur.com/vm4iVX7.png"},
      {id:2, link:"https://i.imgur.com/XlMlvtf.png"},
      {id:3, link:"https://i.imgur.com/pBDveYw.png"},
      {id:4, link:"https://i.imgur.com/SpGSGfz.png"}
      ]
  }
}

}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h3 {
  margin: 40px 0 0;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
</style>
