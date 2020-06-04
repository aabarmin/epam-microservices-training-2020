package com.epam.training.microservices.importer;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ImportRequest {
  private LocalDate startDate;
  private LocalDate endDate;
}
