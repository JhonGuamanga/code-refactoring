package com.appgate.dtp.code.refactoring.domain.analyzesocialmention;

public interface FacebookPostRepository {
    SocialMention insertFBPost(FacebookMention mention);
}
