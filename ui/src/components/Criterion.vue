<template>
  <div class="row">
    <div class="col s3 m2" :class="{'unknown': unknown}">
      <p>Strongly agree</p>
    </div>
    <div class="col s6 m6" :class="{'unknown': unknown}">
      <input type="range" id="test5" min="0" max="4" step="1" v-model="question.answer" :disabled="unknown" />
    </div>
    <div class="col s3 m2" :class="{'unknown': unknown}">
      <p class="right-align">
        Strongly disagree
      </p>
    </div>
    <div class="col s4 m2">
      <p class="center-align">
        <label>
          <input type="checkbox" :value="unknown" @change="updateUnkown" />
          <span>Unknown</span>
        </label>
      </p>
    </div>
  </div>
</template>

<script>
export default {
  name: "Criterion",
  props: {
    question: Object
  },
  data: () => {
    return {
      unknown: false
    };
  },
  mounted() {},
  methods: {
    updateUnkown() {
      this.unknown = !this.unknown;
      if (this.unknown) {
        this.question.answer = this.question.reverse ? 4 : 0;
      }
    }
  }
};
</script>

<style lang="scss" scoped>
.unknown {
  color: rgb(158, 158, 158);

  input[type="range"]::-webkit-slider-thumb {
    background-color: rgb(158, 158, 158);
  }
  input[type="range"]::-moz-range-thumb {
    background-color: rgb(158, 158, 158);
  }
  input[type="range"]::-ms-thumb {
    background-color: rgb(158, 158, 158);
  }
}
input[type="range"] {
  direction: rtl;
  margin-top: 0px;
  margin-bottom: 0px;
  padding-bottom: 21px;
  padding-top: 23px;
  -webkit-tap-highlight-color: transparent;
}
.critera-label {
  padding-bottom: 15px;
  padding-top: 15px;
}
</style>
