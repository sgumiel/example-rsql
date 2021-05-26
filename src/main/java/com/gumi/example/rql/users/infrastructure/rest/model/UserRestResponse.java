package com.gumi.example.rql.users.infrastructure.rest.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRestResponse implements Serializable {

  private static final long serialVersionUID = 2346703160938952516L;

  private Long id;
  private String code;
  private String name;
  private String surname;
  private Boolean active;
}
