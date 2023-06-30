package com.example.GoogleJoggingApp;

import java.util.ArrayList;
import java.util.List;


/*
        #.HW08
        PlaceDetails.java
        Sachin Kumar and Arundhati Mishra
*/
public class PlaceDetails {
    private List<Object> htmlAttributions = new ArrayList<Object>();
    private Result result;
    private String status;
    public List<Object> getHtmlAttributions() {
        return htmlAttributions;
    }
    public void setHtmlAttributions(List<Object> htmlAttributions) {
        this.htmlAttributions = htmlAttributions;
    }
    public Result getResult() {
        return result;
    }
    public void setResult(Result result) {
        this.result = result;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
}
 class AddressComponent {
    private String longName;
    private String shortName;
    private List<String> types = new ArrayList<String>();
    public String getLongName() {
        return longName;
    }
    public void setLongName(String longName) {
        this.longName = longName;
    }
    public String getShortName() {
        return shortName;
    }
    public void setShortName(String shortName) {
        this.shortName = shortName;
    }
    public List<String> getTypes() {
        return types;
    }
    public void setTypes(List<String> types) {
        this.types = types;
    }
}
 class Geometry {
    private Location location;
    private Viewport viewport;
    public Location getLocation() {
        return location;
    }
    public void setLocation(Location location) {
        this.location = location;
    }
    public Viewport getViewport() {
        return viewport;
    }
    public void setViewport(Viewport viewport) {
        this.viewport = viewport;
    }
}

 class Location {
    private Double lat;
    private Double lng;
    public Double getLat() {
        return lat;
    }
    public void setLat(Double lat) {
        this.lat = lat;
    }
    public Double getLng() {
        return lng;
    }
    public void setLng(Double lng) {
        this.lng = lng;
    }
}

 class Northeast {
    private Double lat;
    private Double lng;
    public Double getLat() {
        return lat;
    }
    public void setLat(Double lat) {
        this.lat = lat;
    }
    public Double getLng() {
        return lng;
    }
    public void setLng(Double lng) {
        this.lng = lng;
    }
}
 class PlusCode {
    private String compoundCode;
    private String globalCode;
    public String getCompoundCode() {
        return compoundCode;
    }
    public void setCompoundCode(String compoundCode) {
        this.compoundCode = compoundCode;
    }
    public String getGlobalCode() {
        return globalCode;
    }
    public void setGlobalCode(String globalCode) {
        this.globalCode = globalCode;
    }
}

 class Result {
    private List<AddressComponent> addressComponents = new ArrayList<AddressComponent>();
    private String adrAddress;
    private String formattedAddress;
    private Geometry geometry;
    private String icon;
    private String iconBackgroundColor;
    private String iconMaskBaseUri;
    private String name;
    private String placeId;
    private PlusCode plusCode;
    private String reference;
    private List<String> types = new ArrayList<String>();
    private String url;
    private Integer utcOffset;
    private String vicinity;
    public List<AddressComponent> getAddressComponents() {
        return addressComponents;
    }
    public void setAddressComponents(List<AddressComponent> addressComponents) {
        this.addressComponents = addressComponents;
    }
    public String getAdrAddress() {
        return adrAddress;
    }
    public void setAdrAddress(String adrAddress) {
        this.adrAddress = adrAddress;
    }
    public String getFormattedAddress() {
        return formattedAddress;
    }
    public void setFormattedAddress(String formattedAddress) {
        this.formattedAddress = formattedAddress;
    }
    public Geometry getGeometry() {
        return geometry;
    }
    public void setGeometry(Geometry geometry) {
        this.geometry = geometry;
    }
    public String getIcon() {
        return icon;
    }
    public void setIcon(String icon) {
        this.icon = icon;
    }
    public String getIconBackgroundColor() {
        return iconBackgroundColor;
    }
    public void setIconBackgroundColor(String iconBackgroundColor) {
        this.iconBackgroundColor = iconBackgroundColor;
    }
    public String getIconMaskBaseUri() {
        return iconMaskBaseUri;
    }
    public void setIconMaskBaseUri(String iconMaskBaseUri) {
        this.iconMaskBaseUri = iconMaskBaseUri;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPlaceId() {
        return placeId;
    }
    public void setPlaceId(String placeId) {
        this.placeId = placeId;
    }
    public PlusCode getPlusCode() {
        return plusCode;
    }
    public void setPlusCode(PlusCode plusCode) {
        this.plusCode = plusCode;
    }
    public String getReference() {
        return reference;
    }
    public void setReference(String reference) {
        this.reference = reference;
    }
    public List<String> getTypes() {
        return types;
    }
    public void setTypes(List<String> types) {
        this.types = types;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public Integer getUtcOffset() {
        return utcOffset;
    }
    public void setUtcOffset(Integer utcOffset) {
        this.utcOffset = utcOffset;
    }
    public String getVicinity() {
        return vicinity;
    }
    public void setVicinity(String vicinity) {
        this.vicinity = vicinity;
    }
}
 class Southwest {
    private Double lat;
    private Double lng;
    public Double getLat() {
        return lat;
    }
    public void setLat(Double lat) {
        this.lat = lat;
    }
    public Double getLng() {
        return lng;
    }
    public void setLng(Double lng) {
        this.lng = lng;
    }
}

 class Viewport {
    private Northeast northeast;
    private Southwest southwest;
    public Northeast getNortheast() {
        return northeast;
    }
    public void setNortheast(Northeast northeast) {
        this.northeast = northeast;
    }
    public Southwest getSouthwest() {
        return southwest;
    }
    public void setSouthwest(Southwest southwest) {
        this.southwest = southwest;
    }
}
