package com.zuehlke.ctt;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface TestCaseRepository extends CrudRepository<TestCase, Long> {
    List<TestCase> findByTestCaseId(@Param("testCaseId") long testCaseId);
}
