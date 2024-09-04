package com.appgate.dtp.code.refactoring.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@EqualsAndHashCode
@SuperBuilder(setterPrefix = "with")
public class TwitterMention extends SocialMention {
    private String twitterAccount;
    private String twitterUrl;

    public TwitterMention(String message, String creationDate, String riskLevel) {
        super(message, creationDate, riskLevel);
    }
}
