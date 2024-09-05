package com.appgate.dtp.code.refactoring.adapters.out.analyzesocialmention;


import com.appgate.dtp.code.refactoring.adapters.out.shared.entities.FacebookPostEntity;
import com.appgate.dtp.code.refactoring.domain.analyzesocialmention.FacebookMention;
import com.appgate.dtp.code.refactoring.domain.analyzesocialmention.SocialMention;
import com.appgate.dtp.code.refactoring.domain.analyzesocialmention.SocialMentionId;
import org.springframework.stereotype.Component;

@Component
public class FacebookPostMapper {

    public FacebookPostEntity fromDomainToEntity(FacebookMention facebookMention) {
        return new FacebookPostEntity(
            facebookMention.getId()!= null ? facebookMention.getId().id(): null,
            facebookMention.getMessage()!= null ? facebookMention.getMessage(): null,
            facebookMention.getFacebookAccount()!= null ? facebookMention.getFacebookAccount(): null,
            facebookMention.getFacebookComments()!= null ? facebookMention.getFacebookComments().toString() : null,
            facebookMention.getCreationDate()!= null ? facebookMention.getCreationDate(): null,
            facebookMention.getRiskLevel()!= null ? facebookMention.getRiskLevel(): null
        );
    }

    public SocialMention fromEntityToDomain(FacebookPostEntity facebookPostEntity) {
        var builder = FacebookMention.builder()
            .withId(new SocialMentionId(facebookPostEntity.getId()))
            .withRiskLevel(facebookPostEntity.getRiskLevel())
            .withCreationDate(facebookPostEntity.getCreationDate())
            .withMessage(facebookPostEntity.getMessage());

        return builder.build();
    }
}
