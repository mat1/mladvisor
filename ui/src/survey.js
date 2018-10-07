class Criterion {
  constructor(id, category, question) {
    this.id = id;
    this.category = category;
    this.question = question;
    this.answers = [
      { text: "Strongly agree", value: 4 },
      { text: "Agree", value: 3 },
      { text: "Neutral", value: 2 },
      { text: "Disagree", value: 1 },
      { text: "Strongly disagree", value: 0 }
    ];
    this.answer = null;
    this.unimportant = false;
  }
}

class TextQuestion {
  constructor(id, category, question) {
    this.id = id;
    this.category = category;
    this.question = question;
    this.answer = null;
  }
}

class RadioQuestion {
  constructor(id, category, question, answers) {
    this.id = id;
    this.category = category;
    this.question = question;
    this.answers = answers;
    this.answer = null;
  }
}

const toQuestions = questions => {
  return questions.map(q => {
    if (q.type == "TextQuestion") {
      return new TextQuestion(q.id, q.category, q.question);
    }
    if (q.type == "RadioQuestion") {
      return new RadioQuestion(q.id, q.category, q.question, q.answers);
    }
    if (q.type == "Criterion") {
      return new Criterion(q.id, q.category, q.question);
    }
  });
};

export default {
  toQuestions,
  Criterion,
  TextQuestion,
  RadioQuestion
};
