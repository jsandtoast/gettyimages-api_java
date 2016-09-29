package com.gettyimages.search;

import java.util.List;

/**
 * Created by jsantos on 9/29/16.
 */
public interface CreativeImagesSearch<T> {
    T withGraphicalStyles(List<GraphicalStyles> graphicalStyles);
    T withLicenseModels(List<LicenseModel> licenseModels);
    T withPrestigeContentOnly(boolean prestigeContentOnly);
}
