<template>
    <Carousel :items-to-show="3"
        :autoplay="2000"
        :wrap-around="true" class="carousel">
        <Slide v-for="element in elements" :key="element.id">
            <div class="carousel-content">
                <h1>{{ element.title }}</h1>
                <p>{{ element.text }}</p>
            </div>
        </Slide>
        <template #addons>
            <Navigation/>
        </template>
    </Carousel>
</template>
<script>
import {Carousel, Navigation, Pagination, Slide } from 'vue3-carousel'
import 'vue3-carousel/dist/carousel.css'
export default{
    name: 'CarouselDisplay',
    components:{
        Carousel, Navigation, Pagination, Slide
    },
    props:{
        elements:{
            type: Array,
            required: true
        }
    },
    data(){
        return {

        }
    }
}
</script>
<style scoped>
.carousel{
    margin:auto;
    width: 75%;
}
.carousel-content{
  width: 99%;
  height: 150px;
  background-color: lightgreen;
  border-radius: 25px;
}
</style>