package com.gettyimages.search;

import com.gettyimages.Credentials;

import java.util.List;
import java.util.Map;

/**
 * Created by jsantos on 9/26/16.
 */
public class EditorialImagesSearchService extends ImagesSearchService implements EditorialImagesSearch<EditorialImagesSearchService>{
    public EditorialImagesSearchService(Credentials credentials, String baseUrl, Map map) {
        super(credentials, baseUrl, map);
    }

    @Override
    public EditorialImagesSearchService withEntityUris(String entityUris) {
        return null;
    }

    @Override
    public EditorialImagesSearchService withEventIds(String eventIds) {
        return null;
    }

    @Override
    public EditorialImagesSearchService withGraphicalStyles(List<EditorialGraphicalStyles> graphicalStyles) {
        return null;
    }

    @Override
    public EditorialImagesSearchService withSpecificPeople(String specificPeople) {
        return null;
    }
}
