package ch.fhnw.mladvisor;

import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@RestController
@RequestMapping("/api/v1/")
public class SurveyController {

    private final Map<String, Survey> surveys = new ConcurrentHashMap<>();
    private final Map<String, SurveyResult> results = new ConcurrentHashMap<>();

    @PostMapping("surveys")
    public Survey createSurvey() {
        Survey survey = new Survey();
        surveys.put(survey.getId(), survey);
        return survey;
    }

    @GetMapping("surveys/{id}")
    public Survey getSurvey(@PathVariable("id") String id) {
        return getSurveyById(id);
    }

    private Survey getSurveyById(@PathVariable("id") String id) {
        return surveys.get(id);
    }

    @PostMapping("surveys/{id}/results")
    public SurveyResult postSurvey(@PathVariable("id") String id, @RequestBody SurveyResultRequest surveyResultRequest) {
        Survey survey = getSurveyById(id);
        surveyResultRequest.getAnswers().forEach(survey::updateAnswer);
        SurveyResult result = SurveyEvaluator.getResult(survey);
        results.put(result.getId(), result);

        return result;
    }

    @GetMapping("results/{id}")
    public SurveyResult getSurveyResult(@PathVariable("id") String id) {
        return results.get(id);
    }

}
