package unitTesty;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import progob.Client;

public class Client_tests {

    private Client klient;
    @Before
    public void setup() {
        klient = new Client("Kamil", "Nowak");
    }
    @Test
    public void testFirstName() {
    Assert.assertEquals("Kamil", klient.getFirstName());
    }
    @Test
    public void testSecondName() {
        Assert.assertEquals("Nowak", klient.getLastName());
    }
    @Test
    public void testClientId() {
        Assert.assertEquals(1, klient.getClientId());
    }
    @Test
    public void testStaticId() {
        Assert.assertEquals(1, klient.getStaticId());
        Client klient2 = new Client("Piotr", "Noga");
        Assert.assertEquals(2, klient2.getStaticId());
        Client klient3 = new Client("Konrad", "Kowal");
        Assert.assertEquals(3, klient3.getStaticId());
    }
}
