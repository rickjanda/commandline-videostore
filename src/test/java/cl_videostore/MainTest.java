package cl_videostore;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

import static org.junit.Assert.*;

/**
 * Simple pin-down test. Do not use this as an example for a good test ;-)
 */
public class MainTest {

    @Test
    public void run_fullCoverage() throws Exception {
        final String consoleInput =
                "John Doe\n" +
                "0 1\n" +
                "2 3\n" +
                "6 1\n" +
                "9 1\n" +
                "10 2\n" +
                "13 5\n" +
                "\n";
        final ByteArrayOutputStream consoleOutputStream = new ByteArrayOutputStream();

        new Main(
                new ByteArrayInputStream(consoleInput.getBytes(StandardCharsets.UTF_8)),
                new PrintStream(consoleOutputStream)
        ).run();

        assertEquals("0: The Shawshank Redemption (1994)\n" +
                        "1: The Godfather (1972)\n" +
                        "2: The Godfather: Part II (1974)\n" +
                        "3: The Dark Knight (2008)\n" +
                        "4: Pulp Fiction (1994)\n" +
                        "5: The Good, the Bad and the Ugly (1966)\n" +
                        "6: The Lord of the Rings: The Return of the King (2003)\n" +
                        "7: Fight Club (1999)\n" +
                        "8: The Lord of the Rings: The Fellowship of the Ring (2001)\n" +
                        "9: Interstellar (2014)\n" +
                        "10: Whiplash (2014)\n" +
                        "11: Birdman (2014)\n" +
                        "12: Up (2009)\n" +
                        "13: WALL·E (2008)\n" +
                        "Enter customer name: Choose movie by number followed by rental days, just ENTER for bill:\n" +
                        "cl_videostore.Rental Record for John Doe\n" +
                        "\tThe Shawshank Redemption (1994)\t2.0\n" +
                        "\tThe Godfather: Part II (1974)\t3.5\n" +
                        "\tThe Lord of the Rings: The Return of the King (2003)\t1.5\n" +
                        "\tInterstellar (2014)\t3.0\n" +
                        "\tWhiplash (2014)\t6.0\n" +
                        "\tWALL·E (2008)\t4.5\n" +
                        "You owed 20.5\n" +
                        "You earned 7 frequent renter points\n",
                consoleOutputStream.toString("UTF-8"));
    }
}
