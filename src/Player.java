import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Bensas on 6/17/17.
 * Clase dedicada a guardar los datos del jugador.
 */
public class Player {
    final static String FILENAME_EXTENSION = ".plr";
    private String name;
    private int wins, loses;

    /**
      *Constructor de la clase
      *@param name es el nombre seleccionado del jugador
      *
    */
    public Player(String name){
        this.name = name;
        getInfoFromPlayerFile(name + FILENAME_EXTENSION);
    }

    private void getInfoFromPlayerFile(String fileName){
        File playerFile = new File(fileName);

    }

    private void writeInfoToPlayerFile(){
        File playerFile = new File(name + FILENAME_EXTENSION);
        FileWriter writer = null;
        try{
            writer = new FileWriter(playerFile);
            writer.write(name + "\n");
            writer.write(wins + "\n");
            writer.write(loses + "\n");
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
