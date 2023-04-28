package gtne;

@SuppressWarnings("unused")
public final class GTNEVersion {

    public static final int MAJOR = 1;
    //This number is incremented every major feature update
    public static final int MINOR = 1;
    //This number is incremented every time the feature is added, or bug is fixed. resets every major version change
    public static final int REVISION = 35;
    //This String is for additional info on the release version if needed (like alpha, beta, rc). Comment out when unused
    public static final String EXTRA = "beta";
    //This is the String formatted version, used in builds and dependencies
    public static final String DEP_VERSION = MAJOR + "." + MINOR + "." + REVISION + "-" + EXTRA;
    //This is the String formatted version, minus extra information, used for the @Mod annotation version
    public static final String VERSION = MAJOR + "." + MINOR + "." + REVISION;

    private GTNEVersion() {
    }
}