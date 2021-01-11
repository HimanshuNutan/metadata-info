package com.ac.metadatainfo.exception;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorResponse {
  private String message;
  private String requestedURI;
  private ErrorStatus errorStatus;
}
