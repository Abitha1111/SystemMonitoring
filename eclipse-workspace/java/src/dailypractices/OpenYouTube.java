package dailypractices;
import java.awt.Desktop;
import java.net.URI;

public class OpenYouTube {
    public static void main(String[] args) {
        try {
            // Check if Desktop is supported on this platform
            if (Desktop.isDesktopSupported()) {
                // Create a Desktop object
                Desktop desktop = Desktop.getDesktop();
                
                // Open the YouTube URL in the default web browser
                desktop.browse(new URI("https://www.youtube.com"));
            } else {
                System.out.println("Desktop is not supported on this platform.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}



	