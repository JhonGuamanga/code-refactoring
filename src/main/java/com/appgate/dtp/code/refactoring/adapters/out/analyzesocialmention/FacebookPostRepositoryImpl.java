package com.appgate.dtp.code.refactoring.adapters.out.analyzesocialmention;

import com.appgate.dtp.code.refactoring.adapters.out.shared.repositories.JpaFacebookPostRepository;
import com.appgate.dtp.code.refactoring.domain.analyzesocialmention.FacebookMention;
import com.appgate.dtp.code.refactoring.domain.analyzesocialmention.FacebookPostRepository;
import com.appgate.dtp.code.refactoring.domain.analyzesocialmention.SocialMention;
import com.appgate.dtp.shared.utils.AppgateLogger;
import org.springframework.stereotype.Repository;

@Repository
public class FacebookPostRepositoryImpl implements FacebookPostRepository {

    private static final AppgateLogger log = AppgateLogger.getLogger(FacebookPostRepositoryImpl.class.getName());
    private final JpaFacebookPostRepository jpaFacebookPostRepository;
    private final FacebookPostMapper mapper;

    public FacebookPostRepositoryImpl(JpaFacebookPostRepository jpaFacebookPostRepository, FacebookPostMapper mapper) {
        this.jpaFacebookPostRepository = jpaFacebookPostRepository;
        this.mapper = mapper;
    }

    @Override
    public SocialMention insertFBPost(FacebookMention facebookMention) {
        log.debug("Trying to save facebook post with facebookAccount: [{}] and facebookComments: [{}]",
            facebookMention.getFacebookAccount(), facebookMention.getFacebookComments());
        final var entity = this.mapper.fromDomainToEntity(facebookMention);
        final var response = this.jpaFacebookPostRepository.save(entity);
        return this.mapper.fromEntityToDomain(response);
    }
}
