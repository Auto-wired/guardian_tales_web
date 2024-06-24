package kr.autowired.guardian_tales_web.repository;

import kr.autowired.guardian_tales_web.entity.TestEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TestRepository extends JpaRepository<TestEntity, Integer> {

    List<TestEntity> findBy ();

}
