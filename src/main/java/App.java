import java.io.File;
import java.io.InputStream;
import java.util.concurrent.Callable;
import org.everit.json.schema.Schema;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.json.JSONTokener;
import picocli.CommandLine;

@CommandLine.Command(name="JsonSchemaTester", mixinStandardHelpOptions=true, version="JsonSchemaTester 1.0")
public class App implements Callable {

    @CommandLine.Parameters(index = "0", description = "Schema file to compare json files against.")
    private static File jsonSchema;

    @CommandLine.Parameters(index = "1", description = "The json file to test against schema.")
    private static File jsonFile;

    public Integer call() throws Exception {
        return 0;

    }
    public static void main(String... args) {
//        int exitCode = new CommandLine(new CheckSum()).execute(args);
//        try (InputStream inputStream = getclass().getClassLoader().getResourceAsStream(jsonSchema)) {
//            JSONObject rawSchema = new JSONObject(new JSONTokener(inputStream));
//            Schema schema = SchemaLoader.load(rawSchema);
//            schema.validate(new JSONObject("{\"hello\" : \"world\"}")); // throws a ValidationException if this object is invalid
//        }
        if (jsonSchema.exists()){
            System.out.println(String.format("found jssonSChema file: %s", jsonSchema.getName()));
        }

        System.out.println("helloworld");
        int exitCode = 0;
        System.exit(exitCode);
    }
}
