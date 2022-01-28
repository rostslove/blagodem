package webproject.blagodem.utils;

public enum Statuses {
    NOT_SUBMITTED("не подтверждено"),
    IN_PROGRESS("в обработке"),
    CANCELLED("отменен"),
    DONE("выполнен");

    private String name;

    Statuses(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
