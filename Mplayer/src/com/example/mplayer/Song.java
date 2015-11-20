package com.example.mplayer;

public class Song {
	private long  songId;
	private String songName;
	private String songArtist;
	
	public Song(long songId,String name,String artist){
		this.setSongArtist(artist);
		this.setSongId(songId);
		this.setSongName(name);
	}

	public long getSongId() {
		return songId;
	}

	public void setSongId(long songId) {
		this.songId = songId;
	}

	public String getSongName() {
		return songName;
	}

	public void setSongName(String songName) {
		this.songName = songName;
	}

	public String getSongArtist() {
		return songArtist;
	}

	public void setSongArtist(String songArtist) {
		this.songArtist = songArtist;
	}
	
	
}
