package com.baskom.masakini.feedlist;

/**
 * Created by akmalmuhamad on 29/11/17.
 */

public class VideoFeed {
    private String judulVideo;
    private int videoImage;

    public VideoFeed(int videoImage, String judulVideo) {
        this.videoImage = videoImage;
        this.judulVideo = judulVideo;
    }

    public int getVideoImage() {
        return videoImage;
    }

    public void setVideoImage(int videoImage) {
        this.videoImage = videoImage;
    }

    public String getJudulVideo() {
        return judulVideo;
    }

    public void setJudulVideo(String judulVideo) {
        this.judulVideo = judulVideo;
    }
}
