package ufit.global;

import ufit.profile.Profile;
import android.app.Application;
import android.content.Context;

public class MyApp extends Application {
	private int goal = 0;
	private Profile profile;

	public void setGoal(int n) {
		goal = n;
	}
	public int getGoal() {
		return goal;	
	}
	
    public Profile getProfile()
    {
    	if(profile == null)
    		profile = new Profile(this);
        return profile;
    }
    public void setProfile(String username, Context context)
    {
        profile = Profile.loadProfile(username,context);
    }
    public void updateProfile(Context context) {
    	profile = profile.extend(goal, context);
    }
}

/*public class myProfile extends Application //need to specify as the application in the manifest
{
    private myProfile profile;
    public Context getProfile()
    {
        return profile;
    }
    public myProfile()
    {
        profile = this;
    }
    
}
/* usage in another class
  class Blah extends Activity  {
      public void onCreate(Bundle b) {
          ...
          MyProfile curProfile =(MyProfile)getApplicationContext();
          Profile p = curProfile.getProfile();
          curProfile.setProfile("Albert", this);
      }
  }
*/