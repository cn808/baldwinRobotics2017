// File borrowed from team 955

package org.usfirst.frc2439.SH17bot;

import com.ni.vision.NIVision;
import com.ni.vision.NIVision.Image;
import edu.wpi.first.wpilibj.CameraServer;

public class CameraFeeds
{
	private final int camFront;
	private final int camBack;
	private int curCam;
	private Image frame;
	private OI contr;
	private CameraServer server;
	private boolean currState = false;
	
	// hard coding settings -- this should be updated if more cameras are added 
	// or if you want better img quality, lower the quality the less bandwidth it'll consume
	private final String cameraFront = "cam0";
	private final String cameraBack = "cam1";
	private final int imgQuality = 26;
	
	public CameraFeeds(OI oi)
	{
        // Get camera ids by supplying camera name ex 'cam0', found on roborio web interface
        camFront = NIVision.IMAQdxOpenCamera(cameraFront, NIVision.IMAQdxCameraControlMode.CameraControlModeController);
        camBack = NIVision.IMAQdxOpenCamera(cameraBack, NIVision.IMAQdxCameraControlMode.CameraControlModeController);
        curCam = camFront;
        // Img that will contain camera img
        frame = NIVision.imaqCreateImage(NIVision.ImageType.IMAGE_RGB, 0);
        // Server that we'll give the img to
        server = CameraServer.getInstance();
        server.setQuality(imgQuality);
        contr = oi;
	}
	
	public void init()
	{
		changeCam(camFront);
	}

	// mapping button to camera
	public void run()
	{
		// toggle between camera feeds when button is pressed
		if(contr.cameraToggleBTN.get()) {
			if(currState) {
				currState = false;
				changeCam(camFront);
			}
			else {
				currState = true;
				changeCam(camBack);
			}
		}		
		// update frame all the time
		updateCam();
	}
	
	/**
	 * Stop aka close camera stream
	 */
	public void end()
	{
		NIVision.IMAQdxStopAcquisition(curCam);
	}
	
	/**
	 * Change the camera to get imgs from to a different one
	 * @param newId for camera
	 */
	public void changeCam(int newId)
    {
		NIVision.IMAQdxStopAcquisition(curCam);
    	NIVision.IMAQdxConfigureGrab(newId);
    	NIVision.IMAQdxStartAcquisition(newId);
    	curCam = newId;
    }
    
	/**
	 * Get the img from current camera and give it to the server
	 */
    public void updateCam()
    {
    	NIVision.IMAQdxGrab(curCam, frame, 1);
        server.setImage(frame);
    }
}