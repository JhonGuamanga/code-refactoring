package com.appgate.dtp.code.refactoring.adapters.in.shared;

import com.appgate.dtp.code.refactoring.adapters.in.analyzesocialmention.rest.AnalyzeSocialMentionRequest;
import com.appgate.dtp.code.refactoring.domain.analyzesocialmention.FacebookMention;
import com.appgate.dtp.code.refactoring.domain.analyzesocialmention.SocialMention;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FacebookMentionRequest extends AnalyzeSocialMentionRequest {
    public static final String FACEBOOK_ACCOUNT_NULL_MESSAGE = "'facebookAccount' field must not be null";
    public static final String FACEBOOK_COMMENTS_NULL_MESSAGE = "'facebookComments' field must not be null";

    @NotNull(message = FACEBOOK_ACCOUNT_NULL_MESSAGE)
    @NotEmpty
    private String facebookAccount;

    @NotNull(message = FACEBOOK_COMMENTS_NULL_MESSAGE)
    private List<String> facebookComments;

    @Override
    protected SocialMention toSocialMention(){
        var builder = FacebookMention.builder()
            .withFacebookAccount(facebookAccount)
            .withFacebookComments(facebookComments)
            .withMessage(this.getMessage())
            .withCreationDate(this.getCreationDate());
        return builder.build();
    }
}
