package com.appgate.dtp.code.refactoring.application.analyzesocialmention;

import com.appgate.dtp.code.refactoring.domain.analyzesocialmention.RiskLevel;
import com.appgate.dtp.code.refactoring.domain.analyzesocialmention.SocialMention;

public interface SocialAnalyzerService {
    RiskLevel analyze(SocialMention mention);
}
