package com.namlh.bookstore.core.mapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by app on 7/13/18.
 */
public abstract class BaseMapper<FROM, TO> {

    public abstract TO transform(FROM from);

    public List<TO> transform(Collection<FROM> fromList) {
        List<TO> toList = new ArrayList<>();
        for (FROM from: fromList) {
            toList.add(transform(from));
        }
        return toList;
    }
}
