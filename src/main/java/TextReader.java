import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TextReader {

    private BufferedReader bufferedReader;


    public TextReader(String fileName) {

        try {
            bufferedReader = new BufferedReader(new FileReader(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void closeStream() {
        try {
            this.bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String readFile() {
        StringBuilder st = new StringBuilder();
        String buff;
        try {
            while ((buff = this.bufferedReader.readLine()) != null) {
                st.append(buff);
                st.append(' '); //switch \n to space
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return st.toString();
    }

}
