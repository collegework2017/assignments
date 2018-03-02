import java.io.FileReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.File;
import java.io.FileWriter;

/**
 * File Utility class to handle various File IO
 * @author PK
 */
public class FileUtils {
    /* Only contains static methods for file IO so no point
     * letting user create multiple instances of this class
     */
    private FileUtils() {}

    /**
     * Writes data to File.
     * Can accept String, StringBuilder, StringBuffer
     * @param filename
     * @param data String, StringBuilder, StringBuffer
     * @param append Append data or false to overwrite
     */
    public static void writeToFile(String filename, CharSequence data, boolean append) throws IOException {
        
        /*
         * Rather than swallow an exception we rethrow to alert user.
         * try with resources will close the writer avoiding memory leak
         */
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(filename, append))) {
            writer.write(data.toString());
            writer.flush();
        } catch (IOException ex) {
            throw ex;
        }
    }

    /**
     * Read contents of a File and returns as a String
     * @param filename
     * @return
     * @throws IOException 
     */
    public static String fileDataToString(String filename) throws IOException {

        StringBuilder sb = new StringBuilder();
        /* Try with resources will close the reader on Exception
         * to avoid memory leaks. We are rethrowning the exception
         * to alert the user that something went wrong
         */
        try (BufferedReader reader = fileReader(filename)) {      
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
        } catch (IOException ex) {
            throw ex;
        }

        return sb.toString();
    }

    
     /**
     * Returns all lines in chosen file as a String[] array
     * @param filename Input File
     * @return String[] all lines in File as an Array
     * @throws IOException
     */
    public static String[] fileLines(String filename) throws IOException {
        return fileDataToString(filename).split("\n");
    }
    
    /**
     * Returns a BufferedReader for file reading
     * @param filename
     * @return
     * @throws FileNotFoundException 
     */
    private static BufferedReader fileReader(String filename) throws FileNotFoundException {
        return new BufferedReader(new FileReader(filename));
    }

}