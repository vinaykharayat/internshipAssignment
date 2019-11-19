package com.androboot.heyhungryinternship3;

public class upload {
    private String mName;
    private String mUrl;
    public upload(){

    }

    public upload(String name, String url){
        if(name.trim().equals("")){
            name="No name";
        }
        mName=name;
        mUrl=url;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmUrl() {
        return mUrl;
    }

    public void setmUrl(String mUrl) {
        this.mUrl = mUrl;
    }
}
