package com.gettyimages.searchimages;

import com.gettyimages.SharedContext;
import com.gettyimages.search.ImagesSearch;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Context class for search images scenarios
 */
public class Context {

    private ImagesSearch imagesSearch;
    private JSONObject searchResult;
    private long resultCount;
    private JSONArray resultImages;
    private Context(){}

    private static class ContextHelper {
        private static final Context INSTANCE = new Context();
    }

    public static Context getInstance() {
        return ContextHelper.INSTANCE;
    }

    public ImagesSearch getImagesSearch() {
        return imagesSearch;
    }

    public void setImagesSearch(String imageFamily) {
        this.imagesSearch = createImageSearchController(imageFamily);
    }

    public JSONObject getSearchResult() {
        return searchResult;
    }

    public void setSearchResult(JSONObject searchResult) {
        this.searchResult = searchResult;
    }

    public long getResultCount() {
        return resultCount;
    }

    public void setResultCount(long resultCount) {
        this.resultCount = resultCount;
    }

    public JSONArray getResultImages() {
        return resultImages;
    }

    public void setResultImages(JSONArray resultImages) {
        this.resultImages = resultImages;
    }

    private ImagesSearch createImageSearchController(String imageFamily) {
        switch (imageFamily.toLowerCase()) {
            case "creative" : {
                return SharedContext.GetApiClientWithResourceOwnerCredentials()
                        .Search()
                        .Images()
                        .Creative();
            }
            case "editorial" : {
                return SharedContext.GetApiClientWithResourceOwnerCredentials()
                        .Search()
                        .Images()
                        .Editorial();
            }
            case "blended" : {
                return SharedContext.GetApiClientWithResourceOwnerCredentials()
                        .Search()
                        .Images();
            }
            default:
                throw new IllegalArgumentException("Invalid image family: " + imageFamily);
        }
    }
}
