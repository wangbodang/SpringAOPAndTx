package common.web;

public class ResultException extends Exception {
    private RemoteResult remoteResult;
    public ResultException() {
    }

    public ResultException(String message) {
        super(message);
    }
    public ResultException(RemoteResult remoteResult){
        this.remoteResult=remoteResult;
    }

    public RemoteResult getRemoteResult() {
        return remoteResult;
    }

    public void setRemoteResult(RemoteResult remoteResult) {
        this.remoteResult = remoteResult;
    }
}
