package com.gettyimages.search;

import com.gettyimages.Credentials;
import com.gettyimages.SdkException;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jsantos on 9/29/16.
 */
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
    public ImagesSearchService withAgeOfPeople(List<AgeOfPeople> ageOfPeople) {
        return null;
    }

    @Override
    public ImagesSearchService withArtists(String artists) {
        return null;
    }

    @Override
    public ImagesSearchService withCollectionCodes(String collectionCodes) {
        return null;
    }

    @Override
    public ImagesSearchService withIncludeCollectionsFilterType(boolean includeCollectionsFilterType) {
        return null;
    }

    @Override
    public ImagesSearchService withColor(String color) {
        map.put(ColorParameterName, color);
        return this;
    }

    @Override
    public ImagesSearchService withCompositions(Compositions composition) {
        EnumSet<Compositions> compositions;
        if (map.containsKey(CompositionsParameterName)) {
            compositions = (EnumSet<Compositions>) map.get(CompositionsParameterName);
        } else {
            compositions = EnumSet.noneOf(Compositions.class);
        }
        if (composition != Compositions.NONE) {
            compositions.add(composition);
        }

        map.put(CompositionsParameterName, compositions); // todo can I just do map.put(CompositionsParameterName, composition); instead?
        return this;
    }

    @Override
    public ImagesSearchService withEmbedContentOnly(boolean embedContentOnly) {
        map.put(EmbedContentOnlyParameterName, embedContentOnly);
        return this;
    }

    @Override
    public ImagesSearchService withFileTypes(List<FileType> fileTypes) {
        return null;
    }

    @Override
    public ImagesSearchService withNumberOfPeople(List<NumberOfPeople> numberOfPeople) {
        return null;
    }

    @Override
    public String executeAsync() throws SdkException {
        Map<String, String> queryParams = new HashMap<String, String>();

        return this.executeAsync(queryParams);
    }

    @Override
    public ImagesSearchService withOrientations(List<Orientation> orientations) {
        return null;
    }

    @Override
    public ImagesSearchService withKeywordIds(String keywordIds) {
        return null;
    }

    @Override
    public ImagesSearchService withProductTypes(List<ProductType> productTypes) {
        return null;
    }

    private Boolean getEmbedContentOnly() {
        return (Boolean) map.get(EmbedContentOnlyParameterName);
    }
}
