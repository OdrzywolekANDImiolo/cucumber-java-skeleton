package progob;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import progob.Person;

import static org.junit.Assert.assertFalse;


public class PersonTest {

    private Person osoba;
    @Before
    public void setup() {
        osoba = new Person("Kamil", "Nowak");
    }
    @Test
    public void testEqualsNullIsFalse() {
        assertFalse(osoba.equals(null));
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

