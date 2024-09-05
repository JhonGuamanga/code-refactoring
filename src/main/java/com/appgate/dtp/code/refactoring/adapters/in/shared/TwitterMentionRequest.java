package com.appgate.dtp.code.refactoring.adapters.in.shared;

import com.appgate.dtp.code.refactoring.adapters.in.analyzesocialmention.rest.AnalyzeSocialMentionRequest;
import com.appgate.dtp.code.refactoring.domain.analyzesocialmention.entities.Account;
import com.appgate.dtp.code.refactoring.domain.analyzesocialmention.entities.SocialMention;
import com.appgate.dtp.code.refactoring.domain.analyzesocialmention.entities.TwitterMention;
import com.appgate.dtp.code.refactoring.domain.analyzesocialmention.valueobjects.Url;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TwitterMentionRequest extends AnalyzeSocialMentionRequest {
    public static final String TWITTER_ACCOUNT_NULL_MESSAGE = "'twitterAccount' field must not be null";
    public static final String TWITTER_URL_NULL_MESSAGE = "'twitterUrl' field must not be null";

    @NotNull(message = TWITTER_ACCOUNT_NULL_MESSAGE)
    @NotEmpty
    private String twitterAccount;
    @NotNull(message = TWITTER_URL_NULL_MESSAGE)
    @NotEmpty
    private String twitterUrl;

    @Override
    protected SocialMention toSocialMention(){
        var builder = TwitterMention.builder()
            .withTwitterAccount(new Account(twitterAccount))
            .withTwitterUrl(new Url(twitterUrl))
            .withMessage(this.getMessage())
            .withCreationDate(this.getCreationDate());
        return builder.build();
    }
}
