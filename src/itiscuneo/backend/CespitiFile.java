package itiscuneo.backend;
import com.google.gson.Gson;
import java.io.*;

public class CespitiFile implements IExports{

    @Override
    public void scriviCSV(ElencoCespiti elencoCespiti) {
        File file = new File(PATH+NAME_CSV);
        FileWriter fw = null;
        BufferedWriter bw = null;

        try{
            fw = new FileWriter(file);
            bw = new BufferedWriter(fw);
            for(Cespiti cespiti:elencoCespiti){
                bw.write(cespiti.toCSV());
            }
        }
        catch(IOException e){throw new RuntimeException(e);}
    }

    @Override
    public void scriviJson(ElencoCespiti elencoCespiti){
        Gson gson = new Gson();
        String jsonArray = gson.toJson(elencoCespiti);

        File file = new File(PATH+NAME_JSON);
        FileWriter fw = null;
        BufferedWriter bw = null;

        try{
            fw = new FileWriter(file);
            bw = new BufferedWriter(fw);

            bw.write(jsonArray);
        }
        catch(IOException e){throw new RuntimeException(e);}
    }
}
