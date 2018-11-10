package com.spotted.spotted.unidade;

import com.spotted.models.Comment;
import com.spotted.models.Spotted;
import com.spotted.models.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

/**
 * Testes de unidade para {@link Spotted}
 *
 * @author cassioegc
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpottedTest {

    private Spotted spotted;
    private User user;

    @Before
    public void setUp() {
        this.spotted = new Spotted("Test", "Curso Teste", "Testando", "", true);
        this.user = new User("teste@teste", "teste", "");
    }

    /**
     * Testa a adição de um comentário a um spotted.
     */
    @Test
    public void testAddComment() {
        Comment comment = new Comment("", "Comentário de teste", this.user, null);
        this.spotted.addComment(comment);
        Assert.assertTrue("O spotted deveria conter o comentário.",
                this.spotted.getComments().contains(comment));
    }

    /**
     * Testa se dois spotteds são diferentes ao adicionar um comentário a um deles.
     */
    @Test
    public void testEqualsDifferentSpotteds() {
        Comment comment = new Comment("", "Comentário de teste", this.user, null);
        Spotted spottedAux = this.spotted;
        this.spotted.addComment(comment);
        Assert.assertEquals("Os spotteds deveriam ser diferentes.",
                this.spotted, spottedAux);

    }

    /**
     * Testa se dois spotteds são iguais mesmo com visibilidades diferentes.
     */
    @Test
    public void testEquals() {
        Spotted spottedAux = new Spotted("Test", "Curso Teste", "Testando", "", false);
        Assert.assertEquals("Os spotteds deveriam ser iguais.",
                this.spotted, spottedAux);
    }

    @Test
    public void testEqualsDifferentsDateTime() {
        Spotted spottedAux = new Spotted("Test", "Curso Teste", "Testando", "", true);
        spottedAux.setDatetime(LocalDateTime.of(2018, 11, 10, 11, 00));
        this.spotted.setDatetime(LocalDateTime.of(2019, 11, 10, 11, 00));
        Assert.assertNotEquals(this.spotted, spottedAux);
    }

}
