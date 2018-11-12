package com.spotted.spotted.unidade;

import com.spotted.models.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.spotted.models.Comment;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Testes de unidade para {@link Comment}
 * @author cassioegc
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CommentTest {

    private User user;
    private Comment comment;

    @Before
    public void setUp() {
        this.user = new User("teste@teste", "teste", "");
        this.comment = new Comment(new ArrayList<>(), "Comentário de teste.", this.user, null);
    }

    /**
     * Testa se dois Comentários são iguais.
     */
    @Test
    public void testEquals() {
        Comment comment = new Comment(new ArrayList<>(), "Comentário de teste.", this.user, null);
        Assert.assertEquals("Os comentários deveriam ser iguais.", this.comment, comment);
    }

    /**
     * Testa se dois comentários são diferentes quando um tem um usuário mencionado e o outro não.
     */
    @Test
    public void testEqualsDifferentComments() {
        Comment comment = new Comment(Arrays.asList("UserTest"), "Comentário de teste.", this.user, null);
        Assert.assertNotEquals("Os comentários não deveriam ser iguais.", this.comment, comment);
    }

    /**
     * Testa se ao mencionar um usuário ele é retornado corretamente.
     */
    @Test
    public void testUserMentioned() {
        Comment comment = new Comment(Arrays.asList("UserTest"), "Comentário de teste 2.", this.user, null);
        Assert.assertEquals("O usuário retornado não é o esperado.", "UserTest", comment.getUsersMentioned().toArray()[0]);
    }

    /**
     * Testa se um comentário que não é de Spotted tem o id null.
     */
    @Test
    public void testGetSpottedId() {
        Assert.assertNull("O comentário não deveria ter spottedId. ", this.comment.getSpottedId());
    }

    /**
     * Testa se o spottedId é atribuido corretamente.
     */
    @Test
    public void testSpottedId() {
        Comment comment = new Comment(Arrays.asList("UserTest"), "Comentário de teste 2.", this.user, 1L);
        Assert.assertNotNull("O spottedId não deveria ser null.", comment.getSpottedId());
    }
}
