<template>
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