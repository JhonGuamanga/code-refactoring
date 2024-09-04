package com.appgate.dtp.code.refactoring.adapters.in.shared;

import com.appgate.dtp.code.refactoring.adapters.in.analyzesocialmention.rest.AnalyzeSocialMentionRequest;
import com.appgate.dtp.code.refactoring.domain.FacebookMention;
import com.appgate.dtp.code.refactoring.domain.SocialMention;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class FacebookMentionRequest extends AnalyzeSocialMentionRequest {
    private String facebookAccount;
    private List<String> facebookComments;

    @Override
    protected SocialMention toSocialMention(){
        var entryBuilder = FacebookMention.builder()
            .withFacebookAccount(facebookAccount)
            .withFacebookComments(facebookComments)
            .withMessage(this.getMessage())
            .withCreationDate(this.getCreationDate());
        return entryBuilder.build();
    }
}
