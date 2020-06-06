package com.zuehlke.ctt;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface ExpectedResponseRepository extends CrudRepository<ExpectedResponse, Long> {
    List<ExpectedResponse> findByExpectedResponseId(@Param("expectedResponseId") long expectedResponseId);
}
