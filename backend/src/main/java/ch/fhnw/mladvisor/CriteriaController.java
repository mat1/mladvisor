package ch.fhnw.mladvisor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

import static java.util.stream.Collectors.joining;

@RestController
@RequestMapping("/api/v1/")
public class CriteriaController {

    private static final String CSV_DELIMITER = ";";
    private static final String LINE_SEPARATOR = "\r\n";

    @GetMapping(path = "criteria", produces = "application/csv;charset=ISO-8859-1")
    public String getCriteria(HttpServletResponse response) {

        String csvHeader = List.of("Category", "Sub-Category", "Name").stream()
                .collect(joining(CSV_DELIMITER));

        String csvBody = new Survey().getCriteria().stream().map(Criterion::toCsvString).collect(joining(LINE_SEPARATOR));

        String csvContent = csvHeader + CSV_DELIMITER + LINE_SEPARATOR + csvBody;

        String exportFileName = "criteria.csv";

        response.addHeader("Content-Disposition", "inline; filename=" + exportFileName);
        return csvContent;
    }
}
