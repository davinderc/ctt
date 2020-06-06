package com.zuehlke.ctt;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface TestSuiteRepository extends PagingAndSortingRepository<TestSuite, Long> {
    List<TestSuite> findByTestSuiteId(@Param("testSuiteId") long testSuiteId);
}
