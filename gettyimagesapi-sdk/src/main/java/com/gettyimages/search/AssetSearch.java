package com.gettyimages.search;

import com.gettyimages.Credentials;
import com.gettyimages.SdkException;
import com.gettyimages.StringHelper;
import com.gettyimages.WebHelper;

import java.util.*;

public abstract class AssetSearch<T extends IAssetSearch<T>>  implements IAssetSearch<T> {

    protected String V3SearchImagesPath = "/search/images";
    private String SpaceString = " ";
    private String FieldsString = "fields";
    protected String GraphicalStylesString = "graphical_styles";
    private String EditorialSegmentsString = "editorial_segments";
    private String LicenseModelsString = "license_models";
    private String OrientationsString = "orientations";
    private String PageString = "page";
    private String PageSizeString = "page_size";
    private String PhraseString = "phrase";
    private String SortOrderString = "sort_order";
    private String ExcludeNudityString = "exclude_nudity";
    protected String AssetTypeString = "asset_type";

    protected String baseUrl;
    protected Credentials credentials;
    protected Map map;

    public AssetSearch(Credentials credentials, String baseUrl, Map map) {
        this.credentials = credentials;
        this.baseUrl = baseUrl;
        this.map = map;
    }

    protected String getAssetType() {
        return getString(AssetTypeString);
    }

    protected int getPage() {
        return getInt(PageString);
    }

    protected int getPageSize() {
        return getInt(PageSizeString);
    }

    protected String getPhrase() {
        return getString(PhraseString);
    }

    protected String getSortOrder() {
        return getString(SortOrderString);
    }

    protected List<String> getResponseFields() {
        if (!map.containsKey(FieldsString)) {
            return null;
        }

        return (List<String>) map.get(FieldsString);
    }

    protected EnumSet<GraphicalStyles> getGraphicalStyles() {
        if (!map.containsKey(GraphicalStylesString)) {
            return EnumSet.noneOf(GraphicalStyles.class);
        }

        return (EnumSet<GraphicalStyles>) map.get(GraphicalStylesString);
    }

    protected EnumSet<EditorialSegment> getEditorialSegments() {
        if (!map.containsKey(EditorialSegmentsString)) {
            return EnumSet.noneOf(EditorialSegment.class);
        }

        return (EnumSet<EditorialSegment>) map.get(EditorialSegmentsString);
    }

    protected EnumSet<LicenseModel> getLicenseModels() {
        if (!map.containsKey(LicenseModelsString)) {
            return EnumSet.noneOf(LicenseModel.class);
        }

        return (EnumSet<LicenseModel>) map.get(LicenseModelsString);
    }

    protected EnumSet<Orientation> getOrientations() {
        if (!map.containsKey(OrientationsString)) {
            return EnumSet.noneOf(Orientation.class);
        }

        return (EnumSet<Orientation>) map.get(OrientationsString);
    }

    protected boolean getExcludeNudity() {
        return getBooleanValue(ExcludeNudityString);
    }

    protected String getString(String key)
    {
        if (!map.containsKey(key))
        {
            return null;
        }

        return (String) map.get(key);
    }

    protected int getInt(String key) {
        if (!map.containsKey(key)) {
            return 0;
        }

        return Integer.parseInt(map.get(key).toString());
    }

    protected boolean getBooleanValue(String key) {
        if (!map.containsKey(key)) {
            return false;
        }

        Object obj = map.get(key);
        String str = obj.toString();
        return Boolean.parseBoolean(str);
    }

