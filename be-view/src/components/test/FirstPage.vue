<template>
    <div id="first">
        <h1>Hello {{author}}, This is FirstPage.</h1>
    </div>
</template>

<script>
    export default {
        name: "FirstPage.vue",
        data(){
            return {
                author: 'Loj'
            }
        }
    }
</script>

<style scoped>

</style>