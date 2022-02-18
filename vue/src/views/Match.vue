<template>
<div class="match">
    <div id="previous-matches-div">
        
    </div>

    <div id="match-scores-div">
    <create-match />
    </div>

    <div id="upcoming-matches-div">
       
    </div>

</div>
</template>

<script>
import CreateMatch from '../components/CreateMatch.vue';



export default {
    components: { CreateMatch  },
    name: "match",

}
</script>

<style scoped>
.match {
    width: 100vw;
    height: 80vh;
    display: flex;
    justify-content: space-between;
    padding: 20px;
    align-content: center;
}






</style>>
