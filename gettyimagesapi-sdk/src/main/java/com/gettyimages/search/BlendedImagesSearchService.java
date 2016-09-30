package com.gettyimages.search;

import com.gettyimages.Credentials;
import com.gettyimages.search.filters.GraphicalStyles;
import com.gettyimages.search.filters.LicenseModel;

import java.util.*;

public class BlendedImagesSearchService extends ImagesSearchService implements BlendedImagesSearch<BlendedImagesSearch>{

    private String EditorialString = "editorial";
    private String CreativeString = "creative";

    public BlendedImagesSearchService(Credentials credentials, String baseUrl, Map map) {
        super(credentials, baseUrl, map);
    }

    public static BlendedImagesSearchService GetInstance(Credentials credentials, String baseUrl) {
        return new BlendedImagesSearchService(credentials, baseUrl, new Hashtable());
    }

    public CreativeImagesSearchService creative() {
        map.put(AssetTypeString, CreativeString);
        return new CreativeImagesSearchService(credentials, baseUrl, map);
    }

    public EditorialImagesSearchService editorial() {
        map.put(AssetTypeString, EditorialString);
        return new EditorialImagesSearchService(credentials, baseUrl, map);
    }
}
