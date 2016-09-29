package com.gettyimages.search;

import com.gettyimages.Credentials;

import java.util.*;

public class BlendedImagesSearchService extends ImagesSearchService implements BlendedImagesSearch<BlendedImagesSearch>{

    public BlendedImagesSearchService(Credentials credentials, String baseUrl, Map map) {
        super(credentials, baseUrl, map);
    }

    public static BlendedImagesSearchService GetInstance(Credentials credentials, String baseUrl) {
        return new BlendedImagesSearchService(credentials, baseUrl, new Hashtable());
    }

    @Override
    public BlendedImagesSearch withGraphicalStyles(List<GraphicalStyles> graphicalStyles) {
//        EnumSet<GraphicalStyles> graphicalStylesForRequest;
//
//        if (map.containsKey(GraphicalStylesString)) {
//            graphicalStylesForRequest = (EnumSet<GraphicalStyles>) map.get(GraphicalStylesString);
//        } else {
//            graphicalStylesForRequest = EnumSet.noneOf(GraphicalStyles.class);
//        }
//        if (graphicalStyles != GraphicalStyles.None) {
//            graphicalStyles.add(graphicalStyles);
//        }
//
        map.put(GraphicalStylesString, graphicalStyles); //TODO revisit this
        return this;
    }

    @Override
    public BlendedImagesSearch withSpecificPeople(String specificPeople) {
        return null;
    }

    @Override
    public BlendedImagesSearch withPrestigeContentOnly(boolean prestigeContentOnly) {
        return null;
    }

    @Override
    public BlendedImagesSearch withEventIds(String eventIds) {
        return null;
    }

    @Override
    public BlendedImagesSearch withLicenseModels(List<LicenseModel> licenseModels) {
        return null;
    }
}
