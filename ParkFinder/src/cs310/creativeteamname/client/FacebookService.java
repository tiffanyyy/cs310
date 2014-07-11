package cs310.creativeteamname.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("facebook")
public interface FacebookService extends RemoteService{
	public String logAppOnFacebook();
	public String setStoryData(String comment, String parkName);
}
