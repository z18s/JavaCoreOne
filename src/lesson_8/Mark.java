package lesson_8;

public enum Mark {

    X ("X"),
    O ("O"),
    NONE ("");

    private String title;

    Mark(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}