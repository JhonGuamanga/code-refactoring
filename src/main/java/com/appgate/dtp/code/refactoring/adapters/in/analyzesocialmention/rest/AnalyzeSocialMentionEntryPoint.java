package com.appgate.dtp.code.refactoring.adapters.in.analyzesocialmention.rest;


import com.appgate.dtp.code.refactoring.adapters.in.shared.AnalyzeSocialMentionResource;
import com.appgate.dtp.code.refactoring.adapters.in.shared.ErrorMessage;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

@SuppressWarnings("unused")
public interface AnalyzeSocialMentionEntryPoint {
    @Operation(summary = "Analyze a social mention", description = "Allows to analyze a social mention")
    @ApiResponses(
        value = {
            @ApiResponse(responseCode = "201", description = "Success Operation"),
            @ApiResponse(responseCode = "400", description = "Bad request", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))),
            @ApiResponse(responseCode = "404", description = "Not found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))),
            @ApiResponse(responseCode = "409", description = "Conflict", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))),
            @ApiResponse(responseCode = "500", description = "If fail server", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))),
        })
    ResponseEntity<AnalyzeSocialMentionResource> analyzeSocialMention(
        @RequestBody AnalyzeSocialMentionRequest entryRequest
    );
}
