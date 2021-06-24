
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client
{
    //final static int port = 1234;

    public static void main(String address, int port) throws UnknownHostException, IOException
    {
        Scanner scn = new Scanner(System.in);

        //getting localhost ip- legacy code fron our testing....
        InetAddress ip = InetAddress.getByName("localhost");
        //InetAddress ip = address;

        //establish the connection
        Socket s = new Socket(ip, port);

        //our input and out streams
        DataInputStream dis = new DataInputStream(s.getInputStream());
        DataOutputStream dos = new DataOutputStream(s.getOutputStream());

        //sendMessage thread
        Thread sendMessage = new Thread(new Runnable()
        {
            @Override
            public void run() {
                while (true) {

                    // read the message to deliver.
                    String msg = scn.nextLine();
                    //we use "Over" to end the writing loop
                    if (msg.equals("Over")){
                        break;
                    }

                    try {
                        // write on the output stream
                        dos.writeUTF(msg);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        /*
        // readMessage thread-for reading messages from the simulator
        Thread readMessage = new Thread(new Runnable()
        {
            @Override
            public void run() {

                while (true) {
                    try {
                        // read the message sent to this client
                        String msg = dis.readUTF();
                        System.out.println(msg);
                    } catch (IOException e) {

                        e.printStackTrace();
                    }
                }
            }
        });
        */

        sendMessage.start();

        //readMessage.start();

    }
}