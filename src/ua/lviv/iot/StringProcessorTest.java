package ua.lviv.iot;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.LinkedList;
import java.util.List;



class StringProcessorTest {
    StringProcessor manager = new StringProcessor();
    String testString;
    List<String> expected;
    List<String> actual;

    @BeforeEach
    public void setUp() {
        expected = new LinkedList<String>();
        actual = new LinkedList<String>();

        testString = "Fsdgnekr, city Lviv, Big Street, work time: 09:12 - 21:00  Fsdgnekr, city Lviv, Some Other Street," +
                " work time: 3:45 - 9:32";

        expected.add("Fsdgnekr, city Lviv, Big Street, work time: 09:12 - 21:00");
        expected.add("Fsdanerk, city Lviv, Some Other Street," + " work time: 3:45 - 9:32");

        manager.setLine(testString);
    }

    @Test
    public void testFindMatch() {
        actual = manager.findMatch();
        Assertions.assertEquals(2, actual.size());
        Assertions.assertEquals(expected, actual);
        manager.showResults();
    }

    @Test
    public void testFindMatchNotFound() {
        manager.setLine("https://www.jetbrains.com/help/idea/create-tests.html");
        actual = manager.findMatch();
        Assertions.assertEquals(0, actual.size());
        manager.showResults();
    }

}