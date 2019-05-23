package utilities;

/**
 * @author
 * Constants to hold the key,query_param,status_code,url
 */
public final class ResourceConstants {

    private static final ConfigLoader propertieshelper = new ConfigLoader();

    public static final String BASE_URI = propertieshelper.getPropertyValue("base_URI");
    public static final String REGISTER_SUCCESS_REQUEST=propertieshelper.getPropertyValue("resgister_rquest");
    public static final String GET_RESOURCE_LIST_REQUEST=propertieshelper.getPropertyValue("get_resourcelist_request");
    public static final String DELAYED_RESPONSE=propertieshelper.getPropertyValue("delayed_response_request");
    public static final int STATUS_CODE = 200;


    public static final String POST_REQUEST_INPUT="{\n" +
            "    \"email\": \"eve.holt@reqres.in\",\n" +
            "    \"password\": \"pistol\"\n" +
            "}";


}