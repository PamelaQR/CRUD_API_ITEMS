package factoryRequest;

public class RequestInformation {
    private String url;
    private String body;

    public RequestInformation(String url, String body){
        this.url= url;
        this.body= body;

    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
