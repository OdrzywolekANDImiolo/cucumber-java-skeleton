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

}
