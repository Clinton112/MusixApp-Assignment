package com.stackroute.service;

import com.stackroute.domain.Track;
import com.stackroute.exceptions.TrackAlreadyExistsException;
import com.stackroute.exceptions.TrackNotFoundException;
import com.stackroute.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TrackServiceImpl implements TrackService {

    TrackRepository trackRepository;

    @Autowired
    public TrackServiceImpl(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

    @Override
    public Track saveTrack(Track track) throws TrackAlreadyExistsException {

        if(trackRepository.existsById(track.getTrackID())) {
            throw new TrackAlreadyExistsException("Track Already Exists");
        }
        Track savedTrack = trackRepository.save(track);

        if(savedTrack == null) {
            throw new TrackAlreadyExistsException("Track Already Exists");
        }
        return savedTrack;
    }

    @Override
    public List<Track> showAllTracks() {
        return (List<Track>) trackRepository.findAll();
    }

    @Override
    public Track updateComment(int trackId, String trackComment) {
        Optional<Track> track = trackRepository.findById(trackId);
        Track track1 = track.get();
        track1.setComments(trackComment);
        Track savedTrack = trackRepository.save(track1);
        return savedTrack;
    }

    @Override
    public void deleteTrack(Track track) throws TrackNotFoundException {
        if(!trackRepository.existsById(track.getTrackID())) {
            throw new TrackNotFoundException("No track found with given ID");
        }

        trackRepository.delete(getTrackById(track.getTrackID()));
    }

    @Override
    public List<Track> getTrackByName(String trackName) {
        return trackRepository.getTrackByName(trackName);
    }



    @Override
    public Track getTrackById(int id) {

        Track track = trackRepository.findById(id).get();
        return track;

    }

    @Override
    public List<Track> getTrackByNameSortByName(String trackName) {
        return trackRepository.getTrackByName(trackName);
    }



}