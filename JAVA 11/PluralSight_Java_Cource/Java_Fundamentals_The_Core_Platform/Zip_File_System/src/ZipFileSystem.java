import javax.print.attribute.URISyntax;
import java.io.IOError;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.FileSystem;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class ZipFileSystem {

    private static Object HashMap;

    public static void main(String[] args) {

        String data[] = {"Line 1","Line 2 2","Line 3 3 3","Line 4 4 4 4","Line 5 5 5 5 5" };

        FileSystem zipFs = openZip(Paths.get("myData.zip"));

    }

    private static FileSystem openZip(Path zipPath) throws IOException, URISyntaxException {

        Map<String,String> providerProps = new HashMap<>();

        URI zipUri = new URI("jar:file", zipPath.)

    }
}
