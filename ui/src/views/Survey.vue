<template>
  <div>
    <div class="row" v-for="question in questions" :key="question.id">
      <div class="col s12">
        <h5>{{question.question}}</h5>
        <div v-if="isTextQuestion(question)">
          <text-question :question="question"></text-question>
        </div>
        <div v-if="isRadioQuestion(question)">
          <radio-question :question="question"></radio-question>
        </div>
        <div v-if="isCriterion(question)">
          <criterion :question="question"></criterion>
        </div>
      </div>
    </div>
    <div class="row">
      <div class="col s12">
        <a class="waves-effect waves-light btn-large" @click="send">Show Result</a>
      </div>
    </div>
  </div>
</template>

<script>
import Api from "@/api";
import Survey from "@/survey";
import TextQuestion from "@/components/TextQuestion";
import RadioQuestion from "@/components/RadioQuestion";
import Criterion from "@/components/Criterion";

export default {
  name: "survey",
  components: {
    TextQuestion,
    RadioQuestion,
    Criterion
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
  methods: {
    isCriterion(question) {
      return question instanceof Survey.Criterion;
    },
    isTextQuestion(question) {
      return question instanceof Survey.TextQuestion;
    },
    isRadioQuestion(question) {
      return question instanceof Survey.RadioQuestion;
    },
    send() {
      console.log(this.questions);
    }
  }
};
</script>
