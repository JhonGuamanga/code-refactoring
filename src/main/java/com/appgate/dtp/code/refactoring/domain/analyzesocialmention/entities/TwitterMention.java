package com.appgate.dtp.code.refactoring.domain.analyzesocialmention.entities;

import com.appgate.dtp.code.refactoring.domain.analyzesocialmention.valueobjects.Url;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@EqualsAndHashCode
@SuperBuilder(setterPrefix = "with")
public class TwitterMention extends SocialMention {
    private Account twitterAccount;
    private Url twitterUrl;
}
