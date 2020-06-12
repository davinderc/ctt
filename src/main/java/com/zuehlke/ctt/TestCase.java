package com.zuehlke.ctt;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "testCases")
public class TestCase implements Serializable {

    public static final String COMMA_STRING = ",";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long testCaseId;

    @Column()
    private String testCaseName;

    @Column()
    private long expectedResult;

    @Column()
    private String operands;

    @Column
    private String lastResult;

    @ManyToOne()
    @JoinColumn(name = "testSuiteId")
    private TestSuite testSuite;

    public TestCase() {

    }

    public TestCase(String testCaseName, List<Long> operands, Long expectedResult) {
        this.testCaseName = testCaseName;
        setOperands(operands);
        this.expectedResult = expectedResult;
    }

    private void setOperands(List<Long> operands) {
        this.operands = operands.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(COMMA_STRING));
    }

    public List<Long> getOperands() {
        List<Long> longOperands = new ArrayList<>(Collections.emptyList());
        for (String element:
                this.operands.split(COMMA_STRING)) {
            longOperands.add(Long.valueOf(element));
        }
        return longOperands;
    }

    public Long getExpectedResult() {
        return this.expectedResult;
    }

    public long getTestCaseId() {
        return testCaseId;
    }

    public String getTestCaseName() {
        return testCaseName;
    }

    public void setTestSuite(TestSuite testSuite) {
        this.testSuite = testSuite;
    }
}
