<template>
  <div class="hello">

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
