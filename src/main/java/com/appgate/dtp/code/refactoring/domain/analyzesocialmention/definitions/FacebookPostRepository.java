package com.appgate.dtp.code.refactoring.domain.analyzesocialmention.definitions;

import com.appgate.dtp.code.refactoring.domain.analyzesocialmention.entities.FacebookMention;
import com.appgate.dtp.code.refactoring.domain.analyzesocialmention.entities.SocialMention;

public interface FacebookPostRepository {
    SocialMention insertFBPost(FacebookMention mention);
}
