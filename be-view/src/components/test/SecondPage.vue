<template>
    <div id="second">
        <h1>Hello {{author}}, This is SecondPage.</h1>
    </div>
</template>

<script>
    export default {
        name: "SecondPage.vue",
        data(){
            return {
                author: 'Loj'
            }
        }
    }
</script>

<style scoped>

</style>