package com.jp.download.csv.service.impl;

import com.jp.download.csv.domain.User;
import com.jp.download.csv.service.CsvFile;
import com.jp.download.csv.utils.CsvUtils;
import java.util.List;
import org.springframework.core.io.InputStreamResource;
import org.springframework.stereotype.Service;

@Service
public class CsvFileImpl implements CsvFile {


  @Override
  public InputStreamResource getFile() {
    return new InputStreamResource(CsvUtils.createCsv(getUsers()));
  }

  private List<User> getUsers() {
    return List.of(User.builder()
            .firstName("Han")
            .lastName("Solo")
            .address("Address 123")
            .phoneNumber(123456789)
            .build(),
        User.builder()
            .firstName("A2R2")
            .lastName("José")
            .address("Some Addess")
            .phoneNumber(1123415666)
            .build());
  }
}
