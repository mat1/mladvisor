import axios from "axios";

const startSurvey = () => {
  return axios.post("/api/v1/surveys").then(response => response.data);
};

const postResult = (id, request) => {
  return axios.post(`/api/v1/surveys/${id}/results`, request).then(response => response.data);
};

const getResults = id => {
  return axios.get(`/api/v1/results/${id}`).then(response => response.data);
};

export default {
  startSurvey,
  postResult,
  getResults
};
