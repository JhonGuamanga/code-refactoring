package com.appgate.dtp.code.refactoring.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Getter
@EqualsAndHashCode
@SuperBuilder(setterPrefix = "with")
public class FacebookMention extends SocialMention {
    private String facebookAccount;
    private List<String> facebookComments;

    public FacebookMention(String message, String creationDate, String riskLevel) {
        super(message, creationDate, riskLevel);
    }
}
