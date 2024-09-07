package com.appgate.dtp.code.refactoring.domain.analyzesocialmention.entities;

import com.appgate.dtp.code.refactoring.domain.analyzesocialmention.valueobjects.RiskLevel;
import com.appgate.dtp.code.refactoring.domain.analyzesocialmention.valueobjects.SocialMentionId;
import com.appgate.dtp.shared.utils.SelfValidating;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@SuperBuilder(setterPrefix = "with")
public abstract class SocialMention implements SelfValidating {

    private SocialMentionId id;

    private String message;

    private String creationDate;

    private RiskLevel riskLevel;
}
