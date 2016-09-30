package com.gettyimages.search;

import com.gettyimages.search.filters.EditorialSegment;
import com.gettyimages.search.filters.ProductType;

import java.util.List;

/**
 * Forces implementing classes to use method chaining.
 */
public interface IAssetSearch<T extends IAssetSearch<T>> {
    T withEditorialSegment(EditorialSegment val);

    T withPage(int val);

    T withPageSize(int val);

    T withPhrase(String val);

    T withSortOrder(String val);

    T withExcludeNudity(boolean val);

    T withResponseField(String val);

//    T withKeywordIds(String keywordIds);
//
//    T withProductTypes(List<ProductType> productTypes);
}
