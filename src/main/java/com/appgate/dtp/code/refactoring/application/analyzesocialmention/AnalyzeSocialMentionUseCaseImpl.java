package com.appgate.dtp.code.refactoring.application.analyzesocialmention;


import com.appgate.dtp.code.refactoring.domain.FacebookPostRepository;
import com.appgate.dtp.code.refactoring.domain.RiskLevel;
import com.appgate.dtp.code.refactoring.domain.SocialAnalyzerFactory;
import com.appgate.dtp.code.refactoring.domain.TweetRepository;
import com.appgate.dtp.shared.utils.AppgateLogger;
import org.springframework.stereotype.Service;

@Service
public class AnalyzeSocialMentionUseCaseImpl implements AnalyzeSocialMentionUseCase {
    private static final AppgateLogger log = AppgateLogger.getLogger(AnalyzeSocialMentionUseCaseImpl.class.getName());
    private final TweetRepository tweetRepository;
    private final FacebookPostRepository facebookPostRepository;

    public AnalyzeSocialMentionUseCaseImpl(TweetRepository tweetRepository, FacebookPostRepository facebookPostRepository) {
        this.tweetRepository = tweetRepository;
        this.facebookPostRepository = facebookPostRepository;
    }

    public RiskLevel execute(AnalyzeSocialMentionCommand command) {
        log.info("Creating entry use case: [{}] ", command.toString());
        SocialAnalyzerService analyzer = SocialAnalyzerFactory.getAnalyzer(command.socialMention());
        if (analyzer instanceof FacebookAnalyzerService) {
            ((FacebookAnalyzerService) analyzer).setRepository(facebookPostRepository);
        } else if (analyzer instanceof TwitterAnalyzerService) {
            ((TwitterAnalyzerService) analyzer).setRepository(tweetRepository);
        }
        return analyzer.analyze(command.socialMention());
    }

}
