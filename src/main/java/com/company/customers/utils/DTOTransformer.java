package com.company.customers.utils;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DTOTransformer {

    @Autowired
    @Qualifier("dozerBeanMapper")
    private Mapper dozerBeanMapper;

    public <T> T transform(Object source, Class<T> clazz) {
        if (source == null)
            return null;
        return dozerBeanMapper.map(source, clazz);
    }

    public <T> void map(Object source, Object destination) {
        if (source == null)
            return;
        dozerBeanMapper.map(source, destination);
    }

    public <T, U> List<U> transform(List<T> source, Class<U> destType) {
        if (source == null)
            return null;

        final List<U> dest = new ArrayList<U>();

        for (T element : source) {
            if (element == null) {
                continue;
            }
            dest.add(dozerBeanMapper.map(element, destType));
        }
        // finally remove all null values if any
        List s1 = new ArrayList();
        s1.add(null);
        dest.removeAll(s1);

        return dest;
    }
}