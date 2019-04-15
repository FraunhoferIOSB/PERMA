package de.fraunhofer.iosb.ilt.sta;

/**
 * The exception that is thrown when the service returns something else than a
 * 200 OK status.
 *
 * @author scf
 */
public class StatusCodeException extends ServiceFailureException {

    private final int statusCode;
    private final String statusMessage;
    private final String returnedContent;

    public StatusCodeException(int statusCode, String statusMessage, String returnedContent) {
        super(statusMessage);
        this.statusCode = statusCode;
        this.statusMessage = statusMessage;
        this.returnedContent = returnedContent;
    }

    /**
     * The status code returned by the server.
     *
     * @return the statusCode
     */
    public int getStatusCode() {
        return statusCode;
    }

    /**
     * The status message returned by the server.
     *
     * @return the statusMessage
     */
    public String getStatusMessage() {
        return statusMessage;
    }

    /**
     * The content returned by the server.
     *
     * @return the returnedContent
     */
    public String getReturnedContent() {
        return returnedContent;
    }

}
