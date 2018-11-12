package com.spotted.spotted.unidade;

import com.spotted.enums.PostTypes;
import com.spotted.models.Comment;
import com.spotted.models.Post;
import com.spotted.models.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

/**
 * Testes de unidadde para {@link Post}
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PostTest {

    private Post post;

    @Before
    public void setUp() {
        this.post = new Post("email@test.com", "Texto de teste.", new byte[]{}, PostTypes.ENTERTAINMENT, "Titulo Teste");
    }

    /**
     * Testa se dois posts são iguais.
     */
    @Test
    public void testEquals() {
        Post post = new Post("email@test.com", "Texto de teste.", new byte[]{}, PostTypes.ENTERTAINMENT, "Titulo Teste");
        Assert.assertEquals("Os posts deveriam ser iguais.", this.post, post);
    }

    /**
     * Testa se dois posts são diferentes por terem tipos diferentes.
     */
    @Test
    public void testEqualsDifferentsTypes() {
        Post post = new Post("email@test.com", "Texto de teste.", new byte[]{}, PostTypes.NOTICE, "Titulo Teste");
        Assert.assertNotEquals("Os posts não deveriam ser iguais.", this.post, post);
    }

    /**
     * Testa se um comentário é adicionado corretamente ao Post.
     */
    @Test
    public void testAddComment() {
        User user = new User("thiago.moura@ccc.ufcg.edu.br", "thiagomoura21", "");
        Comment comment = new Comment(new ArrayList<>(), "", user, null);
        this.post.addComment(comment);
        Assert.assertTrue("O comentário deveria ter sido inserido.", this.post.getComments().contains(comment));
    }

    /**
     * Testa a alteração de visibilidade do Post.
     */
    @Test
    public void testSetVisible() {
        Assert.assertTrue("A visibilidade padrão deveria ser true", this.post.isVisible());
        this.post.setVisible(false);
        Assert.assertFalse("O post não deveria estar visível.", this.post.isVisible());
    }
}

