package com.baskom.masakini.model;

import java.io.Serializable;

/**
 * Created by akmalmuhamad on 29/11/17.
 */

public class Video implements Serializable {
    private String judulVideo;
    private String videoThumbnail;
    private String videoURL;

    public Video(String judulVideo, String videoThumbnail, String videoURL) {
        this.judulVideo = judulVideo;
        this.videoThumbnail = videoThumbnail;
        this.videoURL = videoURL;
    }

    public String getJudulVideo() {

        return judulVideo;
    }

    public void setJudulVideo(String judulVideo) {
        this.judulVideo = judulVideo;
    }

    public String getVideoThumbnail() {
        return videoThumbnail;
    }

    public void setVideoThumbnail(String videoThumbnail) {
        this.videoThumbnail = videoThumbnail;
    }

    public String getVideoURL() {
        return videoURL;
    }

    public void setVideoURL(String videoURL) {
        this.videoURL = videoURL;
    }
}