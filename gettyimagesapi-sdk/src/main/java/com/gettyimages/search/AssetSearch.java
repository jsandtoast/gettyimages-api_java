package com.gettyimages.search;

import com.gettyimages.Credentials;
import com.gettyimages.SdkException;

import java.util.Map;

public abstract class AssetSearch<T extends IAssetSearch<T>> extends BaseSearchImages implements IAssetSearch<T> {

    public AssetSearch(Credentials credentials, String baseUrl, Map map) {
        super(credentials, baseUrl, map);
    }


    public String ExecuteAsync() throws SdkException {
        return super.executeAsync(null);
    }

    public T WithEditorialSegment(EditorialSegment val) {
        super.withEditorialSegment(val);
        return (T) this;
    }

    public T WithPage(int val) {
        super.withPage(val);
        return (T) this;
    }

    public T WithPageSize(int val) {
        super.withPageSize(val);
        return (T) this;
    }

    public T WithPhrase(String val) {
        super.withPhrase(val);
        return (T) this;
    }

    public T WithSortOrder(String val) {
        super.withSortOrder(val);
        return (T) this;
    }

    public T WithExcludeNudity(boolean val) {
        super.withExcludeNudity(val);
        return (T) this;
    }

    public T WithResponseField(String val) {
        super.withResponseField(val);
        return (T) this;
    }

    public T WithGraphicalStyle(GraphicalStyles val) {
        super.withGraphicalStyle(val);
        return (T) this;
    }

    public T WithOrientation(Orientation val) {
        super.withOrientation(val);
        return (T) this;
    }

    public T WithLicenseModel(LicenseModel val) {
        super.withLicenseModel(val);
        return (T) this;
    }

    public CreativeImagesSearch Creative() {
        super.creative();
        return new CreativeImagesSearch(credentials, baseUrl, map);
    }

    public EditorialImagesSearch Editorial() {
        super.editorial();
        return new EditorialImagesSearch(credentials, baseUrl, map);
    }
}
