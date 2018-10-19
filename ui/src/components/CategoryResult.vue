<template>
  <div class="card">
    <div class="card-content" :class="color(result.totalPoints)" style="padding-bottom:12px;">
      <span class="card-title">{{result.category}}</span>
    </div>
    <div class="divider"></div>
    <div class="card-content" style="padding-top:8px;padding-bottom:12px;">
      <h5 @click="showPoints = !showPoints" style="cursor: pointer;">Points <span class="right">{{result.totalPoints | formatPoints}} / 4</span></h5>
      <table v-if="showPoints" class="highlight">
        <thead>
          <tr>
            <th>Criteria</th>
            <th>Weight</th>
            <th>Points</th>
            <th>Weighted Points</th>
          </tr>
        </thead>

        <tbody>
          <tr v-for="(criterionR, index) in result.criterionResults" :key="index" :class="{'red lighten-4':criterionR.weightedPoints == 0}">
            <td>{{criterionR.criterion.name}}</td>
            <td>{{formatWeight(criterionR.criterion.weight, result.criterionResults)}}</td>
            <td>{{criterionR.criterion.answer}}</td>
            <td>{{criterionR.weightedPoints | formatPoints}}</td>
          </tr>
          <tr class=" table-summary">
            <td>Total</td>
            <td></td>
            <td></td>
            <td>{{result.totalPoints | formatPoints}}</td>
          </tr>
        </tbody>
      </table>
    </div>
    <div class="divider"></div>
    <div class="card-content" style="padding-top:8px;padding-bottom:12px">
      <h5 @click="showAnswers = !showAnswers" style="cursor: pointer;">Answers</h5>
      <div v-if="showAnswers" style="margin-bottom:8px;">
        <p v-if="result.questionResults.length == 0">No questions answered</p>
        <div v-for="q in result.questionResults" :key="q.question" style="margin-bottom:8px">
          <p>{{q.question}}</p>
          <p>
            <strong>{{q.answer}}</strong>
          </p>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
const MAX_POINTS = 4;

export default {
  name: "CategoryResult",
  props: {
    result: Object
  },
  data: () => {
    return {
      showPoints: false,
      showAnswers: false,
      maxPoints: 4
    };
  },
  methods: {
    color(points) {
      if (points < (MAX_POINTS * 1) / 3) {
        return "red lighten-2";
      }
      if (points < (MAX_POINTS * 2) / 3) {
        return "orange lighten-2";
      }
      return "green lighten-2";
    },
    formatWeight(weight, criterionResults) {
      const result = weight / criterionResults.length;
      return Math.round(result * 100) + "%";
    }
  },
  mounted() {}
};
</script>

<style lang="scss" scoped>
tbody > tr:last-child {
  border-bottom: none;
}
.table-summary {
  font-weight: bold;
}
</style>
