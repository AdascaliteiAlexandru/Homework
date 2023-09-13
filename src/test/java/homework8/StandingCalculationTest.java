package homework8;

import org.homework8.Athlete;
import org.homework8.MainReader;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StandingCalculationTest {
    File fileTest;

    @Rule
    public TemporaryFolder tempFolder = new TemporaryFolder();

    @Before
    public void setUp() {
        try {
            fileTest = tempFolder.newFile("testfile.txt");
        } catch (IOException e) {
            System.err.println("error creating temporary test file in " +
                    this.getClass().getSimpleName());
        }
    }

    @Test
    public void testCase() throws IOException {
        try {
            FileWriter fw = new FileWriter(fileTest);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(String.format("11,Umar Jorgson,SK,30:27,xxxox,xxxxx,xxoxo%n"));
            bw.write(String.format("1,Jimmy Smiles,UK,29:15,xxoox,xooxo,xxxxo%n"));
            bw.write(String.format("27,Piotr Smitzer,CZ,30:10,xxxxx,xxxxx,xxxxx%n"));
            bw.close();
        } catch(IOException e) {
            System.err.println(
                    "error creating temporary test file in " +
                            this.getClass().getSimpleName() );
        }

        List<Athlete> aTest = MainReader.finalStandings(fileTest);
        assertEquals(1810, aTest.get(0).timeResult);
        assertEquals(0, aTest.get(0).missPenalty);

        assertEquals(1755, aTest.get(1).timeResult);
        assertEquals(60, aTest.get(1).missPenalty);

        assertEquals(1827, aTest.get(2).timeResult);
        assertEquals(30, aTest.get(2).missPenalty);
    }
}
