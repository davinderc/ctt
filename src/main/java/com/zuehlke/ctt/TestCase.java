package com.zuehlke.ctt;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "testCases")
public class TestCase implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long testCaseId;

    @Column()
    private String name;

    @Column
    private String lastResult;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "testSuiteId")
    private TestSuite testSuite;

    @OneToOne
    @JoinColumn(name = "expectedResponseId")
    private ExpectedResponse expectedResponse;


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
