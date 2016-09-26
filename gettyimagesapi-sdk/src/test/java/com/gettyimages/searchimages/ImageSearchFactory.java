package com.gettyimages.searchimages;

import com.gettyimages.SharedContext;
import com.gettyimages.search.*;

/**
 * Created by jsantos on 9/23/16.
 */
public class ImageSearchFactory {

    private ImageSearchFactory(){}

    private static class ImageSearchFactoryHelper {
        private static final ImageSearchFactory INSTANCE = new ImageSearchFactory();
    }

    public static ImageSearchFactory getInstance() {
        return ImageSearchFactoryHelper.INSTANCE;
    }

    public ImagesSearch createImageSearchController(String imageFamily) {
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
