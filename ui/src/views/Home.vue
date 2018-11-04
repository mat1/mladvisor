<template>
  <div>
    <div class="row">
      <div class="col s12">
        <h4>ML Advisor</h4>
        <p>Machine Learning (ML) Advisor helps you and your company to identify if your use case is suitable
          for machine learning and to compare different use cases with each other. Press start and answer some questions about your case.</p>
        <button class="waves-effect waves-light btn-large" @click="start">Start</button>
        <p>You are not at the point where you already identified potential use cases for machine learning?
          You are not sure which potential machine learning for your company has? Then the identify use cases for machine learning workshop is something for you.</p>
      </div>

      <div class="row">
        <div class="col s12">
          <h5>Identify Use Cases for Machine Learning Workshop</h5>
          <p>The ML Advisor Process supports your organization to get a basic understanding about machine learning and to identify suitable cases.</p>
        </div>
      </div>
      <div class="row">
        <div class="col s12">
          <img ref="materialbox" class="responsive-img" src="../assets/advisor-process.png" alt="ML Advisor Process" />
          <p class="center-align">ML Advisor Process</p>
        </div>
      </div>
      <div class="row">
        <div class="col s12">
          <p>Below you find the workshop and flipchart template as PDF.</p>
        </div>
        <div class="col s12">
          <a class="waves-effect waves-light btn" href="/templates/Identify-Use-Cases-for-Machine-Learning-Workshop.pdf" target="_blank">Download Workshop</a>
          <a class="waves-effect waves-light btn" style="margin-left:10px" href="/templates/Flipchart-Template.pdf" target="_blank">Flipchart Template</a>
        </div>
      </div>

    </div>
  </div>
</template>

<script>
import Api from "@/api";

export default {
  name: "home",
  mounted() {
    var instances = M.Materialbox.init(this.$refs.materialbox, {});
  },
  methods: {
    start() {
      Api.startSurvey().then(survey => {
        this.$router.push({ name: "survey", params: { id: survey.id } });
      });
    }
  }
};
</script>

<style lang="scss">
#app #materialbox-overlay {
  background-color: white;
}
</style>

