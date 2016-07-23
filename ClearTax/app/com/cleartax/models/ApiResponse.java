package com.cleartax.models;

import lombok.Data;

/**
 * @author aritra
 */
@Data
public class ApiResponse {

  private final Integer rate;

  private Integer calls;

  private Object data;

}
