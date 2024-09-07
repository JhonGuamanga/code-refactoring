package com.appgate.dtp.code.refactoring.adapters.in.analyzesocialmention.rest;

import com.appgate.dtp.code.refactoring.adapters.in.shared.CommonExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(assignableTypes = {AnalyzeAnalyzeSocialMentionController.class})
public class AnalyzeSocialMentionControllerExceptionHandler extends CommonExceptionHandler {

}
