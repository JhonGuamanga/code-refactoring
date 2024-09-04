package com.appgate.dtp.code.refactoring.application.analyzesocialmention;


import com.appgate.dtp.code.refactoring.domain.SocialMention;
import com.appgate.dtp.shared.utils.AppgateLogger;
import org.springframework.stereotype.Service;

@Service
public class AnalyzeSocialMentionUseCaseImpl implements AnalyzeSocialMentionUseCase {
    private static final AppgateLogger log = AppgateLogger.getLogger(AnalyzeSocialMentionUseCaseImpl.class.getName());


    public AnalyzeSocialMentionUseCaseImpl(EntriesValidatorService entriesValidatorService) {
        this.entriesValidatorService = entriesValidatorService;
    }

    public SocialMention execute(AnalyzeSocialMentionCommand entryCommand) {
        log.info("Creating entry use case: [{}] ", entryCommand.toString());
        this.validateDuplicateEntry(entryCommand);
        EntriesRulesValidations entriesRulesValidations = new EntriesRulesValidations(this.entryRepository);
        this.entriesValidatorService.execute(entryCommand.getEntryTuple(), entriesRulesValidations);
        return this.entryRepository.save(entryCommand.toEntry());
    }

    public void validateDuplicateEntry(AnalyzeSocialMentionCommand analyzeSocialMentionCommand) {

        entryRepository
            .findByTypeAndValue(analyzeSocialMentionCommand.getEntryTuple().getType(),
                analyzeSocialMentionCommand.getEntryTuple().getFormatValue())
            .ifPresent(entry -> {
                throw new EntryAlreadyExistsException(entry.getType().type(), entry.getValue().value());
            });
    }
}
