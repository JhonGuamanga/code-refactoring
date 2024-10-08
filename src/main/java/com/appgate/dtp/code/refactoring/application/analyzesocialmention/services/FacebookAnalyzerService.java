package com.appgate.dtp.code.refactoring.application.analyzesocialmention.services;

import com.appgate.dtp.code.refactoring.application.analyzesocialmention.analyzers.FacebookCommentAnalyzer;
import com.appgate.dtp.code.refactoring.application.analyzesocialmention.analyzers.FacebookPostAnalyzer;
import com.appgate.dtp.code.refactoring.domain.analyzesocialmention.definitions.FacebookPostRepository;
import com.appgate.dtp.code.refactoring.domain.analyzesocialmention.entities.FacebookMention;
import com.appgate.dtp.code.refactoring.domain.analyzesocialmention.entities.SocialMention;
import com.appgate.dtp.code.refactoring.domain.analyzesocialmention.valueobjects.Comment;
import com.appgate.dtp.code.refactoring.domain.analyzesocialmention.valueobjects.RiskLevel;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Setter
@Service
public class FacebookAnalyzerService implements SocialAnalyzerService {

    private FacebookPostRepository repository;

    @Override
    public RiskLevel analyze(SocialMention mention) {
        FacebookMention facebookMention = (FacebookMention) mention;
        String message = "facebookMessage: " + facebookMention.getMessage();
        double facebookScore = 0d;

        double commentsScore = facebookMention.getFacebookComments()
            .stream()
            .map(Comment::getDetail)
            .mapToDouble(FacebookCommentAnalyzer::analyzeComment)
            .sum();

        if (commentsScore < 50) {
            facebookScore -= 100;
        }
        if(facebookScore > - 100){
            facebookScore = FacebookPostAnalyzer.analyzePost(message, facebookMention.getFacebookAccount().getName());

        }

        if (commentsScore < 50) {
            facebookScore -= 100;
        }

        repository.insertFBPost(facebookMention);

        return determineRiskLevel(facebookScore);
    }

    private RiskLevel determineRiskLevel(double score) {
        if (score <= -100) {
            return RiskLevel.HIGH_RISK;
        } else if (score < 50) {
            return RiskLevel.MEDIUM_RISK;
        } else {
            return RiskLevel.LOW_RISK;
        }
    }
}
