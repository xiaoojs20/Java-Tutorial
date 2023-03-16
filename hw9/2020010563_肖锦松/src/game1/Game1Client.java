package game1;
import java.io.*;
import java.net.*;
import java.lang.Math;

public class Game1Client {
    public String strLocal = "", strSocket = "", host;
    public int port;
    public Socket socketClient;
    int ans = 0;
    int min = 0;
    int max = 10000000;
    int times;

    public Game1Client(String host, int port) {
        try {
            this.host = host;
            this.port = port;
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public int run() {
        try {
            System.out.println("client running");
            socketClient = new Socket(host, port);
//            BufferedReader brInFromUser =
//                    new BufferedReader(new InputStreamReader(System.in));
            BufferedReader brInFromServer =
                    new BufferedReader(new
                            InputStreamReader(socketClient.getInputStream()));
            DataOutputStream dosOutToServer =
                    new DataOutputStream(socketClient.getOutputStream());

            strLocal = "hello";
            dosOutToServer.writeBytes(strLocal+"\n");
            dosOutToServer.flush();
            for(int i = 0 ;i<3;i++){
                strSocket = brInFromServer.readLine();
                System.out.println("Server: " + strSocket);
                if(i==0){
                    min = Integer.parseInt(strSocket);
                }
                if(i==1){
                    max = Integer.parseInt(strSocket);
                }
                if(i==2){
                    times = Integer.parseInt(strSocket);
                }
            }


            while(!strLocal.equals("bye")){
                if(strSocket.equals("<")){
                    min = ans;
                }
                if(strSocket.equals(">")){
                    max = ans;
                }
                if(strSocket.equals("Correct!")){
                    strSocket = brInFromServer.readLine();
                    System.out.println("Server: " + strSocket);
                    break;
                }
                ans = min + (int)(Math.random() * (max-min+1));
                String ansString = String.valueOf(ans);
                System.out.println("Client: " + ansString);
                dosOutToServer.writeBytes(ansString+"\n");
                dosOutToServer.flush();

                strSocket = brInFromServer.readLine();
                System.out.println("Server: " + strSocket);
            }
            dosOutToServer.writeBytes("bye\n");
            System.out.println("Client: bye\n");
            socketClient.close();
            return ans;
        } catch (UnknownHostException e) {
            e.printStackTrace();
            return 0;
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }
    }
}


