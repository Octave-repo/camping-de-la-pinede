<template>
    <div style="height:300px; width:400px">
        <l-map ref="map" :zoom="zoom" :center="pos1">
            <l-tile-layer
            url="https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png"
            layer-type="base"
            name="OpenStreetMap">
            </l-tile-layer>
            <l-marker :lat-lng="pos1" ></l-marker>
            <l-marker v-if="displayDistance" :lat-lng="pos2"></l-marker>
            <l-polyline v-if="displayDistance" :latLngs="
                [pos1,
                pos2]" color=green></l-polyline>
        </l-map>
    </div>
</template>
  
<script>
import "leaflet/dist/leaflet.css";
import GPSService from "@/service/GPSService";
import { LMap, LTileLayer, LMarker, LPolyline } from "@vue-leaflet/vue-leaflet";
  
export default {
    components: {
        LMap,
        LTileLayer,
        LMarker,
        LPolyline
    },
    props: {
        pos1:{
            type: Object,
            required: true
        },
        pos2: Object,
        zoom:{
            type: Number,
            default: 12
        }
    },
    data() {
      return {
        center: [],
        displayDistance: false
      };
    },
    beforeMount(){
        if (this.pos2 !== undefined && this.pos2 !== null){
            this.displayDistance = true;
            this.center = GPSService.findMiddle(this.pos1, this.pos2);
            console.log(this.center);
        }
        else {
            this.center = this.pos1;
        }
    }
};
</script>
  
<style></style>
  