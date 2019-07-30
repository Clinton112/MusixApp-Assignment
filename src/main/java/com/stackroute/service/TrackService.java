package com.stackroute.service;

import com.stackroute.domain.Track;
import com.stackroute.exceptions.TrackAlreadyExistsException;
import com.stackroute.exceptions.TrackNotFoundException;

import java.util.List;

public interface TrackService {
    public Track saveTrack(Track track) throws TrackAlreadyExistsException;
    public List<Track> showAllTracks();
    public Track updateComment(int trackId,String trackComment);
    public void deleteTrack(Track track) throws TrackNotFoundException;
    public List<Track> getTrackByName(String trackName);
    public Track getTrackById(int trackId);
    List<Track> getTrackByNameSortByName(String trackName);
}
