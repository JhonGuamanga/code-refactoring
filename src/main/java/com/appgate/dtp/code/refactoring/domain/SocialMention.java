package com.appgate.dtp.code.refactoring.domain;

import com.appgate.dtp.shared.utils.SelfValidating;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@Builder(setterPrefix = "with")
public abstract class SocialMention implements SelfValidating {

    private String message;

    private String creationDate;

    private String riskLevel;

    public void validateSelf() {
        this.validateSelf(this);
    }
}
