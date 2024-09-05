package com.appgate.dtp.code.refactoring.application.analyzesocialmention;

import com.appgate.dtp.code.refactoring.domain.analyzesocialmention.*;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Service
@Setter
public class TwitterAnalyzerService implements SocialAnalyzerService {

    private TweetRepository repository;

    @Override
    public RiskLevel analyze(SocialMention mention) {
        TwitterMention twitterMention = (TwitterMention) mention;
        String message = "tweeterMessage: " + twitterMention.getMessage();

        double twitterScore = TwitterPostAnalyzer.analyzeTweet(message, twitterMention.getTwitterUrl(), twitterMention.getTwitterAccount());
        repository.insertTweet(twitterMention);
        return determineRiskLevel(twitterScore);
    }

    private RiskLevel determineRiskLevel(double score) {
        if (score >= -1 && score <= -0.5) {
            return RiskLevel.HIGH_RISK;
        } else if (score > -0.5 && score < 0.7) {
            return RiskLevel.MEDIUM_RISK;
        } else {
            return RiskLevel.LOW_RISK;
        }
    }
}
