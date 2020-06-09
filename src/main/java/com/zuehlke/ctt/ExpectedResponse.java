package com.zuehlke.ctt;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;
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
        setOperands(operands);
        this.operationResult = operationResult;
    }

    private void setOperands(List<Long> operands) {
        this.operands = operands.stream()
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
                this.operands.split(COMMA_STRING)) {
                longOperands.add(Long.valueOf(element));
        }
        return longOperands;
    }
}
