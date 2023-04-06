<template>
    <label>Adresse</label>
    <input type="text" v-model="adresse">
    <label>Code Postal</label>
    <input type="number" v-model="postalCode">
    <button @click="fetchCity">Ok</button>
    <Map :pos1="position"></Map>
</template>
<script>
import VilleService from '@/service/VilleService'
import Map from '@/components/Map.vue';
export default{
    name: 'CityPicker',
    components:{
        Map
    },
    data () {
        return {
            adresse: "",
            postalCode: 0,
            city: {},
            position: [0,0]
        }
    },
    methods:{
        async fetchCity(){
            try{
                let response = await VilleService.getVille(this.adresse, this.postalCode);
                this.city = response.data.features[0];
                this.postalCode = this.city.properties.postcode;
                this.adresse = this.city.properties.label;
                this.position = [this.city.geometry.coordinates[1], this.city.geometry.coordinates[0]];
                this.emitAll();
            } catch(error){
                console.log(error);
            }
        },
        emitAll(){
            this.$emit('adresse', adresse);
            this.$emit('latitude', position[0]);
            this.$emit('longitude', position[1]);
        }
    }
}
</script>