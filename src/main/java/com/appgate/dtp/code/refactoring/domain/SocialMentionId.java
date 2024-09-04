package com.appgate.dtp.code.refactoring.domain;


import com.appgate.dtp.shared.utils.SelfValidating;
import jakarta.validation.constraints.Positive;

public record SocialMentionId(@Positive long id
) implements SelfValidating {
    public SocialMentionId(long id) {
        this.id = id;
        this.validateSelf(this);
    }
}
