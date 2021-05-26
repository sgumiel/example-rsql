package com.gumi.example.rql.users.infrastructure.rest.model.aggregate;

import java.io.Serializable;
import java.util.List;

import com.gumi.example.rql.users.infrastructure.rest.model.AddressRestResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AggregateUserAddressRestResponse implements Serializable {

  private static final long serialVersionUID = 3966974125469506197L;

  private Long id;
  private String code;
  private String name;
  private String surname;
  private Boolean active;
  private List<AddressRestResponse> address;
}