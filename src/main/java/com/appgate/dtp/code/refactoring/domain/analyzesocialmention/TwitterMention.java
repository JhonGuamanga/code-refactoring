package com.appgate.dtp.code.refactoring.domain.analyzesocialmention;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@EqualsAndHashCode
@SuperBuilder(setterPrefix = "with")
public class TwitterMention extends SocialMention {
    private String twitterAccount;
    private String twitterUrl;
}
