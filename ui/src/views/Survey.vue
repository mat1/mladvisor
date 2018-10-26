<template>
  <div>
    <loading-widget v-if="loading"></loading-widget>
    <div v-else>
      <div class="row">
        <div class="col s12">
          <blockquote>
            The statements with the slider are used to calculate a score in four areas (actual situation, target situation, input and output). 
            The questions with the radio buttons and text fields have no influence on the score.
            But these questions are important to answer before your start with a machine learning project.
          </blockquote>
        </div>
      </div>
      <div class="row" v-for="question in questions" :key="question.id">
        <div class="row" v-if="firstQuestionFromCategory(question) && question.category != 'GENERAL'">
          <div class="col s12">
            <h4>{{toCategoryName(question.category)}}</h4>
            <div class="divider"></div>
          </div>
        </div>
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
          <a class="waves-effect waves-light btn-large" @click="send">Show Results</a>
        </div>
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
import LoadingWidget from "@/components/LoadingWidget";

export default {
  name: "survey",
  components: {
    TextQuestion,
    RadioQuestion,
    Criterion,
    LoadingWidget
  },
  data: () => {
    return {
      loading: true,
      questions: [],
      id: null
    };
  },
  created() {
    Api.getSurvey(this.$route.params.id).then(survey => {
      this.questions = Survey.toQuestions(survey.questions);
      this.id = survey.id;
      this.loading = false;
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
      const surveyResultRequest = {
        answers: this.questions.map(q => {
          return {
            id: q.id,
            answer: q.answer
          };
        })
      };

      console.log(surveyResultRequest);
      Api.postResult(this.id, surveyResultRequest).then(result => {
        console.log(result);
        this.$router.push({ name: "result" });
      });
    },
    firstQuestionFromCategory(question) {
      let q = this.questions.find(q => q.category == question.category);
      return q == question;
    },
    toCategoryName(cat) {
      switch (cat) {
        case "INPUT":
          return "Input";
        case "OUTPUT":
          return "Output";
        case "ACTUAL":
          return "Actual Situation";
        case "TARGET":
          return "Target Situation";
        default:
          return "";
      }
    }
  }
};
</script>
