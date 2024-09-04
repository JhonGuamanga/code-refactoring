package com.appgate.dtp.code.refactoring.application.analyzesocialmention;

import com.appgate.dtp.code.refactoring.domain.FacebookMention;
import com.appgate.dtp.code.refactoring.domain.SocialMention;
import com.appgate.dtp.code.refactoring.domain.TwitterMention;
import com.appgate.dtp.shared.utils.SelfValidating;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode(callSuper = false)
@Builder(setterPrefix = "with")
@Getter
public class AnalyzeSocialMentionCommand implements SelfValidating {

    private final SocialMention socialMention;

    public AnalyzeSocialMentionCommand(SocialMention socialMention) {
        this.socialMention = socialMention;
        this.validateSelf(this);
    }

    public SocialMention toTwitterMention(TwitterMention twitterMention) {
        var entryBuilder = TwitterMention.builder()
            .withTwitterAccount(twitterMention.getTwitterAccount())
            .withTwitterUrl(twitterMention.getTwitterUrl())
            .withMessage(this.socialMention.getMessage())
            .withCreationDate(this.socialMention.getCreationDate())
            .withRiskLevel(this.socialMention.getRiskLevel());
        return entryBuilder.build();
    }

    public SocialMention toFacebookMention(FacebookMention facebookMention) {
        var entryBuilder = FacebookMention.builder()
            .withFacebookAccount(facebookMention.getFacebookAccount())
            .withFacebookComments(facebookMention.getFacebookComments())
            .withMessage(this.socialMention.getMessage())
            .withCreationDate(this.socialMention.getCreationDate())
            .withRiskLevel(this.socialMention.getRiskLevel());
        return entryBuilder.build();
    }
}
