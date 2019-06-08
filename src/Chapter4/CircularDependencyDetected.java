package Chapter4;

public class CircularDependencyDetected extends RuntimeException {
    public CircularDependencyDetected(String msg) {
        super(msg);
    }
}
