package com.gettyimages.downloadimages;

import com.gettyimages.Download;
import com.gettyimages.SdkException;
import com.gettyimages.SharedContext;
import com.gettyimages.StringHelper;
import org.json.JSONObject;

import static org.junit.Assert.fail;

/**
 * Created by jsantos on 10/18/16.
 */
public class Context {

    private Context(){}
    private Download download;
    private JSONObject downloadResult;
    private String sharedAssetId;

    public String getAssetId() {
        if (StringHelper.isNullOrEmpty(sharedAssetId)) {
            try {
                String result = SharedContext.GetApiClientWithResourceOwnerCredentials()
                        .search()
                        .images()
                        .withPhrase("dog")
                        .executeAsync();
                downloadResult = new JSONObject(result);
                sharedAssetId = downloadResult.getJSONArray("images").getJSONObject(0).getString("id");
            } catch (SdkException e) {
                fail("download is supposed to successfully execute, but instead received: " + e.getLocalizedMessage());
            }
        }
        return sharedAssetId;
    }

    private static class ContextHelper {
        private static final Context INSTANCE = new Context();
    }

    public static Context getInstance() {
        return ContextHelper.INSTANCE;
    }

    public void downloadImage() {
        setupDownloadCall();
        String assetId = getAssetId();
        download.WithId(assetId);
        try {
            String result = download.executeAsync();
            downloadResult = new JSONObject(result);
        } catch (SdkException e) {
            fail("download is supposed to successfully execute, but instead received: " + e.getLocalizedMessage());
        }
    }

    public JSONObject getDownloadResult() {
        return downloadResult;
    }

    private void setupDownloadCall() {
        if (download == null) {
            download = SharedContext.GetApiClientWithResourceOwnerCredentials()
                            .Download();
        }
    }
}
