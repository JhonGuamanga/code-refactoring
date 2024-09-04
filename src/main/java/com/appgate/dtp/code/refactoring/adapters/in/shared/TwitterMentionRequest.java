package com.appgate.dtp.code.refactoring.adapters.in.shared;

import com.appgate.dtp.code.refactoring.adapters.in.analyzesocialmention.rest.AnalyzeSocialMentionRequest;
import com.appgate.dtp.code.refactoring.domain.SocialMention;
import com.appgate.dtp.code.refactoring.domain.TwitterMention;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TwitterMentionRequest extends AnalyzeSocialMentionRequest {
    private String twitterAccount;
    private String twitterUrl;

    @Override
    protected SocialMention toSocialMention(){
        var entryBuilder = TwitterMention.builder()
            .withTwitterAccount(twitterAccount)
            .withTwitterUrl(twitterUrl)
            .withMessage(this.getMessage())
            .withCreationDate(this.getCreationDate());
        return entryBuilder.build();
    }
}
