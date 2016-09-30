package com.gettyimages.search;

import com.gettyimages.Credentials;
import com.gettyimages.search.filters.EditorialGraphicalStyles;

import java.util.List;
import java.util.Map;

public class EditorialImagesSearchService extends ImagesSearchService implements EditorialImagesSearch<EditorialImagesSearchService>{
    public EditorialImagesSearchService(Credentials credentials, String baseUrl, Map map) {
        super(credentials, baseUrl, map);
    }
}
