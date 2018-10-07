<template>
  <div>
    <div class="row">
      <div class="col s12">
        <h4>Survey</h4>
      </div>
    </div>
    <div class="row" v-for="question in questions" :key="question.id">
      <div class="col s12">
        <h5>{{question.question}}</h5>
        <div v-if="isTextQuestion(question)">
          <text-question :question=question></text-question>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import Api from "@/api";
import Survey from "@/survey";
import TextQuestion from "@/components/TextQuestion";

export default {
  name: "survey",
  components: {
    TextQuestion
  },
  data: () => {
    return {
      questions: []
    };
  },
  created() {
    Api.startSurvey().then(survey => {
      this.questions = Survey.toQuestions(survey.questions);
      console.log(this.questions);
    });
  },
  mounted() {
    M.textareaAutoResize($("#textarea1"));
  },
  methods: {
    isCriterion(question) {
      return question instanceof Survey.Criterion;
    },
    isTextQuestion(question) {
      return question instanceof Survey.TextQuestion;
    },
    isRadioQuestion(question) {
      return question instanceof Survey.RadioQuestion;
    }
  }
};
</script>
