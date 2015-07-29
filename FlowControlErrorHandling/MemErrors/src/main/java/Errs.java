/**
 * Created by rursu on 7/22/2015.
 */
public class Errs {
    public void outOfMemErr() throws OutOfMemoryError {
        throw new OutOfMemoryError();
    }

    public void stackOverflowErr() throws StackOverflowError {
        throw new StackOverflowError();
    }
}
