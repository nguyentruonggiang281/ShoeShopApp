package com.example.appbangiaycomplete;

public class Image {
    private byte[] imageResource;

    public Image(byte[] imageResource) {
        this.imageResource = imageResource;
    }

    public byte[] getImageResource() {
        return imageResource;
    }

    public void setImageResource(byte[] imageResource) {
        this.imageResource = imageResource;
    }
}
