package com.appgate.dtp.code.refactoring.adapters.out.analyzesocialmention;


import com.appgate.dtp.code.refactoring.adapters.out.shared.repositories.JpaTweetRepository;
import com.appgate.dtp.code.refactoring.domain.SocialMention;
import com.appgate.dtp.code.refactoring.domain.TweetRepository;
import com.appgate.dtp.code.refactoring.domain.TwitterMention;
import com.appgate.dtp.shared.utils.AppgateLogger;
import org.springframework.stereotype.Repository;

@Repository
public class TweetRepositoryImpl implements TweetRepository {

    private static final AppgateLogger log = AppgateLogger.getLogger(TweetRepositoryImpl.class.getName());
    private final JpaTweetRepository repository;
    private final TweetMapper mapper;

    public TweetRepositoryImpl(JpaTweetRepository repository, TweetMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public SocialMention insertTweet(TwitterMention twitterMention) {
        log.debug("Trying to save tweet with twitterAccount: [{}] and twitterUrl: [{}]",
            twitterMention.getTwitterAccount(), twitterMention.getTwitterUrl());
        final var entity = this.mapper.fromDomainToEntity(twitterMention);
        final var response = this.repository.save(entity);
        return this.mapper.fromEntityToDomain(response);
    }
}
