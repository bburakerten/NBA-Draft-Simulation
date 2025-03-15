package Player;

import java.util.Random;

public class playerSF extends playerInfo{

	String position;
	 double weight1;
	 double weight2;
	 double weight3;
	 double weight4;	
	 double weight5;
	int pPoint;
	public playerSF(String id, String playerName, double PTS, double TRB, double AST, double BLK, double STL) {
		super(id, playerName, PTS, TRB, AST, BLK, STL);
		this.position = "SF";

		this.weight1 = 0.3;
		this.weight2 = 0.3;
		this.weight3 = 0.1;
		this.weight4 = 0.1;
		this.weight5 = 0.2;

		PTS = PTS*weight1;
		TRB = TRB * weight2;
		AST = AST * weight3;
		BLK = BLK * weight4;
		STL = STL * weight5;
		
	}

	public double getweight1() {
		return weight1;
	}
	public double getweight2() {
		return weight2;
	}
	public double getweight3() {
		return weight3;
	}
	public double getweight4() {
		return weight4;
	}
	public double getweight5() {
		return weight5;
	}
	public String getPosition() {
		return position;
	}
	
}