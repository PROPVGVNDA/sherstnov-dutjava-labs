package org.university.lab9;

public class DataEndpoint {
    private String endpoint;
    private String key;
    private String sheetName;
    private String arguments;

    public DataEndpoint(String endpoint, String key, String sheetName, String arguments) {
        this.endpoint = endpoint;
        this.key = key;
        this.sheetName = sheetName;
        this.arguments = arguments;
    }

    // Getters
    public String getEndpoint() { return endpoint; }
    public String getKey() { return key; }
    public String getSheetName() { return sheetName; }
    public String getArguments() { return arguments; }
}

