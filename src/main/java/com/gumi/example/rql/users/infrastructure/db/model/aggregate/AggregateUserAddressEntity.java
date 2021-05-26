package com.gumi.example.rql.users.infrastructure.db.model.aggregate;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import java.io.Serializable;
import java.util.List;

import com.gumi.example.rql.users.infrastructure.db.model.AddressEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "usuario")
public class AggregateUserAddressEntity implements Serializable {

  private static final long serialVersionUID = 4073876827679386654L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String code;
  private String name;
  private String surname;
  private Boolean active;

  @OneToOne(fetch=FetchType.EAGER)
  @JoinColumn(name="address_id")
  private AddressEntity address;
}
