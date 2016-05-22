package com.leqcar.domain;


import org.springframework.http.MediaType;

/**
 * Created by jongtenerife on 22/05/2016.
 */
public class ProfilePhoto {

    private Long userId;
    private byte[] photo;
    private MediaType mediaType;

    public ProfilePhoto(Long userId, byte[] photo, MediaType mediaType) {
        this.userId = userId;
        this.photo = photo;
        this.mediaType = mediaType;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public MediaType getMediaType() {
        return mediaType;
    }

    public void setMediaType(MediaType mediaType) {
        this.mediaType = mediaType;
    }
}
