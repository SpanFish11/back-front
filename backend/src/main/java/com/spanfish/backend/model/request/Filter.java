package com.spanfish.backend.model.request;

import lombok.Data;

@Data
public class Filter {

  private String dir;
  private Integer from;
  private Integer until;
}
