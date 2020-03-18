package lesson_7;

/* java.util.Observer */

@Deprecated(since = "9")
public interface Observer {

    void update(Observed o, Object arg);

}