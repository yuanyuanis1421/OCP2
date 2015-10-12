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
	private String tonoversPerGame;
	private float valPerGame;
	
	public MediaTournamentVO(TournamentVO tournamentVO){
		this.tournamentVO = tournamentVO;
		this.pointsPerGame = String.valueOf(tournamentVO.getPts()/tournamentVO.getGames());
		this.reboundsPerGame = String.valueOf(tournamentVO.getTotr()/tournamentVO.getGames());
		this.tonoversPerGame= String.valueOf(tournamentVO.getTo()/tournamentVO.getGames());
		this.FTS = calculaFTS(tournamentVO.getFg(), tournamentVO.getFga());
		this.FT2 = calculaFTS(tournamentVO.getFg2(), tournamentVO.getFga2());
		this.FT3 = calculaFTS(tournamentVO.getFg3(), tournamentVO.getFga3());
		this.FT = calculaFTS(tournamentVO.getFt(), tournamentVO.getFqa());
		this.assistsPerGame = String.valueOf(tournamentVO.getAs()/tournamentVO.getGames());
		this.blocksPerGame = String.valueOf(tournamentVO.getBs()/tournamentVO.getGames());
		this.stealsPerGame = String.valueOf(tournamentVO.getSt()/tournamentVO.getGames());
		calulaValoracion();
	}
	private void calulaValoracion() {
		int ft = tournamentVO.getFt()-(tournamentVO.getFqa()-tournamentVO.getFt());
		int fg2 = tournamentVO.getFg2()*2 - (tournamentVO.getFga2()-tournamentVO.getFg2());
		int fg3 = tournamentVO.getFg3()*3 - (tournamentVO.getFga3()-tournamentVO.getFg3());
		
		this.valPerGame = (ft+fg2+fg3+tournamentVO.getAs()+tournamentVO.getBs()+tournamentVO.getTotr()+tournamentVO.getSt()-tournamentVO.getTo())/tournamentVO.getGames();
		
	}

	private String calculaFTS(float fg, float fga) {
		Float i = (fg/fga)*100;
		return i.toString();
	}
	public String toString(){
		StringBuilder builder = new StringBuilder();
		builder.append("AÑO: ").append(tournamentVO.getYear()).append("\n");
		builder.append("Puntos por partido: ").append(pointsPerGame).append("\n");
		builder.append("FG: ").append(FTS).append("%\n");
		builder.append("FG2: ").append(FT2).append("%\n");
		builder.append("FG3: ").append(FT3).append("%\n");
		builder.append("FT: ").append(FT).append("%\n");
		builder.append("reboundsPerGame: ").append(reboundsPerGame).append("\n");

		builder.append("assistsPerGame: ").append(assistsPerGame).append("\n");
		builder.append("blocksPerGame: ").append(blocksPerGame).append("\n");
		builder.append("stealsPerGame: ").append(stealsPerGame).append("\n");
		builder.append("tonoversPerGame: ").append(tonoversPerGame).append("\n");
		builder.append("valPerGame: ").append(valPerGame).append("\n");
		return builder.toString();
	}
	public TournamentVO getTournamentVO() {
		return tournamentVO;
	}

	public String getPointsPerGame() {
		return pointsPerGame;
	}

	public String getReboundsPerGame() {
		return reboundsPerGame;
	}

	public String getFTS() {
		return FTS;
	}

	public String getFT2() {
		return FT2;
	}

	public String getFT3() {
		return FT3;
	}

	public String getFT() {
		return FT;
	}

	public String getAssistsPerGame() {
		return assistsPerGame;
	}

	public String getBlocksPerGame() {
		return blocksPerGame;
	}

	public String getStealsPerGame() {
		return stealsPerGame;
	}

	public float getValPerGame() {
		return valPerGame;
	}
	public String getTonoversPerGame() {
		return tonoversPerGame;
	}


	
}
