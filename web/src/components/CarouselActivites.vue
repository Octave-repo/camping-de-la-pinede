<template>
    <Carousel :items-to-show="3"
        :autoplay="2000"
        :wrap-around="true" class="carousel">
        <Slide v-for="element in elements" :key="element.id">
            <div>
                <img :src="element.link" width="240" height="135" class="carousel-content"/>
            </div>
        </Slide>
        <template #addons>
            <Pagination/>
            <Navigation/>
        </template>
    </Carousel>
</template>
<script>
import {Carousel, Navigation, Pagination, Slide } from 'vue3-carousel'
import 'vue3-carousel/dist/carousel.css'
export default{
    name: 'CarouselActivites',
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
    width: 55%;
}
.carousel-content{
  border-radius: 5%;
}
</style>