package com.appgate.dtp.code.refactoring.domain.analyzesocialmention.valueobjects;


import com.appgate.dtp.code.refactoring.domain.analyzesocialmention.exceptions.InvalidUrlException;
import com.appgate.dtp.shared.utils.AppgateLogger;
import com.appgate.dtp.shared.utils.SelfValidating;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Objects;

@Getter
public class Url implements SelfValidating {

    @NotNull
    private final URL urlValue;

    private static final AppgateLogger log = AppgateLogger.getLogger(Url.class.getName());


    public Url(String urlValue) {
        try {
            /*The toURI() method is important here as it ensures that any URL string that complies with RC 2396 is converted to URL.
             However, if we use new URL(String value), it won't ensure that the URL created is fully compliant.
             https://www.baeldung.com/java-validate-url*/
            this.urlValue = new URL(cleanUpUrlAndRemoveTrailingSlash(urlValue));
            this.urlValue.toURI();

        } catch (MalformedURLException | URISyntaxException e) {
            log.error(e.getMessage());
            throw new InvalidUrlException(urlValue);
        }
        this.validateSelf(this);
    }

    private String cleanUpUrlAndRemoveTrailingSlash(String url) {
        return removeTrailingSlash(url.trim());
    }

    private String removeTrailingSlash(String url) {
        while (!url.isEmpty() && (url.endsWith("/") || url.endsWith("\\"))) {
            if (url.charAt(url.length() - 1) == '/' || url.charAt(url.length() - 1) == '\\') {
                url = url.substring(0, url.length() - 1);
            }
        }
        return url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Url that = (Url) o;

        //The url is transformed to a URI before applying equals since calling equals in a URL
        //may trigger a dns lookup to resolve the hostname or ip address, which can take
        //several seconds
        //https://rules.sonarsource.com/java/RSPEC-2112
        try {
            return urlValue.toURI().equals(that.urlValue.toURI());
        } catch (URISyntaxException e) {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(urlValue);
    }

    @Override
    public String toString() {
        return "Url{" +
                "url=" + urlValue +
                '}';
    }
}
