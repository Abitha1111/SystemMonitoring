package websocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import com.google.gson.JsonObject;  // Import Gson for JSON handling

public class WebSocketClient {
    public static void main(String[] args) throws IOException {
        // Connect to the server at IP "192.168.11.66" on port 4999
        Socket s = new Socket("192.168.11.66", 4999);
        
        // Create PrintWriter to send data to the server
        PrintWriter pr = new PrintWriter(s.getOutputStream(), true);
        
        // Create a JSON object using Gson
        JsonObject json = new JsonObject();
        json.addProperty("message", "is it working");
        json.addProperty("status", "client side");

        // Send the JSON data to the server
        pr.println(json.toString());  // Convert JSON object to a string
        pr.flush();  // Ensure data is sent immediately

        // Reading response from the server
        InputStreamReader in = new InputStreamReader(s.getInputStream());
        BufferedReader bf = new BufferedReader(in);
        String str = bf.readLine();  // Read the response from the server
        System.out.println("Server: " + str);  // Print the server's response

        // Close the resources
        pr.close();
        bf.close();
        s.close();
    }
}
