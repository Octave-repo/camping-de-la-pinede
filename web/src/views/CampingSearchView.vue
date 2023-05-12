<template>
    <h1>Chercher un camping</h1>
    <div class="filter">
        <table>
            <tr>
                <th>Ville</th>
                <th>Equipement</th>
                <th>Type de logement</th>
                <th>Prix Max</th>
                <th>Note</th>
                <th>Nombre d'étoiles</th>
            </tr>
            <tr>
                <th><input type="text"></th>
                <th><select></select></th>
                <th><select></select></th>
                <th><input type="number" style="width: 25%;"></th>
                <th><input type="number" style="width: 25%;"></th>
                <th><input type="number" style="width: 25%;"></th>
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
import Map from '@/components/Map.vue';
import CampingService from '@/service/CampingService'
export default {
  name: 'CampingSearchView',
  components: {
    Map
  },
  data(){
    return {
        listCampings: []

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