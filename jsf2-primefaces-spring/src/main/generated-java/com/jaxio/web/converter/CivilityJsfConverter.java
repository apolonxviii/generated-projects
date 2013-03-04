/*
 * (c) Copyright 2005-2013 JAXIO, http://www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to use Celerio within your company? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Template pack-jsf2-spring:src/main/java/converter/converter.enum.vm.java
 */
package com.jaxio.web.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import javax.inject.Named;
import javax.inject.Singleton;

import com.jaxio.domain.Civility;

/**
 * Responsible for creating Civility JSF converters required for multiple select! (support null)
 */
@Named
@Singleton
public class CivilityJsfConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
        if (arg2 != null && !arg2.isEmpty()) {
            return Civility.valueOf(arg2);
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
        if (arg2 instanceof Civility) {
            return ((Civility) arg2).name();
        }
        return "";
    }
}
