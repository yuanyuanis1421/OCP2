package com.opji.others.URL;

public class MediaTournamentVO {
	private TournamentVO tournamentVO;
	private String pointsPerGame;
	private String reboundsPerGame;
	private String FTS;
	private String FT2;
	private String FT3;
	private String FT;
	private String assistsPerGame;
	private String blocksPerGame;
	private String stealsPerGame;
	
	public MediaTournamentVO(TournamentVO tournamentVO){
		this.tournamentVO = tournamentVO;
		doCalcs();
	}
	private static void doCalcs(){
		
	}
}
