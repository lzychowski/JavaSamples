import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer extends Thread {

    private ServerSocket http;

    public MyServer() throws IOException{
        http = new ServerSocket(80);
    }

    public void run() {
        while (true) {
            try {
                Socket connection = http.accept();
                ServerSocketHandler handler = new ServerSocketHandler(connection);
                connection.close();
            } catch(IOException e){

            }
        }
    }

    public static void main(String[] args){
        try {
            Thread t = new MyServer();
            t.start();
        } catch (IOException e){

        }

    }
}
