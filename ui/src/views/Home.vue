<template>
  <div>
    <div class="row">
      <div class="col s12">
        <h4>ML Advisor</h4>
        <p>Machine Learning (ML) Advisor helps you and your company to identify if your use case is suitable 
          for machine learning and to compare different use cases with each other. Press start and answer some questions about your case.</p>
        <button class="waves-effect waves-light btn-large" @click="start">Start</button>
        <p>You are not at the point where your already identified potential use cases for machine learning? 
          You are not sure which potential machine learning for your company has? Then the identify use cases for machine learning workshop is something for you.</p>
        <h5>Identify Use Cases for Machine Learning Workshop</h5>
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
