package com.appgate.dtp.code.refactoring.application.analyzesocialmention.services;

import com.appgate.dtp.code.refactoring.domain.analyzesocialmention.valueobjects.RiskLevel;
import com.appgate.dtp.code.refactoring.domain.analyzesocialmention.entities.SocialMention;

public interface SocialAnalyzerService {
    RiskLevel analyze(SocialMention mention);
}
