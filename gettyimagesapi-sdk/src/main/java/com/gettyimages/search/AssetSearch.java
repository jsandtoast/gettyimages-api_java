package com.gettyimages.search;

import com.gettyimages.Credentials;
import com.gettyimages.SdkException;

import java.util.Map;

public class AssetSearch<T extends IAssetSearch<T>> extends BaseSearchImages implements IAssetSearch<T> {

    public AssetSearch(Credentials credentials, String baseUrl, Map map) {
        super(credentials, baseUrl, map);
    }

    @Override
    public String ExecuteAsync() throws SdkException {
        return super.executeAsync();
    }

    @Override
    public T WithEditorialSegment(EditorialSegment val) {
        super.withEditorialSegment(val);
        return (T) this;
    }

    @Override
    public T WithPage(int val) {
        super.withPage(val);
        return (T) this;
    }

    @Override
    public T WithPageSize(int val) {
        super.withPageSize(val);
        return (T) this;
    }

    @Override
    public T WithPhrase(String val) {
        super.withPhrase(val);
        return (T) this;
    }

    @Override
    public T WithEmbedContentOnly(boolean val) {
        super.withEmbedContentOnly(val);
        return (T) this;
    }

    @Override
    public T WithSortOrder(String val) {
        super.withSortOrder(val);
        return (T) this;
    }

    @Override
    public T WithExcludeNudity(boolean val) {
        super.withExcludeNudity(val);
        return (T) this;
    }

    @Override
    public T WithResponseField(String val) {
        super.withResponseField(val);
        return (T) this;
    }

    @Override
    public T WithGraphicalStyle(GraphicalStyles val) {
        super.withGraphicalStyle(val);
        return (T) this;
    }

    @Override
    public T WithOrientation(Orientation val) {
        super.withOrientation(val);
        return (T) this;
    }

    @Override
    public T WithLicenseModel(LicenseModel val) {
        super.withLicenseModel(val);
        return (T) this;
    }

    @Override
    public T Creative() {
        super.creative();
        return (T) this;
    }

    @Override
    public T Editorial() {
        super.editorial();
        return (T) this;
    }
}
