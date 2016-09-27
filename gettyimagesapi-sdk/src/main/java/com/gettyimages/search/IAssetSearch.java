package com.gettyimages.search;

import com.gettyimages.SdkException;

/**
 * Forces implementing classes to use method chaining.
 */
public interface IAssetSearch<T extends IAssetSearch<T>> {
    String ExecuteAsync() throws SdkException;

    T WithEditorialSegment(EditorialSegment val);

    T WithPage(int val);

    T WithPageSize(int val);

    T WithPhrase(String val);

    T WithSortOrder(String val);

    T WithExcludeNudity(boolean val);

    T WithResponseField(String val);

    T WithGraphicalStyle(GraphicalStyles val);

    T WithOrientation(Orientation val);

    T WithLicenseModel(LicenseModel val);

    CreativeImagesSearch Creative();

    EditorialImagesSearch Editorial();
}
