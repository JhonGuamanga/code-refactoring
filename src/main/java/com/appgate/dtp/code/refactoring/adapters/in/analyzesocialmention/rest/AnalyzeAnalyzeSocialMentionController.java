package com.appgate.dtp.code.refactoring.adapters.in.analyzesocialmention.rest;

import com.appgate.dtp.code.refactoring.adapters.in.shared.AnalyzeSocialMentionResource;
import com.appgate.dtp.code.refactoring.application.analyzesocialmention.AnalyzeSocialMentionCommand;
import com.appgate.dtp.code.refactoring.application.analyzesocialmention.AnalyzeSocialMentionUseCase;
import com.appgate.dtp.shared.utils.AppgateLogger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/api/v1"})
public class AnalyzeAnalyzeSocialMentionController implements AnalyzeSocialMentionEntryPoint {
    private static final AppgateLogger log = AppgateLogger.getLogger(AnalyzeAnalyzeSocialMentionController.class.getName());
    private final AnalyzeSocialMentionUseCase analyzeSocialMentionUseCase;

    public AnalyzeAnalyzeSocialMentionController(AnalyzeSocialMentionUseCase analyzeSocialMentionUseCase) {
        this.analyzeSocialMentionUseCase = analyzeSocialMentionUseCase;
    }

    @PostMapping("/analyze")
    public ResponseEntity<AnalyzeSocialMentionResource> analyzeSocialMention(@RequestBody AnalyzeSocialMentionRequest analyzeSocialMentionRequest) {
        log.info("Analyzing social mention with message: [{}] and creationDate: [{}]", analyzeSocialMentionRequest.getMessage(), analyzeSocialMentionRequest.getCreationDate());
        analyzeSocialMentionRequest.validateSelf();

        final var analyzeSocialMentionCommand = new AnalyzeSocialMentionCommand(
            analyzeSocialMentionRequest.toSocialMention()
        );

        final var result = analyzeSocialMentionUseCase.execute(analyzeSocialMentionCommand);

        return new ResponseEntity<>(AnalyzeSocialMentionResource.from(result), HttpStatus.CREATED);
    }
}
