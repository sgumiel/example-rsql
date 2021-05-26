package com.gumi.example.rql.common.infrastructure.db;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.stream.Collectors;

import cz.jirutka.rsql.parser.ast.ComparisonOperator;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.jpa.domain.Specification;

@Data
@AllArgsConstructor
public class GenericRsqlSpecification<T> implements Specification<T> {

  private String property;
  private ComparisonOperator operator;
  private List<String> arguments;

  @Override
  public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
    List<Object> args = castArguments(root);
    Object argument = args.get(0);
    switch (RsqlSearchOperation.getSimpleOperator(operator)) {

      case EQUAL: {
        if (argument instanceof String) {
          return builder.like(getPath(root, property), argument.toString().replace('*', '%'));
        } else if (argument == null) {
          return builder.isNull(getPath(root, property));
        } else {
          return builder.equal(getPath(root, property), argument);
        }
      }
      case NOT_EQUAL: {
        if (argument instanceof String) {
          return builder.notLike(root.<String> get(property), argument.toString().replace('*', '%'));
        } else if (argument == null) {
          return builder.isNotNull(getPath(root, property));
        } else {
          return builder.notEqual(getPath(root, property), argument);
        }
      }
      case GREATER_THAN: {
        return builder.greaterThan(root.<String> get(property), argument.toString());
      }
      case GREATER_THAN_OR_EQUAL: {
        return builder.greaterThanOrEqualTo(root.<String> get(property), argument.toString());
      }
      case LESS_THAN: {
        return builder.lessThan(root.<String> get(property), argument.toString());
      }
      case LESS_THAN_OR_EQUAL: {
        return builder.lessThanOrEqualTo(root.<String> get(property), argument.toString());
      }
      case IN:
        return getPath(root, property).in(args);
      case NOT_IN:
        return builder.not(getPath(root, property).in(args));
    }

    return null;
  }

  private List<Object> castArguments(final Root<T> root) {

    Class<? extends Object> type = getPath(root, property).getJavaType();

    List<Object> args = arguments.stream().map(arg -> {
      if (type.equals(Integer.class)) {
        return Integer.parseInt(arg);
      } else if (type.equals(Long.class)) {
        return Long.parseLong(arg);
      } else {
        return arg;
      }
    }).collect(Collectors.toList());

    return args;
  }

  private Expression<String> getPath(Root<?> root, String property){
    final var nestedProperties = property.split("\\.");

    if(nestedProperties.length>0) {


      Path<String> nestedPath = root.get(nestedProperties[0]);

      for (int i = 1; i < nestedProperties.length; i++) {
        nestedPath = nestedPath.get(nestedProperties[i]);

      }
      return nestedPath;
    }

    return root.get(property);

  }

}