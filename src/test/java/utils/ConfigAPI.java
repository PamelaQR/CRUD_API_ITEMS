package utils;

public class ConfigAPI {

    public static final String CREATE_PROJECT= ConfigEnv.host+"/api/projects.json";
    public static final String UPDATE_PROJECT=ConfigEnv.host+"/api/projects/ID.json";
    public static final String READ_PROJECT=ConfigEnv.host+"/api/projects/ID.json";
    public static final String DELETE_PROJECT=ConfigEnv.host+"/api/projects/ID.json";

    public static final String CREATE_ITEMS= ConfigEnv.host+"/api/items.json";
    public static final String UPDATE_ITEMS=ConfigEnv.host+"/api/items/ID.json";
    public static final String READ_ITEMS=ConfigEnv.host+"/api/items/ID.json";
    public static final String DELETE_ITEMS=ConfigEnv.host+"/api/items/ID.json";

}
