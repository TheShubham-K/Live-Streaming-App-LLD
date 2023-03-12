package org.example;

public class VideoConsumingService {

    private Database database;
    public int  seekTime(String userId, String videoId) {
        WatchedVideo watchedVideo = database.getWatchedVideo(userId, videoId);
        return watchedVideo.getSeekTime();
    }
}

class VideoService {

    private FileSystem filesystem;
    public Frame getFrame(String videoId, int timeStamp) {
        Video video = filesystem.getVideo(videoId);
        return video.getFrame(timeStamp);

    }
}

class FileSystem {

    public Video getVideo(String videoId) {
        return null;
    }
}

class Database {

    public WatchedVideo getWatchedVideo(String userId, String videoId) {
        if(userId != null && videoId != null) {
            Frame[] frames = FetchVideo.getVideo(videoId);
        }
        return null;
    }
}

class FetchVideo {

    public static Frame[] getVideo(String videoId) {
        return null;
    }
}

class Video {

    String id;
    Frame[] frames;
    String jsonMetaData;

    public Frame getFrame(int timestamp) {
        for (int i = 0; i < frames.length; i++) {
            if (frames[i].startTimestamp <= timestamp &&
             frames[i].endTimeStamp+ Frame.frameTime > timestamp) {
                return frames[i];
            }
        }
        throw new IndexOutOfBoundsException();
    }
}

class Frame {

    public static int frameTime = 10;
    byte[] bytes;
    int startTimestamp;
    int endTimeStamp;
}

class User {
    String id;
    String name;
    String email;

    public String getId() {
        return id;
    }
}

class WatchedVideo {
    String id;
    String videoId;
    String userId;
    int seekTime;

    public int getSeekTime() {
        return seekTime;
    }
}