package com.gettyimages.search;

import java.util.List;

/**
 * Created by jsantos on 9/29/16.
 */
public interface EditorialImagesSearch<T> {
    T withEntityUris(String entityUris);
    T withEventIds(String eventIds);
    T withGraphicalStyles(List<EditorialGraphicalStyles> graphicalStyles);
    T withSpecificPeople(String specificPeople);
}
