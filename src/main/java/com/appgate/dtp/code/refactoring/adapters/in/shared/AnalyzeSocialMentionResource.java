package com.appgate.dtp.code.refactoring.adapters.in.shared;

import com.appgate.dtp.code.refactoring.domain.RiskLevel;
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
        var entryResourceBuilder = AnalyzeSocialMentionResource
            .builder()
            .withRiskLevel(riskLevel.name());

        return entryResourceBuilder.build();
    }
}
