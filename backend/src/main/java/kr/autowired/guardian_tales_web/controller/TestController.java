package kr.autowired.guardian_tales_web.controller;

import kr.autowired.guardian_tales_web.dto.TestDTO;
import kr.autowired.guardian_tales_web.entity.TestEntity;
import kr.autowired.guardian_tales_web.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
public class TestController {

    final TestService testService;

    @GetMapping("/get/list")
    public ResponseEntity<List<TestDTO>> getTestList () {
        return new ResponseEntity<List<TestDTO>>(this.testService.getTestList(), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<String> addTest (@RequestBody final TestDTO testDTO) {
        this.testService.addTest(testDTO);

        return new ResponseEntity<String>(HttpStatus.OK);
    }

}
