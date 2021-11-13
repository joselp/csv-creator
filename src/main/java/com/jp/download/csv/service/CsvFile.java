package com.jp.download.csv.service;

import org.springframework.core.io.InputStreamResource;

public interface CsvFile {

  InputStreamResource getFile();
}
