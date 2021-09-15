package sitepoint_com;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

import static java.util.Arrays.asList;// The Process API got extended by JEP 102 and now sports features for a richer interaction with
// system level processes.
// The new ProcessBuilder makes it much more convenient to build processes and even pipelines.
//Want to call ls, pipe the results into grep? No problem

public class OS_Processes {

    public static void main(String[] args) throws IOException {
        ProcessBuilder ls = new ProcessBuilder()
                .command("ls")
                .directory(Paths.get("/home/nipa/tmp").toFile());
        ProcessBuilder grepPdf = new ProcessBuilder()
                .command("grep", "pdf")
                .redirectOutput(ProcessBuilder.Redirect.INHERIT);
        List<Process> lsThenGrep = ProcessBuilder
                .startPipeline(asList(ls, grepPdf));
    }
}