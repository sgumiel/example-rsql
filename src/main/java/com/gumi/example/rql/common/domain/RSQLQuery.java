package com.gumi.example.rql.common.domain;

import cz.jirutka.rsql.parser.RSQLParser;
import cz.jirutka.rsql.parser.ast.Node;
import lombok.Getter;

public class RSQLQuery {

  private String rsqlQuery;

  @Getter
  private Node node;

  public RSQLQuery(String rsqlQuery) {
    this.rsqlQuery = rsqlQuery;
    this.node = new RSQLParser().parse(this.rsqlQuery);
  }
}
