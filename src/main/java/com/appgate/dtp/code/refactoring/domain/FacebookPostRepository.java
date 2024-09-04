package com.appgate.dtp.code.refactoring.domain;

public interface FacebookPostRepository {
    SocialMention insertFBPost(FacebookMention mention);
}
