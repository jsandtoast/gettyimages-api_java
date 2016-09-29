package com.gettyimages.search;

import com.gettyimages.Credentials;

import java.util.List;
import java.util.Map;

/**
 * Created by jsantos on 9/26/16.
 */
public class CreativeImagesSearchService extends ImagesSearchService implements CreativeImagesSearch<CreativeImagesSearchService>{
    public CreativeImagesSearchService(Credentials credentials, String baseUrl, Map map) {
        super(credentials, baseUrl, map);
    }

    @Override
    public CreativeImagesSearchService withGraphicalStyles(List<GraphicalStyles> graphicalStyles) {
        return null;
    }

    @Override
    public CreativeImagesSearchService withLicenseModels(List<LicenseModel> licenseModels) {
        return null;
    }

    @Override
    public CreativeImagesSearchService withPrestigeContentOnly(boolean prestigeContentOnly) {
        return null;
    }
}
