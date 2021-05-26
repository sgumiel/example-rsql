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
public class AddressRestResponse implements Serializable {

  private static final long serialVersionUID = 4427561943284149613L;

  private Long id;
  private String address;
}
