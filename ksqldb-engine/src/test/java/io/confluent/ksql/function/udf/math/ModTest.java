package io.confluent.ksql.function.udf.math;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Before;
import org.junit.Test;

public class ModTest {
    private Mod udf;

    @Before
    public void setUp() {
        udf = new Mod();
    }


    @Test
    public void shouldHandlePositive() {
        assertThat(udf.mod(3,2), is(1));
    }
}
