import java.io.File;
import java.util.concurrent.Callable;

//@Command(name="JsonSchemaTester", mixinStandardHelpOptions=true, version="JsonSchemaTester 1.0")
public class App implements Callable {

//    @Parameters(index = "0", description = "Schema file to compare json files against.")
    private File jsonSchema;

//    @Parameters(index = "1", description = "The json file to test against schema.")
    private File jsonFile;

    public Integer call() throws Exception {
        return 0;

    }
    public static void main(String... args) {
//        int exitCode = new CommandLine(new CheckSum()).execute(args);
        System.out.println("helloworld");
        int exitCode = 0;
        System.exit(exitCode);
    }
}
