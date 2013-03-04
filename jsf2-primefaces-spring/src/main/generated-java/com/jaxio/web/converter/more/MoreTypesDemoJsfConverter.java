/*
 * (c) Copyright 2005-2013 JAXIO, http://www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to use Celerio within your company? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Template pack-jsf2-spring:src/main/java/converter/JsfConverter.e.vm.java
 */
package com.jaxio.web.converter.more;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import com.jaxio.domain.more.MoreTypesDemo;
import com.jaxio.repository.more.MoreTypesDemoRepository;
import com.jaxio.web.converter.GenericJsfConverter;

/**
 * JSF Converter for {@link MoreTypesDemo}.
 */
@Named
@Singleton
public class MoreTypesDemoJsfConverter extends GenericJsfConverter<MoreTypesDemo, Integer> {
    @Inject
    public MoreTypesDemoJsfConverter(MoreTypesDemoRepository moreTypesDemoRepository) {
        super(moreTypesDemoRepository, MoreTypesDemo.class, Integer.class);
    }
}