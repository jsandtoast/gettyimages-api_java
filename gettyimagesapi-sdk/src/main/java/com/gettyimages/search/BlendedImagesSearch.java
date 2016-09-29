package com.gettyimages.search;

import com.gettyimages.search.filters.GraphicalStyles;
import com.gettyimages.search.filters.LicenseModel;

import java.util.List;

/**
 * Created by jsantos on 9/29/16.
 */
public interface BlendedImagesSearch<T> {
    T withGraphicalStyles(List<GraphicalStyles> graphicalStyles);
    T withSpecificPeople(String specificPeople);
    T withPrestigeContentOnly(boolean prestigeContentOnly);
    T withEventIds(String eventIds);
    T withLicenseModels(List<LicenseModel> licenseModels);
    CreativeImagesSearch creative();
    EditorialImagesSearch editorial();
}
