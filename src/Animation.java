import java.awt.Image;

/**
  * @author Ramiro Oliva
  * Esta clase se encarga de manejar la animación de las
  * imágenes y los tiempos que tarda cada una.
*/
public class Animation {
    public static final int STATE_PLAYING = 0, STATE_FINISHED = 1;

    private int state = STATE_PLAYING;

    private Image[] frames;
	private int timer= 0, frameDuration, frameIndex = 0;

	/**
	  *Constructor de la clase.
	  *@param frames son el conjunto de imágenes del objeto.
	  *@param frameDuration es el tiempo que dura cada frame.
	*/
	public Animation(Image[] frames, int frameDuration){
		this.frames= frames;
		this.frameDuration= frameDuration;
	}
	
	/**
	  *@return Devuelve la imagen actual del conjunto de frames.
	*/
	public Image getFrame(){
		return frames[frameIndex];
	}

	/**
	  *@param state setea el estado en el que se debe encontrar la animación: Ejecutándose o Finalizarla.
	*/
    public void setState(int state) {this.state = state;}
	
	/**
	  *@return el estado de la animación.
	*/
    public int getState() {return state;}
	
	/**
	  *Realiza el cambio de frames para generar la animación,
	  * y lo finaliza cuando llega al último de ellos. 
	*/
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
