package kr.autowired.guardian_tales_web.service;

import kr.autowired.guardian_tales_web.common.CompatibilityData;
import kr.autowired.guardian_tales_web.dto.TestDTO;
import kr.autowired.guardian_tales_web.entity.TestEntity;
import kr.autowired.guardian_tales_web.repository.TestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TestService {

    final TestRepository testRepository;

    public List<TestDTO> getTestList () {
        return new CompatibilityData<TestDTO>(TestDTO.class).toMulti(this.testRepository.findBy());
    }

    public TestEntity addTest (final TestDTO testDTO) {
        return this.testRepository.save(new CompatibilityData<TestEntity>(TestEntity.class).toSingle(testDTO));
    }

}
