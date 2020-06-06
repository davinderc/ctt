package com.zuehlke.ctt;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "testCases")
public class TestCase implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long testCaseId;

    private String name;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "testSuiteId")
    private TestSuite testSuite;

    public TestCase() {

    }

    public TestCase(String name) {
        this.name = name;
    }

    public long getTestCaseId() {
        return testCaseId;
    }

    public String getName() {
        return name;
    }
}
