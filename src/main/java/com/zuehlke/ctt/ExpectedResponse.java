package com.zuehlke.ctt;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "expectedResponses")
public class ExpectedResponse implements Serializable {

    public static final String COMMA_STRING = ",";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long expectedResponseId;

    @Column
    private String operands;

    @Column(nullable = false)
    private long operationResult;

    @OneToOne(mappedBy = "expectedResponse")
    private TestCase testCase;

    public ExpectedResponse() {

    }

    public ExpectedResponse(List<Long> operands, long operationResult) {
        this.operands = setOperands(operands);
        this.operationResult = operationResult;
    }

    private String setOperands(List<Long> operands) {
        return operands.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(COMMA_STRING));
    }

    public long getExpectedResponseId() {
        return expectedResponseId;
    }

    public long getOperationResult() {
        return operationResult;
    }

    public List<Long> getOperands() {
        List<Long> longOperands = new ArrayList<>(Collections.emptyList());
        for (String element:
                operands.split(COMMA_STRING)) {
                longOperands.add(Long.valueOf(element));
        }
        return longOperands;
    }
}
