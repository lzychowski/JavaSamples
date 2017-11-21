import java.io.*;
import java.net.Socket;

public class ServerSocketHandler {

    Socket connection;
    InputStreamReader in;
    DataOutputStream out;
    BufferedReader reader;
    String result = "";
    String file = "";

    public ServerSocketHandler(Socket connection) throws IOException{
        this.connection = connection;
        in = new InputStreamReader(this.connection.getInputStream());
        out = new DataOutputStream(this.connection.getOutputStream());
        reader = new BufferedReader(in);
        getRequest();
    }

    public void getRequest(){

        try {
            // read request
            String line = reader.readLine();

            while (!line.isEmpty()){
                result += line + "\n";
                line = reader.readLine();
            }

            System.out.println("got: " + result);

            // write response
            InputStream fileIn = new FileInputStream("test.html");

            int data = fileIn.read();
            while(data != -1) {
                //do something with data...
                file += (char)data;
                data = fileIn.read();
            }

            fileIn.close();

            String response = "HTTP/1.1 200 OK\r\n\r\n" + file;
            out.write(response.getBytes("UTF-8"));

        } catch (Exception e){

        }

    }
}