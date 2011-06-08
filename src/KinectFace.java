
import processing.core.PApplet;
import processing.core.PFont;


public class KinectFace extends PApplet {

	FaceParticleSystem face_1;
	PFont myFont;
//	Kinect kinect;

	  int w = 640;
	  int h = 480;
	
	
	public void setup() {
	  size(w, h, P3D);
	                       
	  face_1 = new FaceParticleSystem(this, 0, 0, 200, 200, 2, 2);
	  
	  myFont = createFont("Helvetica", 12);
	  textFont(myFont);
	  lights();
	  
	  frameRate(-1);
	  System.out.println("System Println Test");
	}

	public void draw() {
		background(100);
		
		pushMatrix();
		
		translate(width/2,height/2,-250);
		rotateX(PI/2.5f);

		fill(255);
        //box(100);
        face_1.show();
     
     	popMatrix();
     	
		fill(255);
		text(frameRate, 20,20);
 
}

	public void mousePressed() {

	}
	
}
