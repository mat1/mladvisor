<template>
  <div>
    <div class="row">
      <div class="col s12">
        <h4>ML Advisor</h4>
        <button class="waves-effect waves-light btn-large" @click="start()">Start</button>
      </div>
    </div>
  </div>
</template>

<script>
import Api from "@/api";

export default {
  name: "home",
  methods: {
    start() {
      Api.startSurvey().then(survey => {
        this.$router.push({ name: "survey", params: { id: survey.id } });
      });
    }
  }
};
</script>
