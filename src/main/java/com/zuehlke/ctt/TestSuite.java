package com.zuehlke.ctt;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "testSuites")
public class TestSuite implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long testSuiteId;

    private String testSuiteName;

    @OneToMany(mappedBy = "testSuite", fetch = FetchType.LAZY,
            cascade = CascadeType.PERSIST)
    private List<TestCase> testCases = new ArrayList<>();
    // use orphanRemoval = true to delete testCases after testSuite deletes.
    // CascadeType.ALL seems to require that new testCases get saved directly with the testSuite (CalculatorTestToolApp)

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

    public List<TestCase> getTestCases() {return testCases;}

}
