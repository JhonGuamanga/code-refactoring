package com.appgate.dtp.code.refactoring.adapters.in.shared;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record ErrorDetail(String field, String rejectedValue, String message) {
}
