<template>
    <h1 class="title" style="background-color: RGB(255, 250, 250); padding: 10px;">Commentaire</h1>
    <p>Laissez nous un commentaire !</p>
    <div class="container">
        <input type="text"/>
    </div>
    <div class="container">
        <p><input type="text" style="height: 100px;"/></p>
    </div>
    <button>Envoyer</button>
</template>
<script>
export default{
    name: 'Avis',
}
</script>
<style scoped>
.container {
    display: flex;
    justify-content: center;
    align-items: center;
};
</style>