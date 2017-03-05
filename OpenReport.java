import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.io.File;

class OpenReport {
    public static void main(String args[]) {
        boolean opened = false;
        Desktop desktop = Desktop.getDesktop();
        while(!opened) {
            try {
                File file = new File("./target/site/allure-maven-plugin/index.html");
                URI uri = file.toURI();
                desktop.browse(uri);
                opened = true;
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
    }
}
