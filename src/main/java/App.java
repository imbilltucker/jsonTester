import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Callable;
import org.everit.json.schema.Schema;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.json.JSONTokener;
import picocli.CommandLine;

@CommandLine.Command(name="JsonSchemaTester", mixinStandardHelpOptions=true, version="JsonSchemaTester 1.0")
public class App implements Runnable {

    @CommandLine.Parameters(index = "0", description = "Schema file to compare json files against.")
    private static File jsonSchema;

    @CommandLine.Parameters(index = "1", description = "The json file to test against schema.")
    private static File jsonFile;

    public void run() {
//        if (jsonSchema.exists()){
//            System.out.println(String.format("found jssonSChema file: %s", jsonSchema.getName()));
//        }
//        else {
//
//            System.out.println(String.format("did not find jssonSChema file: %s", jsonSchema.getName()));
//        }
        try {

            try (FileInputStream fisSchema = new FileInputStream(jsonSchema); FileInputStream fisJson = new FileInputStream(jsonFile)) {
                JSONObject rawSchema = new JSONObject(new JSONTokener(fisSchema));
                Schema schema = SchemaLoader.load(rawSchema);
                JSONObject rawJson = new JSONObject(new JSONTokener(fisJson));
//                schema.validate(new JSONObject("{\"hello\" : \"world\"}")); // throws a ValidationException if this object is invalid
                schema.validate(rawJson); // throws a ValidationException if this object is invalid
            }

        }
        catch (IOException err) {
            System.out.println(String.format("did not find jssonSChema file: %s", jsonSchema.getName()));
        }

    }
    public static void main(String... args) {
        System.out.println("helloworld");
        System.exit(new CommandLine(new App()).execute(args));
    }
}
