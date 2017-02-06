package com.example.android.tourguide;

/**
 * Created by phil.walker on 2/4/17.
 */

public class Site {
    private String mName;
    private String mPhone;
    private String mDescription;
    private String mAddress;
    private int mImageResourceId = NO_IMAGE_RESOURCE_PROVIDED;
    private static final int NO_IMAGE_RESOURCE_PROVIDED = -1;

    public Site(String name, String phone, String address, String description){
        mName = name;
        mPhone = phone;
        mDescription = description;
        mAddress = address;
    }

    public Site(String name, String phone, String address, String description, int imageResourceId){
        mName = name;
        mPhone = phone;
        mDescription = description;
        mAddress = address;
        mImageResourceId = imageResourceId;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmPhone() {
        return mPhone;
    }

    public void setmPhone(String mPhone) {
        this.mPhone = mPhone;
    }

    public String getmDescription() {
        return mDescription;
    }

    public void setmDescription(String mDescription) {
        this.mDescription = mDescription;
    }

    public String getmAddress() {
        return mAddress;
    }

    public void setmAddress(String mAddress) {
        this.mAddress = mAddress;
    }

    public int getmImageResourceId(){
        return mImageResourceId;
    }

    public boolean hasImage(){
        return mImageResourceId != NO_IMAGE_RESOURCE_PROVIDED;
    }
}
