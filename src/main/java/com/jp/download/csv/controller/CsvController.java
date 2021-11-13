package com.jp.download.csv.controller;

import com.jp.download.csv.service.CsvFile;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CsvController {

  private final CsvFile csvFile;

  public CsvController(CsvFile csvFile) {
    this.csvFile = csvFile;
  }

  @GetMapping("csv")
  public ResponseEntity<Resource> getFile() {
    String filename = "report.csv";

    return ResponseEntity.ok()
        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename)
        .contentType(MediaType.parseMediaType("application/csv"))
        .body(csvFile.getFile());
  }

}