import processing.core.*;
import org.openkinect.*;

public class FaceParticleSystem {
	  
	  // Variablen
	
	  PApplet parent;
	  
	  FaceDots[] faceDots;  // An arraylist for all single Shape
	  int faceDotsNum;
	  int widthSize;
	  int heightSize;
	  int xAmount;
	  int yAmount;
	  int xPos;
	  int yPos;
	  
	  public FaceParticleSystem(PApplet p, int _xPos, int _yPos, int _widthSize, int _heightSize, int _xAmount, int _yAmount) {
		parent = p;
		xPos = _xPos;
		yPos = _yPos;
	    widthSize = _widthSize;
	    heightSize = _heightSize;
	    xAmount = _xAmount;
	    yAmount = _yAmount;
	    faceDotsNum = _xAmount * _yAmount;
	    faceDots = new FaceDots[faceDotsNum];    // An arraylist for all single Shapes
	    generateFaceDots();
	  }


	public void show() {
		parent.fill(200);
		parent.noStroke();
		parent.rect(xPos, yPos, widthSize, heightSize);
	    for(int x = 0; x <= (faceDotsNum-1); x++) {
	    	parent.stroke(240);
	        parent.fill(255);
	    	//System.out.println("######### faceDots #########"  +  " " + parent.mouseX);
	        //System.out.println(faceDots[x].xCord  + "  /  " + faceDots[x].yCord);
	     	//parent.ellipse(faceDots[x].xCord , faceDots[x].yCord, 2, 2);
	        parent.pushMatrix();
	        
	        parent.translate(faceDots[x].xCord, faceDots[x].yCord, 200/2);
	     	parent.box(10,10,200);
	     	
	     	parent.popMatrix();
	     	
	     	// tiefe einbauen
	    	//parent.text("hallo",10,10);
	    	//System.out.println("");
	      
	    }
	    
	  }
	  


	void updatePosition(int _xPos, int _yPos) {
		xPos = _xPos;
		yPos = _yPos;
		generateFaceDots();
		show();
	}
	
	void generateFaceDots() {
	   int Amount = 0;
	   float xSteps = widthSize / xAmount;
	   float ySteps = heightSize / yAmount;
	   
	   for(int x = 0; x < xAmount; x++) {
	       for(int y = 0; y < yAmount; y++) { 
	           faceDots[Amount] = new FaceDots(	this,
	        		   							xPos + (int)((xSteps/2) + (xSteps * x)),
	        		   							yPos + (int)((ySteps/2) + (ySteps * y)), 
	        		   							10);
	           Amount++; 
	       }
	   }
       //System.out.println(Amount);

	  }
	 
	}