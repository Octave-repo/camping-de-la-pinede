<template>
    <h1>Chercher un camping</h1>
    <div class="filter">
        <table>
            <tr>
                <th>Ville</th>
                <th>Distance (max)</th>
                <th>Prix (max)</th>
                <th>Note (min)</th>
                <th>Nombre d'étoiles (min)</th>
                <th>Chercher</th>
            </tr>
            <tr>
                <th><CityPicker :display-map="false"
                    @latitude="(n)=>this.latitude=n"
                    @longitude="(n)=>this.longitude=n"/></th>
                <th><input type="number" style="width: 25%;" v-model="distance"></th>
                <th><input type="number" style="width: 25%;" v-model="prix"></th>
                <th><input type="number" style="width: 25%;" v-model="note"></th>
                <th>
                    <select v-model="etoiles">
                        <option value="0">0</option>
                        <option value="1">1</option>
                        <option value="2">2</option>
                        <option value="3">3</option>
                        <option value="4">4</option>
                        <option value="5">5</option>
                    </select>
                </th>
                <th><button @click="confirmer">Chercher</button></th>
            </tr>
        </table>
    </div>
    <br>
    <div class="campingDisplay">
        <table>
            <tr>
                <th>Nom</th>
                <th>Prix</th>
                <th>Etoiles</th>
                <th>Note</th>
                <th>Adresse</th>
            </tr>
            <tr v-for="camping in listCampings" :key="camping.id" class="campingObject" @click="goCamping(camping.id)">
                <td>{{ camping.nom }}</td>
                <td>{{ camping.prix }}</td>
                <td><font-awesome-icon icon="star" v-for="index in camping.nombreEtoiles" :key="index"></font-awesome-icon> </td>
                <td>{{ camping.note > 0 ? camping.note : "N/A" }}</td>
                <td>{{ camping.adresse.nom }}</td>
            </tr>
        </table>
    </div>
</template>
<script>
// @ is an alias to /src
import CityPicker from '@/components/CityPicker.vue'
import CampingService from '@/service/CampingService'
export default {
  name: 'CampingSearchView',
  components: {
    CityPicker
  },
  data(){
    return {
        listCampings: [],
        distance: null,
        etoiles: "0",
        prix: null,
        note: null,
        latitude: null,
        longitude: null
    }
  },
  beforeMount(){
    this.getCampingList();
  },
  methods: {
    async getCampingList(){
        try{
            let response = await CampingService.getCampings();
            this.listCampings = response.data;
        }
        catch(error){
            console.log("RIEN");
        }
    },
    goCamping(id){
        this.$router.push({name: 'campingView', params: {id}});
    },
    async confirmer(){
        this.etoiles = parseInt(this.etoiles)
        this.distance = isNaN(parseFloat(this.distance)) ? null : parseFloat(this.distance)
        this.prix = isNaN(parseFloat(this.prix)) ? null : parseFloat(this.prix)
        this.note = isNaN(parseFloat(this.note)) ? null : parseFloat(this.note)
        try{
            let response = await CampingService.filteredGetCampings(this.note, this.prix, this.longitude,
                this.latitude, this.distance, this.etoiles)
            this.listCampings = response.data
        } catch (error){
            console.log(error)
        }
    }
  }
}
</script>
<style scoped>
.campingObject:hover{
    cursor: pointer;
    background-color: lightgray;
}
table {
    border-collapse: collapse;
    }
    tr { 
    border: solid;
    border-width: 1px 0;
    }
    tr:first-child {
     border-top: none;
    }
    tr:last-child {
        border-bottom: none;
    }

</style>