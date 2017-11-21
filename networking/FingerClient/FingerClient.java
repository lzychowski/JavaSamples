// Leszek Zychowski
// Lab8a

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class FingerClient {

    static InetAddress address;
    static String usernames = "";

    public static void main(String[] args){

        if (args.length > 0){

            try {
                address = InetAddress.getByName(args[0]);
            } catch (UnknownHostException e){
                System.err.println(e);
            }

            // concat user names if present
            if (args.length > 1){
                // add user names
                for (int i = 1; i < args.length; i++){
                    usernames += args[i] + " ";
                }
            }

            connect();

        } else {
            System.err.println("no host specified");
        }

    }

    public static void connect(){

        try {
            // open connection
            Socket socket = new Socket(address, 79);

            // create output stream and send users
            OutputStream raw = socket.getOutputStream();
            BufferedOutputStream bufferedOut = new BufferedOutputStream(raw);
            OutputStreamWriter out = new OutputStreamWriter(bufferedOut, "ASCII");
            out.write(usernames + "\r\n");
            out.flush();

            // read server's response
            InputStream inputStream = socket.getInputStream();
            BufferedInputStream bufferedIn = new BufferedInputStream(inputStream);
            InputStreamReader in = new InputStreamReader(bufferedIn, "8859_1");

            int c;
            while ((c = in.read()) != -1) {
                System.out.print((char)c);
            }

            out.close();
            in.close();

            if (socket != null){
                socket.close();
            }

        } catch (UnknownHostException e){
            System.err.println(e);
        } catch (IOException e){
            System.err.println(e);
        }
    }
}