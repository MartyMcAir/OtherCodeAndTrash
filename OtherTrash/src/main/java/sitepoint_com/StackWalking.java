package sitepoint_com;

import java.util.stream.Stream;

// To enable walking the stack without creating a full (and hence expensive) snapshot JEP 259 introduces
// the StackWalker. Supported by improved JVM capabilities, it creates a stream of stack frames that will
// be lazily evaluated as needed. This allows us to leverage the Stream API’s power for filtering and
// mapping while at the same time making short walks perform better.
public class StackWalking {
    public static void main(String[] args) {
        one();
    }

    static void one() {
        two();
    }

    static void two() {
        three();
    }

    static void three() {
        String line = StackWalker.getInstance().walk(StackWalking::walk);
        System.out.println(line);
    }

    private static String walk(Stream<StackWalker.StackFrame> stackFrameStream) {
        return stackFrameStream
                .filter(frame -> frame.getMethodName().contains("one"))
                .findFirst()
                .map(frame -> "Line " + frame.getLineNumber())
                .orElse("Unknown line");
    }
}