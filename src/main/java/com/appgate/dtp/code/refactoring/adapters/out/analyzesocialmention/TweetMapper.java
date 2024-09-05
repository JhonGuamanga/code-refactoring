package com.appgate.dtp.code.refactoring.adapters.out.analyzesocialmention;


import com.appgate.dtp.code.refactoring.adapters.out.shared.entities.TweetEntity;
import com.appgate.dtp.code.refactoring.domain.analyzesocialmention.SocialMention;
import com.appgate.dtp.code.refactoring.domain.analyzesocialmention.SocialMentionId;
import com.appgate.dtp.code.refactoring.domain.analyzesocialmention.TwitterMention;
import org.springframework.stereotype.Component;

@Component
public class TweetMapper {

    public TweetEntity fromDomainToEntity(TwitterMention twitterMention) {
        return new TweetEntity(
            twitterMention.getId()!= null ? twitterMention.getId().id(): null,
            twitterMention.getMessage()!= null ? twitterMention.getMessage(): null,
            twitterMention.getTwitterAccount()!= null ? twitterMention.getTwitterAccount(): null,
            twitterMention.getTwitterUrl()!= null ? twitterMention.getTwitterUrl().toString() : null,
            twitterMention.getCreationDate()!= null ? twitterMention.getCreationDate(): null,
            twitterMention.getRiskLevel()!= null ? twitterMention.getRiskLevel(): null
        );
    }

    public SocialMention fromEntityToDomain(TweetEntity entity) {
        var builder = TwitterMention.builder()
            .withId(new SocialMentionId(entity.getId()))
            .withRiskLevel(entity.getRiskLevel())
            .withCreationDate(entity.getCreationDate())
            .withMessage(entity.getMessage());

        return builder.build();
    }
}
