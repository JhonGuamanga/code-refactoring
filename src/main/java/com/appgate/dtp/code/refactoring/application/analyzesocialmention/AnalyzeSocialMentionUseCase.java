package com.appgate.dtp.code.refactoring.application.analyzesocialmention;


import com.appgate.dtp.code.refactoring.domain.analyzesocialmention.valueobjects.RiskLevel;

public interface AnalyzeSocialMentionUseCase {

    RiskLevel execute(AnalyzeSocialMentionCommand any);
}
