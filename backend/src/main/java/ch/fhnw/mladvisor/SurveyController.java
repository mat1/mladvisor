package ch.fhnw.mladvisor;

import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@RestController
@RequestMapping("/api/v1/")
public class SurveyController {

    private final Map<String, Survey> surveys = new ConcurrentHashMap<>();
    private final Map<String, SurveyResult> results = new ConcurrentHashMap<>();

    private final SurveyStore surveyStore;

    public SurveyController(SurveyStore surveyStore) {
        this.surveyStore = surveyStore;
    }

    @PostMapping("surveys")
    public Survey createSurvey() {
        Survey survey = new Survey();
        surveyStore.saveSurvey(survey);
        return survey;
    }

    @GetMapping("surveys/{id}")
    public Survey getSurvey(@PathVariable("id") String id) {
        return surveyStore.getSurveyById(id);
    }

    @PostMapping("surveys/{id}/results")
    public SurveyResult postSurvey(@PathVariable("id") String id, @RequestBody SurveyResultRequest surveyResultRequest) {
        Survey survey = surveyStore.getSurveyById(id);

        surveyResultRequest.getAnswers().forEach(survey::updateAnswer);
        surveyStore.updateSurvey(survey);

        return SurveyEvaluator.getResult(survey);
    }

    @GetMapping("surveys/{id}/results")
    public SurveyResult getSurveyResult(@PathVariable("id") String id) {
        Survey survey = surveyStore.getSurveyById(id);

        return SurveyEvaluator.getResult(survey);
    }

}
