package ch.fhnw.mladvisor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/")
public class SurveyController {

    @PostMapping("surveys")
    public Survey createSurvey() {
        return new Survey();
    }

    @GetMapping("surveys")
    public Survey getSurvey() {
        return new Survey();
    }

}
