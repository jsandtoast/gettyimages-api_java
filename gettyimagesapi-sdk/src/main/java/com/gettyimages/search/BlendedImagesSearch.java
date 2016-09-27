package com.gettyimages.search;

import com.gettyimages.Credentials;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class BlendedImagesSearch extends AssetSearch<BlendedImagesSearch> {
    private static final String ColorParameterName = "color";
    private static final String CompositionsParameterName = "compositions";
    private static final String EmbedContentOnlyParameterName = "embed_content_only";
    private static final String EthnicityParameterName = "ethnicity";

    public BlendedImagesSearch(Credentials credentials, String baseUrl, Map map) {
        super(credentials, baseUrl, map);
    }

    public static BlendedImagesSearch GetInstance(Credentials credentials, String baseUrl) {
        return new BlendedImagesSearch(credentials, baseUrl, new Hashtable());
    }

    public BlendedImagesSearch withColor(String color) {
        map.put(ColorParameterName, color);
        return this;
    }

    public BlendedImagesSearch withCompositions(Compositions composition) {

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

    public BlendedImagesSearch withEmbedContentOnly(boolean val) {
        map.put(EmbedContentOnlyParameterName, val);
        return this;
    }

    public BlendedImagesSearch executeAsync() {
        Map<String, String> queryParams = new HashMap<String, String>();

        if (getEmbedContentOnly()) {
            queryParams.put(EmbedContentOnlyParameterName, String.valueOf(getEmbedContentOnly()));
        }
        return this;
    }

    public BlendedImagesSearch withEthnicity(Ethnicity ethnicity) {
        map.put(EthnicityParameterName, ethnicity);
        return this;
    }

    //TODO add the rest.

    private boolean getEmbedContentOnly() {
        return getBooleanValue(map.get(EmbedContentOnlyParameterName).toString());
    }
}
