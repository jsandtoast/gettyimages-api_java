package com.gettyimages.search;

import com.gettyimages.Credentials;
import com.gettyimages.search.filters.GraphicalStyles;
import com.gettyimages.search.filters.LicenseModel;

import java.util.List;
import java.util.Map;

public class CreativeImagesSearchService extends ImagesSearchService implements CreativeImagesSearch<CreativeImagesSearchService>{
    public CreativeImagesSearchService(Credentials credentials, String baseUrl, Map map) {
        super(credentials, baseUrl, map);
    }
}
