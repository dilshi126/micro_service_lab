package lk.ac.sjp.ict.result.service;

import lk.ac.sjp.ict.result.model.Result;
import lk.ac.sjp.ict.result.repository.ResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResultService {
    @Autowired
    private ResultRepository resultRepository;

    public Result createResult(Result result) {
        return resultRepository.save(result);
    }

    public List<Result> getResultsByStudentId(Long studentId) {
        return resultRepository.findByStudentId(studentId);
    }
}
