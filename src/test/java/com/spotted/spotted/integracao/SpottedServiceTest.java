package com.spotted.spotted.integracao;

import com.spotted.models.Comment;
import com.spotted.models.Spotted;
import com.spotted.models.User;
import com.spotted.services.SpottedService;
import com.spotted.services.UserService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Testes de integracao para {@link SpottedService}
 *
 * @author cassioegc
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpottedServiceTest {

    @Autowired
    private SpottedService spottedService;
	
	@Autowired
	private UserService userService;
	
    private Spotted spotted;
	private User user;
	private String imgDefault = "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gb/0HdXvmf5UA8jjtRHF1Iqy73CWFpvU8e+HngXxBoXitb/UbRI7f7O6b1mRvmOMcDntXsQFU9RvU0+xkumVmWPGQvXk47/Wqlvq9xPOkbaVdxq3/LRtu0fXms6lSVV88i6cIUlyo8/+IPw1u9X1GTWdGEbXEgHn28jbd5AwCpPGcADBwOOtcDF8NvGE0wj/ALFZOxd5Ywq+5+bn8M19KgcUYraljqtOPKjOeEhKVzivAPgtfCWnStPKs1/dEea6g7FAzhVz2568Zz7CuH8a+APEus+M9R1DT7KJ7acpsdplUnbGqng89Qa9tHJzSHjNZwxNSM3U6s0lh4SgodDx3V/B/im48CaFoFtZrvty8lz/AKQoAOTsAOefvE/gKqeGfhBdXL3H/CR+baKu3yRbSoS3Xdnhv9n869QbxJCN8iWlzJbRthrlVBTjqRzyPetmJ1lRZEYMjAMCO4PIqliqsIuK0uZ/V6cpX3PC9d+EusW2qMuhxNdWe1WElxMgfP8AED0/lWt/wrHU9X8KWsd8kdprNlvihLPuSWHJZFYrnpkgHtjpXsWeBmg9zTeMq2Wuw1haaufLdz4V1ey1r+yZ7WKO/wCGWNrmIbwxIBXcwBzg8dfYV1eofD/xfd6XpNimnx+VZQuB/pCD53cs3f02j8K6XWvAHifxJPBHquoaPJDHIGa8itSlwVGfl44xz0z15rv73VEsZorWOGS4uGXcI48fdHGST0repjZvlas2Yww0dea9jzHw/wDBxbjT2l1+S5trwyMFjtpUKhcDGTtPOc/pXP6h8J/EkOoXEdharNaLIRDI06BmTPBIyMGvdNP1OLUkcoskckTbJI5BhkPvWgO9YrG14ybua/VaTSseJa78LNWvrODU7RI49RkjX7bZl1w0gGGZGzjk84J79a5iD4a+LppzH/YrR/7ck8YVffhufwzX0mB7UuKqGOrRVglgoN3OF8B+AI/CcMlzcSLPqU67XdQdka9dq57ep4zgcCu7A4pBTq5JzlUlzS3OiEFBWQUUUUiwooooAaelYMEqw+Kr5ZG2mWGJk3d8ZBxW/VK80uyv9v2q3jl29Nw5FCa6kyTexn6E6zXmqzJzE1xgN2OFAOK3RUFvbQ2sIigiVEXoqjAFTnpQ3dhFWQtFFFBRi+Kf+Reu/wDgH/oYp2n22pROklxfxzQ7f9WsAU/nmtC5t4bu3aGeNZI24Kt0NTKoVcU76WI5feuOooopFhTJPuN/umn0h6UAczoV5a2nhiN7l1VI96yKw5zubgj19q6C3kSSCN4l2oyhgMY4PT6VTfRtPluftL2kLTZzvKdT71ojpTbTIgmtGOooopFiVzkzGPxbJ86o8tntiLeu79a6PtVO80601BQtzAkgXkbhyPpTWhE03sZmiXM817qCTtBL5TRr50Ue0O2MnPJzjit4DioLa1gtYRFBEsaD+FRgVY7UN6jimlZi0UUUigooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigD//2Q==";
 
	@Before
    public void setUp() {
		this.spotted = new Spotted("Teste 1", "teste", "teste", imgDefault , true);
		this.user = new User("thiago.moura@ccc.ufcg.edu.br", "thiagomoura21", this.imgDefault);
        userService.save(user);
    }

    /**
     * Testa se um spotted é salvo com sucesso.
     */
    @Test
    public void testSave() {
        Spotted spottedSaved = spottedService.save(this.spotted);
        Assert.assertTrue("O spotted deveria ter sido salvo.", spottedService.getAll().contains(this.spotted));
        Assert.assertEquals("Os spotteds deveriam ser iguais", spottedSaved, this.spotted);
    }

    /**
     * Testa se um spotted com texto vazio não é salvo.
     */
    @Test
    public void testSaveEmptyText() {
        Spotted spotted = new Spotted("Teste 1", "teste", "", "" , true);
        try {
            spottedService.save(spotted);
            Assert.fail("Uma exceção deveria ter sido lançada.");
        } catch (Exception e) {
            Assert.assertFalse("O spotted não deveria ter sido salvo.", spottedService.getAll().contains(spotted));
        }
    }

    /**
     * Testa se um spotted null não é salvo.
     */
    @Test
    public void testSaveNull() {
        Spotted spotted = null;
        List<Spotted> spotteds = this.spottedService.getAll();
        try {
            spottedService.save(spotted);
            Assert.fail("Uma exceção deveria ter sido lançada.");
        } catch (Exception e) {
            Assert.assertArrayEquals("As listas deveriam ser iguais.",
                    spotteds.toArray(), this.spottedService.getAll().toArray());
        }
    }

    /**
     * Testa se um spotted com texto null não é salvo.
     */
    @Test
    public void testSaveNullText() {
        Spotted spotted = new Spotted("Teste 1", "teste", null, "" , true);
        try {
            spottedService.save(spotted);
            Assert.fail("Uma exceção deveria ter sido lançada.");
        } catch (Exception e) {
            Assert.assertFalse("O spotted não deveria ter sido salvo.", spottedService.getAll().contains(spotted));
        }
    }

    /**
     * Testa se um comentário é adicionado ao spotted corretamente.
     * @throws Exception
     */
    @Test
    public void testAddComment() throws Exception {
        Spotted spottedSaved = spottedService.save(this.spotted);

        Assert.assertTrue("O spotted não deveria ter comentários.", spottedSaved.getComments().isEmpty());
        Comment comment = new Comment(new ArrayList<>(), "Comentário de teste.", this.user, null);

        spottedService.addComment(spottedSaved.getId(), comment);
        Set<Comment> comments = spottedService.getComments(this.spotted.getId());

        Assert.assertFalse("O spotted deveria ter comentários.", comments.isEmpty());
        Assert.assertEquals("O comentário deveria estar no conjunto de comentários do spotted",
                    comments.toArray()[0], comment);
    }

    /**
     * Testa se um comentário com texto vazio não é salvo.
     */
    @Test
    public void testAddCommentEmptyText() {
        Spotted spottedSaved = spottedService.save(this.spotted);

        Assert.assertTrue("O spotted não deveria ter comentários.", spottedSaved.getComments().isEmpty());

        Comment comment = new Comment(new ArrayList<>(), "", this.user, null);
        try {
            spottedService.addComment(spottedSaved.getId(), comment);
            Assert.fail("O comentário não deveria ter sido salvo.");
        } catch (Exception e) {
            Set<Comment> comments = spottedService.getComments(this.spotted.getId());
            Assert.assertFalse("O comentáario não deveria ter sido salvo.", comments.contains(comment));
        }
    }

    /**
     * Testa se um comentário com texto null não é salvo.
     */
    @Test
    public void testAddCommentNullText() {
        Spotted spottedSaved = spottedService.save(this.spotted);

        Assert.assertTrue("O spotted não deveria ter comentários.", spottedSaved.getComments().isEmpty());

        Comment comment = new Comment(new ArrayList<>(), null, this.user, null);

        try {
            spottedService.addComment(spottedSaved.getId(), comment);
            Assert.fail("O comentário não deveria ter sido salvo.");
        } catch (Exception e) {
            Set<Comment> comments = spottedService.getComments(this.spotted.getId());
            Assert.assertFalse("O comentáario não deveria ter sido salvo.", comments.contains(comment));
        }
    }

    /**
     * Testa se um comentário com texto null não é salvo.
     */
    @Test
    public void testAddCommentNull() {
        Spotted spottedSaved = spottedService.save(this.spotted);

        Assert.assertTrue("O spotted não deveria ter comentários.", spottedSaved.getComments().isEmpty());

        Comment comment = null;

        try {
            spottedService.addComment(spottedSaved.getId(), comment);
            Assert.fail("O comentário não deveria ter sido salvo.");
        } catch (Exception e) {
            Set<Comment> comments = spottedService.getComments(this.spotted.getId());
            Assert.assertFalse("O comentáario não deveria ter sido salvo.", comments.contains(comment));
        }
    }

    @Test
    public void testAddCommentSpottedNonexistent() throws Exception {
        Comment comment = new Comment(new ArrayList<>(), "Comentário de teste.", this.user, null);
        Long idInvalid = Long.valueOf(-1);
		try {
			spottedService.addComment(idInvalid, comment);
			Assert.fail("Uma exceção deveria ter sido lançada!");
		} catch (Exception e) {
			Assert.assertEquals("There is not a spotted registered with this id in the system", e.getMessage());
		}
    }

    /**
     * Testa se os spotteds adicinados são retornados.
     */
    @Test
    public void testGetAll() {
        Spotted spotted1 = new Spotted("Teste 1", "T1", "Teste 1", "", true);
        Spotted spotted2 = new Spotted("Teste 2", "T2", "Teste 2", "", true);
        spottedService.save(spotted1);
        spottedService.save(spotted2);
        Assert.assertTrue("Os spotted 1 deveria estar na lista", spottedService.getAll().contains(spotted1));
        Assert.assertTrue("Os spotted 2 deveria estar na lista", spottedService.getAll().contains(spotted2));
    }

    /**
     * Testa se um spotted com visibilidade false não é retornado na listagem de spotteds visíveis.
     */
    @Test
    public void testGetVisible() {
        this.spotted.setVisible(false);
        this.spottedService.save(this.spotted);
        Assert.assertFalse("O spotted não deveria ser listado.", this.spottedService.getVisible().contains(this.spotted));
    }

    /**
     * Testa se um spotted com visibilidade false é retornado na listagem de spotted escondidos.
     */
    @Test
    public void testGetHidden() {
        this.spotted.setVisible(false);
        this.spottedService.save(this.spotted);
        Assert.assertTrue("O spotted deveria ser listado.", this.spottedService.getHidden().contains(this.spotted));
    }

    /**
     * Testa buscar um spotted por id.
     */
    @Test
    public void testGet() {
        Spotted spotted = this.spottedService.save(this.spotted);
        try {
            Assert.assertEquals("Os spotteds deveriam ser iguais.", spotted, this.spottedService.get(spotted.getId()));
        } catch(Exception e) {
            Assert.fail("Não deveria ter ocorrido falha.");
        }
    }

    /**
     * Testa buscar um spotted por id inválido.
     */
    @Test
    public void testGetInvalidId() {
        Spotted spotted = this.spottedService.save(this.spotted);
        try {
            Assert.assertEquals("Os spotteds deveriam ser iguais.", spotted, this.spottedService.get(-1L));
            Assert.fail("Deveria ter ocorrido falha ao pesquisar um spotted com id não cadastrado.");
        } catch(Exception e) {
            Assert.assertEquals("As mensagens deveriam ser iguais", e.getMessage(), "This id is not registered in the system.");
        }
    }

    /**
     * Testa deletar um spotted.
     */
    @Test
    public void testDelete() {
        Spotted spotted = this.spottedService.save(this.spotted);
        Assert.assertTrue("O spotted deveria estar na listagem.", this.spottedService.getAll().contains(spotted));
        this.spottedService.delete(spotted.getId());
        Assert.assertFalse("O spotted não deveria estar na listagem.", this.spottedService.getAll().contains(spotted));
    }

    /**
     * Testa a alteração de visibilidade de um spotted.
     */
    @Test
    public void testSetVisible() {
        Spotted spotted = this.spottedService.save(this.spotted);
        Assert.assertTrue("O spotted deveria ser listado nos visíveis.", this.spottedService.getVisible().contains(this.spotted));
        Assert.assertFalse("O spotted não deveria ser listado nos escondidos.", this.spottedService.getHidden().contains(this.spotted));
        try {
            for (int i = 0; i < 5; i++) {
	    	this.spottedService.setVisible(spotted.getId());
	    } 
	    Assert.assertTrue("O spotted deveria ser listado nos escondidos.", this.spottedService.getHidden().contains(spotted));
            Assert.assertFalse("O spotted não deveria ser lisatdo nos visíveis.", this.spottedService.getVisible().contains(spotted));
        } catch(Exception e) {
            Assert.fail("Não deveria ter ocorrido falha ao mudar a visibilidade so spotted.");
        }
    }

    /**
     * Testa o mudança de visibilidade de um spotted com id inválido.
     */
    @Test
    public void testSetVisibleInvalidId() {
        try {
            this.spottedService.setVisible(-1L);
            Assert.fail("Uma exceção deveria ter ocorrido ao mudar a visilidade de um spotted com id inválido.");
        } catch (Exception e) {
            Assert.assertEquals("As mensagens deveriam ser iguais.", e.getMessage(), "This id is not registered in the system.");
        }
    }
}
