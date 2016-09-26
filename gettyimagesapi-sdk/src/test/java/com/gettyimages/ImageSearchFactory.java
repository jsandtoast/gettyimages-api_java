package com.gettyimages;

import com.gettyimages.search.*;

/**
 * Created by jsantos on 9/23/16.
 */
public class ImageSearchFactory {
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
            default:
                throw new IllegalArgumentException("Invalid image family: " + imageFamily);
        }
    }
}
