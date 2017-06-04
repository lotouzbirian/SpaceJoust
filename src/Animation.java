import java.awt.Image;


public class Animation {
	private Image[] frames;
	private int timer= 0;
	private int frameDuration;
	private int frameIndex= 0;
	
	public Animation(Image[] frames, int frameDuration){
		this.frames= frames;
		this.frameDuration= frameDuration;
	}
	
	public Image getFrame(){
		return frames[frameIndex];
	}
	
	public void update(){
		timer++;
		if (timer>=frameDuration){
			timer=0;
			frameIndex++;
		}
		if (frames.length<=frameIndex)
			frameIndex=0;
	}
}
