package com.jp.download.csv.utils;

import com.jp.download.csv.domain.User;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import lombok.experimental.UtilityClass;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.QuoteMode;

@UtilityClass
public class CsvUtils {

  public ByteArrayInputStream createCsv(List<User> users) {
    final CSVFormat format = CSVFormat.DEFAULT.withQuoteMode(QuoteMode.MINIMAL);

    try (ByteArrayOutputStream out = new ByteArrayOutputStream();
        CSVPrinter csvPrinter = new CSVPrinter(new PrintWriter(out), format)) {
      for (User user : users) {
        List<String> data = Arrays.asList(
            String.valueOf(user.getFirstName()),
            String.valueOf(user.getLastName()),
            String.valueOf(user.getAddress()),
            String.valueOf(user.getPhoneNumber())
        );

        csvPrinter.printRecord(data);
      }

      csvPrinter.flush();
      return new ByteArrayInputStream(out.toByteArray());
    } catch (IOException e) {
      throw new RuntimeException("Error creating csv file: " + e.getMessage());
    }
  }

}