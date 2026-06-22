// The Subject Interface
interface Internet {
    void connectTo(String serverUrl);
}

// The Real Subject (The expensive or core service)
class RealInternet implements Internet {
    @Override
    public void connectTo(String serverUrl) {
        System.out.println("Successfully established connection to: " + serverUrl);
    }
}

// The Proxy Class (Controls access and intercepts calls)
class InternetProxy implements Internet {
    private final Internet realInternet = new RealInternet();
    private static final java.util.List<String> bannedSites;

    static {
        bannedSites = new java.util.ArrayList<>();
        bannedSites.add("malicious-site.com");
        bannedSites.add("wastedtime.com");
    }

    @Override
    public void connectTo(String serverUrl) {
        // Protection Layer: Check if the site is banned
        if (bannedSites.contains(serverUrl.toLowerCase())) {
            System.out.println("Access Denied: '" + serverUrl + "' is restricted by company policy.");
            return;
        }

        // Logging Layer
        System.out.println("[LOG] Requesting authorization for network access to " + serverUrl);
        
        // Forward call to the real service
        realInternet.connectTo(serverUrl);
    }
}

// Client Code
public class ProxyPatternExample {
    public static void main(String[] args) {
        Internet internet = new InternetProxy();

        // Safe site request
        internet.connectTo("google.com");
        
        System.out.println("\n----------------------------------\n");

        // Banned site request
        internet.connectTo("wastedtime.com");
    }
}