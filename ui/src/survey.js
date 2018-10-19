class Criterion {
  constructor(id, category, question, answer) {
    this.id = id;
    this.category = category;
    this.question = question;
    this.answer = parseInt(answer);
  }
}

class TextQuestion {
  constructor(id, category, question, answer) {
    this.id = id;
    this.category = category;
    this.question = question;
    this.answer = answer;
  }
}

class RadioQuestion {
  constructor(id, category, question, answers, answer) {
    this.id = id;
    this.category = category;
    this.question = question;
    this.answers = answers;
    this.answer = answer;
  }
}

const toQuestions = questions => {
  return questions.map(q => {
    if (q.type == "TextQuestion") {
      return new TextQuestion(q.id, q.category, q.question, q.answer);
    }
    if (q.type == "RadioQuestion") {
      return new RadioQuestion(q.id, q.category, q.question, q.answers, q.answer);
    }
    if (q.type == "Criterion") {
      return new Criterion(q.id, q.category, q.question, q.answer);
    }
  });
};

export default {
  toQuestions,
  Criterion,
  TextQuestion,
  RadioQuestion
};
