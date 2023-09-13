package homework11;

import org.homework11.CelebratedExtractor;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CelebratedExtractorTest {
    File input, expected;

    @Rule
    public TemporaryFolder folder = new TemporaryFolder();
    @Before
    public void setUp() throws IOException {
        try {
            input = folder.newFile("input.txt");
            FileWriter myWriter = new FileWriter(input);
            myWriter.write("Solomon, Gordon, 16.07.2001\n" +
                    "Chelsea, Collier, 23.04.2005\n" +
                    "Madeleine, Dale, 11.01.1999\n" +
                    "Mildred, Petersen, 7.10.2000\n" +
                    "Abbey, Knight, 16.10.1988\n" +
                    "Kyla, Bass, 18.1.1994\n" +
                    "Saoirse, Carter, 15.01.1990\n" +
                    "Cheryl, Vaughan, 27.12.2000\n" +
                    "Darius, Hobbs, 13.04.2004\n" +
                    "Georgie, Hartman, 26.04.1989");
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    @Test
    public void testExtract() {
        try {
            expected = folder.newFile("expected.txt");
            FileWriter myWriter = new FileWriter(expected);
            myWriter.write("Kyla, Bass\n" +
                    "Madeleine, Dale\n" +
                    "Saoirse, Carter\n");
            myWriter.close();

            CelebratedExtractor.extract(1, input);
            Path path = Paths.get("src/main/resources/output.txt");
            File output = path.toFile();

            assertEquals(expected.length() + Files.lines(path).count(), output.length());
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
