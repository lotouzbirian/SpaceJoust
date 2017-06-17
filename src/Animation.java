import java.awt.Image;


public class Animation {
	private Image[] frames;
	private int timer= 0, frameDuration, frameIndex = 0;

    public static final int STATE_PLAYING = 0, STATE_FINISHED = 1;
    private int state;

	public Animation(Image[] frames, int frameDuration){
		this.frames= frames;
		this.frameDuration= frameDuration;
	}
	
	public Image getFrame(){
		return frames[frameIndex];
	}

    public void setState(int state) {this.state = state;}
    public int getState() {return state;}

    public void update(){
		timer++;
		if (timer>=frameDuration){
			timer=0;
			frameIndex++;
		}
		if (frameIndex >= frames.length){
            setState(STATE_FINISHED);
            frameIndex=0;
        }
	}
}
