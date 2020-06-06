package com.zuehlke.ctt;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "testSuites")
public class TestSuite implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long testSuiteId;

    private String testSuiteName;

    @OneToMany(mappedBy = "testSuite", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<TestCase> testCases;

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
}
