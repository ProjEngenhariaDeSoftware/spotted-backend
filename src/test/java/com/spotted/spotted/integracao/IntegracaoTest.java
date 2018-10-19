package com.spotted.spotted.integracao;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IntegracaoTest {

    @Test
    public void test1() {
        System.out.printf("Teste 1");
    }

    @Test
    public void test2() {
        Assert.assertTrue(true);
    }

    @Test
    public void test3() {
        Assert.assertFalse(false);
    }
}