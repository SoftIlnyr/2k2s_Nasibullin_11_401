import org.junit.Test;
import org.junit.Assert;

/**
 * Created by softi on 26.02.2016.
 */
public class ClientFormTest {
    @Test
    public void clientFormConstrucktorWorksCorrect() {
        try {
            ClientForm form = new ClientForm("127.0.0.1", "Bla");

        } catch (Exception e) {
            Assert.fail();
        }

    }
}
