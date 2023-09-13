package org.homework11;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class CelebratedExtractor {
    public static void extract(int filteredMonth, File file) throws IOException {
        List<String> processedEntries = Files.readAllLines(Paths.get("src/main/resources/input.txt"))
                .stream()
                .map(Celebrated::new)
                .filter(celebrated -> celebrated.getMonthOfBirth() == filteredMonth)
                .sorted((e1, e2) -> {
                    if(e1.getFirstName().equalsIgnoreCase(e2.getFirstName())){
                        return e1.getLastName().compareToIgnoreCase(e2.getLastName());
                    }
                    return e1.getFirstName().compareToIgnoreCase(e2.getFirstName());
                })
                .map(Celebrated::adjustForWriting)
                .collect(Collectors.toList());

        Files.write(Paths.get("src/main/resources/output.txt"), processedEntries);
    }
}
