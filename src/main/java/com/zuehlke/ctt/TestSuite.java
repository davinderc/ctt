package com.zuehlke.ctt;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "testSuites")
public class TestSuite implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long testSuiteId;

    private String testSuiteName;

    @OneToMany(mappedBy = "testSuite", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<TestCase> testCases;

    public TestSuite(){

    }

    public TestSuite(String testSuiteName){
        this.testSuiteName = testSuiteName;
    }

    public String getTestSuiteName() {
        return testSuiteName;
    }

    public long getTestSuiteId() {
        return testSuiteId;
    }

    public void addTestCase(TestCase testCase){
        testCases.add(testCase);
    }
}
