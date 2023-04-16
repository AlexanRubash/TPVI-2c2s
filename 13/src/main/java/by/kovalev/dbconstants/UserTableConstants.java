package by.kovalev.dbconstants;

public enum UserTableConstants {
    ID("id"),
    LOGIN("username"),
    PASSWORD("password");
    private String fieldName;
    private UserTableConstants(String fieldName) {
        this.fieldName = fieldName;
    }
    public String getFieldName() {
        return fieldName;
    }
}