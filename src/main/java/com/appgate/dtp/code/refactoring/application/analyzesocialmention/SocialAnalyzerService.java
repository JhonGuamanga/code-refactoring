package com.appgate.dtp.code.refactoring.application.analyzesocialmention;

import com.appgate.dtp.code.refactoring.domain.RiskLevel;
import com.appgate.dtp.code.refactoring.domain.SocialMention;

public interface SocialAnalyzerService {
    RiskLevel analyze(SocialMention mention);
}
