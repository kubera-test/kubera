package com.kuberatest.e2e.action;

import com.kuberatest.e2e.Kubera;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class ActionTest {
    protected Kubera kubera;

    @BeforeEach
    public void setUp() {
        kubera = new Kubera();
    }

    @AfterEach
    public void tearDown() {
        kubera.close();
    }
}
