package com.gettyimages.search;

import com.gettyimages.Credentials;
import com.gettyimages.SdkException;
import com.gettyimages.search.filters.Ethnicity;

import java.util.HashMap;
import java.util.Map;

public class ImagesSearchService extends AssetSearch<ImagesSearchService> implements ImagesSearch<ImagesSearchService> {
    private static final String CompositionsParameterName = "compositions";
    private static final String EmbedContentOnlyParameterName = "embed_content_only";
    private static final String ColorParameterName = "color";
    private static final String EthnicityParameterName = "ethnicity";

    public ImagesSearchService(Credentials credentials, String baseUrl, Map map) {
        super(credentials, baseUrl, map);
    }

    @Override
    public ImagesSearchService withEthnicity(Ethnicity ethnicity) {
        map.put(EthnicityParameterName, ethnicity);
        return this;
    }

    @Override
    public ImagesSearchService withColor(String color) {
        map.put(ColorParameterName, color);
        return this;
    }

    @Override
    public ImagesSearchService withEmbedContentOnly(boolean embedContentOnly) {
        map.put(EmbedContentOnlyParameterName, embedContentOnly);
        return this;
    }

    @Override
    public String executeAsync() throws SdkException {
        Map<String, String> queryParams = new HashMap<String, String>();

        return this.executeAsync(queryParams);
    }
}
