package com.gettyimages.search;

import com.gettyimages.search.filters.GraphicalStyles;
import com.gettyimages.search.filters.LicenseModel;

import java.util.List;

/**
 * Created by jsantos on 9/29/16.
 */
public interface CreativeImagesSearch<T> {
    T withGraphicalStyles(List<GraphicalStyles> graphicalStyles);
    T withLicenseModels(List<LicenseModel> licenseModels);
    T withPrestigeContentOnly(boolean prestigeContentOnly);
}
