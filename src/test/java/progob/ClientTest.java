package progob;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;

public class ClientTest {

    private Client klient;
    @Before
    public void setup() {
        klient = new Client("Kamil", "Nowak");
    }
    @Test
    public void testEqualsNullIsFalse() {
        assertFalse(klient.equals(null));
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
