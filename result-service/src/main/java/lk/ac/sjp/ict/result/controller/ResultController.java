package lk.ac.sjp.ict.result.controller;

import lk.ac.sjp.ict.result.model.Result;
import lk.ac.sjp.ict.result.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/results")
public class ResultController {
    @Autowired
    private ResultService resultService;

    @PostMapping
    public Result createResult(@RequestBody Result result) {
        return resultService.createResult(result);
    }

    @GetMapping("/student/{id}")
    public List<Result> getResultsByStudentId(@PathVariable Long id) {
        return resultService.getResultsByStudentId(id);
    }
}
