/************** Pledge of Honor ******************************************
I hereby certify that I have completed this programming project on my own
without any help from anyone else. The effort in the project thus belongs
completely to me. I did not search for a solution, or I did not consult any
program written by others or did not copy any program from other sources. I
read and followed the guidelines provided in the project description.
READ AND SIGN BY WRITING YOUR NAME SURNAME AND STUDENT ID
SIGNATURE: <Burak Erten, 83459>
*************************************************************************/
package Player;

import java.awt.Image;
import java.util.ArrayList;
import java.util.Random;

public class playerInfo {
	private String playerName;
	private String position;
	private int pPoint;
	private double PTS;
	private double TRB;
	private double AST;
	private double BLK;
	private double STL;
	private String id;
	private double weight1;
	private double weight2;
	private double weight3;
	private double weight4;	
	private double weight5;

	
	public playerInfo(String id, String playerName, double PTS, double TRB, double AST, double BLK, double STL) {
		
		this.id = id;
		this.playerName = playerName;
		this.PTS = PTS;
		this.TRB = TRB;
		this.AST = AST;
		this.BLK = BLK;
		this.STL = STL;
		
}
    /*
	 * getters and setters start
	 */
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
	public String getID() {
		return id;
	}
	public String getPlayerName() {
        return playerName;
    }
    
	
    public String getPosition() {
        return position;
    }
    

    
    public double getPTS() {
        return PTS;
    }

    
    public double getTRB() {
        return TRB;
    }
    public void setTRB(double TRB) {
    	this.TRB = TRB;
    }

    public void setPTS(double PTS) {
    	this.PTS = PTS;
    }
    // getter for AST
    public double getAST() {
        return AST;
    }
    
    public void setAST(double AST) {
    	this.AST = AST;
    }
    
    // getter for BLK
    public double getBLK() {
        return BLK;
    }
    public void setBLK(double BLK) {
    	this.BLK = BLK;
    }
    
    // getter for STL
    public double getSTL() {
        return STL;
    }
    public void setSTL(double STL) {
    	this.STL = STL;
    }

    /*
	 * getters and setters end
	 */
    
    
    /*
	 * point calculator for one player start
	 */
    
	public double getPTSV() {
		
		double randomNumber = 0;
		if (getPTS() - 5 >= 0) {
			double min = getPTS() - 5; 
		    double max = getPTS() +5; 

		        // Creating an instance of the Random class
		     Random random = new Random();

		        // Generating a random number between min (inclusive) and max (exclusive)
		     randomNumber = random.nextDouble(max - min) + min;
	
				}
		if (getPTS() - 5 <= 0) {
			double min = 0; 
		    double max = getPTS() +5; 

		    Random random = new Random();

		    randomNumber = random.nextDouble(max - min) + min;
			}
		return randomNumber;
	}
	
	public double getTRBV() {
		
		double randomNumber = 0;
		if (getTRB() - 5 >= 0) {
			double min = getTRB() - 5; 
		    double max = getTRB() +5; 

		     Random random = new Random();

		     randomNumber = random.nextDouble(max - min) + min;
	
				}
		if (getTRB() - 5 <= 0) {
			double min = 0; 
		    double max = getTRB() +5; 

		    Random random = new Random();

		    randomNumber = random.nextDouble(max - min) + min;
			}
		return randomNumber;
	}
	
	public double getASTV() {
		
		double randomNumber = 0;
		if (getAST() - 5 >= 0) {
			double min = getAST() - 5; 
		    double max = getAST() +5; 

		     Random random = new Random();

		     randomNumber = random.nextDouble(max - min) + min;
	
				}
		if (getAST() - 5 <= 0) {
			double min = 0; 
		    double max = getAST() +5; 

		    Random random = new Random();

		    randomNumber = random.nextDouble(max - min) + min;
			}
		return randomNumber;
	}
	
	public double getBLKV() {
		
		double randomNumber = 0;
		if (getBLK() - 5 >= 0) {
			double min = getBLK() - 5; 
		    double max = getBLK() +5; 

		     Random random = new Random();

		     randomNumber = random.nextDouble(max - min) + min;
	
				}
		if (getBLK() - 5 <= 0) {
			double min = 0; 
		    double max = getBLK() +5;

		    Random random = new Random();

		    randomNumber = random.nextDouble(max - min) + min;
			}
		return randomNumber;
	}
	
	public double getSTLV() {
		
		double randomNumber = 0;
		if (getSTL() - 5 >= 0) {
			double min = getSTL() - 5; 
		    double max = getSTL() +5; 

		     Random random = new Random();

		     randomNumber = random.nextDouble(max - min) + min;
	
				}
		if (getSTL() - 5 <= 0) {
			double min = 0; 
		    double max = getSTL() +5; 

		    Random random = new Random();

		    randomNumber = random.nextDouble(max - min) + min;
			}
		return randomNumber;
	}
    /*
	 * point calculator for one player end
	 */
	
	/*
	 * sums all the points of the player and creates a total point
	 */
	public int getpoint() {
		double playerPoint = getSTLV() + getBLKV() + getASTV() + getTRBV() + getPTSV();
		pPoint = (int) Math.round(playerPoint);
		return pPoint;
	}
}

