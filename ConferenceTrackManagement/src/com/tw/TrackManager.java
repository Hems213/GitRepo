package com.tw;

import java.util.ArrayList;

public class TrackManager {

	private int morningMins;
	private int eveningMins;
	
	public TrackManager(int morningMins, int eveningMins) {
		this.morningMins = morningMins;
		this.eveningMins = eveningMins;
		
	}

	public boolean fitaTalk(ArrayList<Track> tracks, Talk tk) {

		// For every talk, it checks all the tracks and sessions for fitment. If
		// it does not fit in,
		// then it creates a new track and adds it.
		for (Track trk : tracks) {
			if (trk.getMorning().checkAddablity(tk)) {
				trk.getMorning().addTalk(tk);
				return true;
			}
			if (trk.getEvening().checkAddablity(tk)) {
				trk.getEvening().addTalk(tk);
				return true;
			}
		}

		// If the talk does not fit in the existing, create a new track and add
		// the talk to its first session manually and then add the track to
		// tracks
		// It is sufficient to do the adding directly in morning session as this
		// is a freshly created track and all other tracks dont have space to
		// hold this talk.
		Track trk = new Track(morningMins, eveningMins);
		if (trk.getMorning().checkAddablity(tk)) {
			trk.getMorning().addTalk(tk);
			tracks.add(trk);
			return true;
		}

		return false;
	}

	public Track createTrack() {
		return new Track(morningMins, eveningMins);
	}

}
