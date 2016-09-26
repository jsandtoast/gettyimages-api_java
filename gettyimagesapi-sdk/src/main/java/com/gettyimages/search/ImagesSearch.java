package com.gettyimages.search;

import com.gettyimages.Credentials;

import java.util.Hashtable;
import java.util.Map;

public class ImagesSearch extends AssetSearch<ImagesSearch> {
    public ImagesSearch(Credentials credentials, String baseUrl, Map map) {
        super(credentials, baseUrl, map);
    }

    public static ImagesSearch GetInstance(Credentials credentials, String baseUrl) {
        return new ImagesSearch(credentials, baseUrl, new Hashtable());
    }
}
