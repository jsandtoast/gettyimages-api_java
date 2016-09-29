package com.gettyimages.search;

import com.gettyimages.SdkException;

import java.util.List;

/**
 * Created by jsantos on 9/29/16.
 */
public interface ImagesSearch<T> {
    T withEthnicity(Ethnicity ethnicity);
    T withAgeOfPeople(List<AgeOfPeople> ageOfPeople);
    T withArtists(String artists);
    T withCollectionCodes(String collectionCodes);
    T withIncludeCollectionsFilterType(boolean includeCollectionsFilterType);
    T withColor(String color);
    T withCompositions(Compositions composition);
    T withEmbedContentOnly(boolean embedContentOnly);
    T withFileTypes(List<FileType> fileTypes);
    T withNumberOfPeople(List<NumberOfPeople> numberOfPeople);
    String executeAsync() throws SdkException;
    T withOrientations(List<Orientation> orientations);
}
