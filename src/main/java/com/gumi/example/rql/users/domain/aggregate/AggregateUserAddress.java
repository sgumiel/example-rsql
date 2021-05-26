package com.gumi.example.rql.users.domain.aggregate;

import com.gumi.example.rql.users.domain.Address;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AggregateUserAddress {

  private Long id;
  private String code;
  private String name;
  private String surname;
  private Boolean active;
  private Address address;
}
