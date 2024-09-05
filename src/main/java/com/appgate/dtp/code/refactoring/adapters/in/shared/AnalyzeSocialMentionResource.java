package com.appgate.dtp.code.refactoring.adapters.in.shared;

import com.appgate.dtp.code.refactoring.domain.analyzesocialmention.RiskLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@Builder(setterPrefix = "with")
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class AnalyzeSocialMentionResource {

    private String riskLevel;

    public static AnalyzeSocialMentionResource from(RiskLevel riskLevel) {
        var builder = AnalyzeSocialMentionResource
            .builder()
            .withRiskLevel(riskLevel.name());

        return builder.build();
    }
}
