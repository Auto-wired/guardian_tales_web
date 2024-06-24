package kr.autowired.guardian_tales_web.dto;

import kr.autowired.guardian_tales_web.entity.TestEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TestDTO {

    private Integer id;
    private String name;
    private Integer age;
    private String description;

}