    protected String executeAsync(Map<String, String> queryParams) throws SdkException {
        String path;

        String assetType = getAssetType();
        if (assetType == null || assetType.length() == 0) {
            path = V3SearchImagesPath;
        } else {
            path = V3SearchImagesPath + "/" + assetType;
        }

        if (queryParams == null) {
            queryParams = new Hashtable<>();
        }

        if (getResponseFields() != null) {
            StringBuilder sb = new StringBuilder();
            boolean first = true;
            for (String item : getResponseFields()) {
                if (first)
                    first = false;
                else
                    sb.append(",");
                sb.append(item);
            }
            queryParams.put(FieldsString, sb.toString());
        }
        if (!getGraphicalStyles().isEmpty()) {
            StringBuilder sb = new StringBuilder();
            boolean first = true;
            for (GraphicalStyles item : getGraphicalStyles()) {
                if (first)
                    first = false;
                else
                    sb.append(",");
                sb.append(item);
            }
            queryParams.put(GraphicalStylesString, sb.toString());
        }
        if (!getEditorialSegments().isEmpty()) {
            StringBuilder sb = new StringBuilder();
            boolean first = true;
            for (EditorialSegment item : getEditorialSegments()) {
                if (first)
                    first = false;
                else
                    sb.append(",");
                sb.append(item);
            }
            queryParams.put(EditorialSegmentsString, sb.toString());
        }
        if (!getLicenseModels().isEmpty()) {
            StringBuilder sb = new StringBuilder();
            boolean first = true;
            for (LicenseModel item : getLicenseModels()) {
                if (first)
                    first = false;
                else
                    sb.append(",");
                sb.append(item);
            }
            queryParams.put(LicenseModelsString, sb.toString());
        }
        if (!getOrientations().isEmpty()) {
            StringBuilder sb = new StringBuilder();
            boolean first = true;
            for (Orientation item : getOrientations()) {
                if (first)
                    first = false;
                else
                    sb.append(",");
                sb.append(item);
            }
            queryParams.put(OrientationsString, sb.toString());
        }
        if (getPage() > 0) {
            queryParams.put(PageString, String.valueOf(getPage()));
        }
        if (getPageSize() > 0) {
            queryParams.put(PageSizeString, String.valueOf(getPageSize()));
        }
        if (!StringHelper.isNullOrWhitespace(getPhrase())) {
            queryParams.put(PhraseString, getPhrase());
        }
        if (!StringHelper.isNullOrEmpty(getSortOrder())) {
            queryParams.put(SortOrderString, getSortOrder());
        }
        if (getExcludeNudity()) {
            queryParams.put(ExcludeNudityString, String.valueOf(getExcludeNudity()));
        }

        WebHelper helper = new WebHelper(credentials, baseUrl);
        return helper.Get(queryParams, path);
    }

    public T withPage(int val) {
        map.put(PageString, val);
        return (T) this;
    }

    public T withPageSize(int val) {
        map.put(PageSizeString, val);
        return (T) this;
    }

    public T withPhrase(String val) {
        map.put(PhraseString, val);
        return (T) this;
    }

    public T withSortOrder(String val) {
        map.put(SortOrderString, val);
        return (T) this;
    }

    public T withExcludeNudity(boolean val) {
        map.put(ExcludeNudityString, val);
        return (T) this;
    }

    public T withResponseField(String val) {
        List<String> fields;

        if (map.containsKey(FieldsString)) {
            fields = (List<String>) map.get(FieldsString);
        } else {
            fields = new ArrayList<String>();
        }
        fields.add(val);

        map.put(FieldsString, fields);
        return (T) this;
    }

    protected void withOrientation(Orientation val) {
        EnumSet<Orientation> orientations;

        if (map.containsKey(OrientationsString)) {
            orientations = (EnumSet<Orientation>) map.get(OrientationsString);
        } else {
            orientations = EnumSet.noneOf(Orientation.class);
        }
        if (val != Orientation.None) {
            orientations.add(val);
        }

        map.put(OrientationsString, orientations);
    }

    public T withEditorialSegment(EditorialSegment seg) {
        EnumSet<EditorialSegment> segments;

        if (map.containsKey(EditorialSegmentsString)) {
            segments = (EnumSet<EditorialSegment>) map.get(EditorialSegmentsString);
        } else {
            segments = EnumSet.noneOf(EditorialSegment.class);
        }
        if (seg != EditorialSegment.None) {
            segments.add(seg);
        }

        map.put(EditorialSegmentsString, segments);
        return (T) this;
    }

    protected void withLicenseModel(LicenseModel val) {
        EnumSet<LicenseModel> licenseModels;

        if (map.containsKey(LicenseModelsString)) {
            licenseModels = (EnumSet<LicenseModel>) map.get(LicenseModelsString);
        } else {
            licenseModels = EnumSet.noneOf(LicenseModel.class);
        }
        if (val != LicenseModel.None) {
            licenseModels.add(val);
        }
        map.put(LicenseModelsString, licenseModels);
    }
}
