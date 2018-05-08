package unitTesty;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import progob.Person;


public class Person_tests {

    private Person osoba;
    @Before
    public void setup() {
        osoba = new Person("Kamil", "Nowak");
    }
    @Test
    public void testGetFirstName() {
        Assert.assertEquals("Kamil", osoba.getFirstName());
    }
    @Test
    public void testGetLastName() {
        Assert.assertEquals("Nowak", osoba.getLastName());
    }
    @Test
    public void testEquals() {
        Person osoba2 = osoba;
        Assert.assertTrue(osoba.equals(osoba2));
    }

}

