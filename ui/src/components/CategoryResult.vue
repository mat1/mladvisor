<template>
  <div class="card">
    <div class="card-content" style="padding-bottom:8px;">
      <span class="card-title">{{result.category}}</span>
    </div>
    <div class="divider"></div>
    <div class="card-content" style="padding-top:8px;padding-bottom:8px;">
      <h5 @click="showPoints = !showPoints" style="cursor: pointer;">Points: {{formatNumber(result.totalPoints)}} / 4</h5>
      <table v-if="showPoints">
        <thead>
          <tr>
            <th>Criteria</th>
            <th>Weight</th>
            <th>Points</th>
            <th>Eval. Points</th>
          </tr>
        </thead>

        <tbody>
          <tr v-for="(criterionR, index) in result.criterionResults" :key="index">
            <td>{{criterionR.criterion.name}}</td>
            <td>{{formatWeight(criterionR.criterion.weight, result.criterionResults)}}</td>
            <td>{{criterionR.criterion.answer}}</td>
            <td>{{formatNumber(criterionR.weightedPoints)}}</td>
          </tr>
        </tbody>
      </table>
    </div>
    <div class="divider"></div>
    <div class="card-content" style="padding-top:4px;padding-bottom:8px;">
      <h5>Answers</h5>
    </div>
  </div>
</template>

<script>
export default {
  name: "CategoryResult",
  props: {
    result: Object
  },
  data: () => {
    return {
      showPoints: false
    };
  },
  methods: {
    formatNumber(num) {
      if (num == 0) {
        return 0;
      }
      return num.toFixed(1);
    },
    formatWeight(weight, criterionResults) {
      const result = weight / criterionResults.length;
      console.log(result);
      return Math.round(result * 100) + "%";
    }
  },
  mounted() {}
};
</script>
