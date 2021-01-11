package com.ac.metadatainfo.exception;

public enum ErrorMessages {

  DOC_DATA_NOT_FOUND("There is no additional data for given id - {}");

  private final String message;

  ErrorMessages(String message) {
    this.message = message;
  }

  public String getMessage(String[] params) {
    return String.format(this.message, params);
  }
}
