/*
 * (c) Copyright 2005-2013 JAXIO, http://www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to use Celerio within your company? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Template pack-jsf2-spring:src/main/java/domain/SearchForm.e.vm.java
 */
package com.jaxio.web.domain;

import javax.inject.Named;
import org.springframework.context.annotation.Scope;
import com.jaxio.dao.support.SearchParameters;
import com.jaxio.domain.Legacy;
import com.jaxio.web.domain.support.GenericSearchForm;

/**
 * View Helper to find/select {@link Legacy}.
 * It exposes a {@link Legacy} instance so it can be used in search by Example query.
 */
@Named
@Scope("conversation")
public class LegacySearchForm extends GenericSearchForm<Legacy, LegacySearchForm> {
    private static final long serialVersionUID = 1L;

    private Legacy legacy = new Legacy();

    public Legacy getLegacy() {
        return legacy;
    }

    @Override
    protected Legacy getEntity() {
        return legacy;
    }

    public SearchParameters toSearchParameters() {
        return new SearchParameters().anywhere();
    }

    @Override
    public LegacySearchForm newInstance() {
        return new LegacySearchForm();
    }

    @Override
    public void resetWithOther(LegacySearchForm other) {
        this.legacy = other.getLegacy();
    }
}