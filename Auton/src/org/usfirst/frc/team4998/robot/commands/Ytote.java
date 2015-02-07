package org.usfirst.frc.team4998.robot.commands;

import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Iterator;

import javax.imageio.ImageIO;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfPoint;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.highgui.Highgui;
import org.opencv.imgproc.Imgproc;

import edu.wpi.first.wpilibj.networktables.NetworkTable;

/*
 * @author: Elijah Kaufman and his team
 * 
 * Note From Author: If you use this code or the algorithm
 * please give credit to Elijah Kaufman and FRC team 3019, Firebird Robotics
 */


public class Ytote extends CommandBase{
	public static Scalar Red,Blue,Green,Yellow,thresh_Lower,thresh_Higher,grey_Lower,grey_higher;
	static NetworkTable table;
	public static void main(String[] args) {
		//required for openCV to work -call before any functions of oCV are used
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		Red = new Scalar(0, 0, 255);
		Blue = new Scalar(255, 0, 0);
		Green = new Scalar(0, 255, 0);
		Yellow = new Scalar(0, 255, 255);
		//for tape
		thresh_Lower = new Scalar(62,102,0);
		thresh_Higher = new Scalar(255,255,47);
		//for grey tote
		grey_Lower = new Scalar(48,60,35);
		grey_higher = new Scalar(81,84,54);
		
		NetworkTable.setClientMode();
		NetworkTable.setIPAddress("roborio-3019.local");
		table = NetworkTable.getTable("SmartDashboard");
		
		//main loop of the program
		
		while(true){
			try {
				while(table.isConnected()){
					processImage();
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				break;
			}
		}
	}
	//opens a new connection to the Axis camera and opens a new snapshot "instance"
	public static void processImage(){
		try {
			//the url of the camera snapshot to save ##.## with your team number
			//Url url = new URL("http://10.##.##.11/axis-cgi/jpg/image.cgi");
			URL url = new URL("http://10.30.19.11/axis-cgi/jpg/image.cgi");
			URLConnection uc = url.openConnection();
			//saves the image to a file
			BufferedImage img = ImageIO.read((uc.getInputStream()));
			ImageIO.write(img, "png", new File("frame.png"));
			//time for the OpenCV fun!
			Mat frame = new Mat();
			Mat grey = new Mat();
			Mat original = new Mat();
			original = Highgui.imread("frame.png");
			ArrayList<MatOfPoint> contours = new ArrayList<>();
			//applies a threshhold in the form of BlueGreenRed
			Core.inRange(original, thresh_Lower, thresh_Higher, frame);
			//find the cluster of particles
			Imgproc.findContours(frame, contours, new Mat(), Imgproc.RETR_EXTERNAL, Imgproc.CHAIN_APPROX_SIMPLE);
			Imgproc.cvtColor(frame, frame, Imgproc.COLOR_GRAY2BGR);
			//iterating through the list of contours and removing the ones with an "area" less then 100
			for (Iterator<MatOfPoint> iterator = contours.iterator(); iterator.hasNext();) {
				MatOfPoint matOfPoint = (MatOfPoint) iterator.next();
				if(matOfPoint.width() * matOfPoint.height() < 20){
					iterator.remove();
				}	
			}
			//if theres only one contour dont do the silly math of the bounding rectangles
			if(contours.size() == 1){
					Rect rec1 = Imgproc.boundingRect(contours.get(0));
					Core.rectangle(frame, rec1.tl(), rec1.br(), Yellow);
					String string = "TargetFound at X:" + (rec1.tl().x + rec1.br().x) / 2 + "Y:" + (rec1.tl().y + rec1.br().y) / 2;
					Core.putText(frame, string, new Point(200,frame.size().height-10), Core.FONT_HERSHEY_PLAIN, 1, Red);
			}
			//i wonder if there is two totes...
			else if(contours.size() == 2 || contours.size() == 4){
				ArrayList<Rect> target1 = new ArrayList<Rect>();
				ArrayList<Rect> target2 = new ArrayList<Rect>();
					target1.add(Imgproc.boundingRect(contours.get(0)));
					target1.add(Imgproc.boundingRect(contours.get(1)));
					if(contours.size() == 4){
						target2.add(Imgproc.boundingRect(contours.get(2)));
						target2.add(Imgproc.boundingRect(contours.get(3)));
					}
				Point tl = target1.get(0).tl();
				Point br = target1.get(0).br();
				//outer bounds of one rectangle
				for(Rect rec : target1){
					if(tl.x > rec.tl().x){
						tl.x = rec.tl().x;
					}
					if(tl.y > rec.tl().y){
						tl.y = rec.tl().y;
					}
					if(br.x < rec.br().x){
						br.x = rec.br().x;
					}
					if(br.y < rec.br().y){
						br.y = rec.br().y;
					}
				}
				Rect bb1 = new Rect(tl, br);
				Core.rectangle(frame, bb1.br(),bb1.tl(), Yellow);
				Rect bb2 = null;
				//the 4 L will make 4 contours
				//if there was 4 contours then fill the outer bounds of the second rectangle
				if(!target2.isEmpty()){
					tl = target2.get(0).tl();
					br = target2.get(0).br();
					for(Rect rec : target2){
						if(tl.x > rec.tl().x){
							tl.x = rec.tl().x;
						}
						if(tl.y > rec.tl().y){
							tl.y = rec.tl().y;
						}
						if(br.x < rec.br().x){
							br.x = rec.br().x;
						}
						if(br.y < rec.br().y){
							br.y = rec.br().y;
						}
					}
					bb2 = new Rect(tl, br);
				}
				String string;
				if(null != bb2){
					Core.rectangle(frame, bb2.br(),bb2.tl(), Yellow);
					//checking to see if the totes line up, because stacked totes line up!
					if(Math.abs(bb1.x-bb2.x) < 5){
						string = "Two totes stacked";
						Core.line(frame, new Point(bb1.x+bb1.width/2,bb1.y+bb1.height/2),
								new Point(bb2.x+bb2.width/2,bb2.y+bb2.height/2), Green);
						//System.out.println(Math.abs((bb1.y + bb1.height/2) - (bb2.y + bb2.height)));
					}
					else{
					string = "Two totes found";
					}
				}
				else{
					//knowing how far off the center of the image you can set your robot to align with it, essentially going towards it
					string = "Off center by " + (bb1.x + bb1.width/2 - 320) + " pixels";
					table.putNumber("Off Center", (bb1.x + bb1.width/2 - 320));
					int print = bb1.width;
					System.out.println(print / 640.0);
					table.putNumber("ToteToScreen", bb1.width / 640.0);
				}
				//putting the data in a visible form
				Core.putText(frame, string, new Point(200,frame.size().height-10), Core.FONT_HERSHEY_PLAIN, 1, Red);
			}
			else if(contours.size() == 3){
				ArrayList<Rect> rect = new ArrayList<>();
				for(MatOfPoint mOP : contours){
					rect.add(Imgproc.boundingRect(mOP));
					Rect temp = rect.get(rect.size()-1);
					Core.rectangle(frame, temp.br(),temp.tl(), Red);
				}
				for(int i = 1; i < contours.size();i++){
					if(Math.abs(rect.get(i).y - rect.get(i-1).y) < 5){
						
						Rect r1 = rect.get(i);
						Rect r2 = rect.get(i-1);
						Point tl = r1.tl();
						Point br = r1.br();
						if(tl.x > r2.tl().x){
							tl.x = r2.tl().x;
						}
						if(tl.y > r2.tl().y){
							tl.y = r2.tl().y;
						}
						if(br.x < r2.br().x){
							br.x = r2.br().x;
						}
						if(br.y < r2.br().y){
							br.y = r2.br().y;
						}
						break;
					}
				}
			}
			else{
				
				for(MatOfPoint mOP : contours){
					Rect rec = Imgproc.boundingRect(mOP);
					Core.rectangle(frame, rec.tl(), rec.br(), Red);
				}
			}
			//processing for grey totes
			Core.inRange(original, grey_Lower, grey_higher, grey);
			Imgproc.findContours(grey, contours, new Mat(), Imgproc.RETR_EXTERNAL, Imgproc.CHAIN_APPROX_SIMPLE);
			Imgproc.cvtColor(grey, grey, Imgproc.COLOR_GRAY2BGR);
			//iterating through the list of contours and removing the ones with an "area" less then 100
			for (Iterator<MatOfPoint> iterator = contours.iterator(); iterator.hasNext();) {
				MatOfPoint matOfPoint = (MatOfPoint) iterator.next();
				if(matOfPoint.width() * matOfPoint.height() < 150){
					iterator.remove();
				}	
			}
			for(MatOfPoint mop : contours){
				Rect bb = Imgproc.boundingRect(mop);
				Core.rectangle(grey, bb.tl(), bb.br(), Red);
			}
			//gui on the image
			Core.line(frame, new Point(frame.width()/2,100),new Point(frame.width()/2,frame.height()-100), Blue);
			Core.line(frame, new Point(150,frame.height()/2),new Point(frame.width()-150,frame.height()/2), Blue);
			Core.putText(frame, "Team 3019 - Elijah Kaufman", new Point(0,20), 
					Core.FONT_HERSHEY_PLAIN, 1, Red);
			//view this file to see the vision tracking
			//windows will update the image after every save

			Highgui.imwrite("rectangle.png", frame);
			//Highgui.imwrite("grey.jpg", grey);
		//mostly for debugging but errors happen
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();	
		}
	}
	//takes in the target width or length and a boolean and returns a distance
	//assumes the use of the Axis M1013 camera
	//depreciated because it needs further testing and does not work
	@Deprecated
	public static double getDistance(double targetInPixels,boolean width){
		//double FOVpix = width ? 640 : 480;
		double FOVpix = 480;
		double FOVft = ((7 / 12.0) / targetInPixels) * FOVpix;
		double returnd = FOVft / Math.tan(33.5);
		return returnd;
	}
}