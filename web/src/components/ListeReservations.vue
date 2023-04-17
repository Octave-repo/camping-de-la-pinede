<template>
    <h1 style="background-color: RGB(255, 250, 250); padding: 10px;">Mes Réservations</h1>
    <ul class="list-container">
        <li v-for="reservation in listeReservation" :key="reservation.id" class="reservation">
            {{ reservation.content }}
        </li>
    </ul>
</template>
<script>
export default{
    name: 'ListeReservations',
    data(){
        return {
            listeReservation: [
                {id:0, content:"Camping 1"},
                {id:1, content:"Camping 2"},
                {id:2, content:"Camping 3"},
                {id:3, content:"Camping 4"},
                {id:4, content:"Camping 5"},
                {id:5, content:"Camping 6"},
                {id:6, content:"Camping 7"},
                {id:7, content:"Camping 8"},
                {id:8, content:"Camping 9"},
                {id:9, content:"Camping 10"},
                {id:10, content:"Camping 11"}
            ]
        }
    }
}
</script>
<style scoped>
.list-container{
    height: 150px;
    width:20%;
    overflow-x: scroll;
    margin:auto;
}
.reservation:hover{
    cursor: pointer;
    background-color: lightgray;
}
</style>