package com.example.saavanapp;

public class CardIcon {

    private String albumName;
    private String songName;
    private Integer imageId;

    CardIcon(String album, String song, Integer image){
        albumName = album;
        songName = song;
        imageId = image;
    }

    public String getAlbumName() {
        return albumName;
    }

    public String getSongName() {
        return songName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public Integer getImageId(){
        return imageId;
    }
}
