// 1. The Client Interface
interface JsonDashboard {
    void displayStockData(String jsonString);
}

// 2. The Adaptee
class XmlAnalyticsLibrary {
    public void analyzeXmlData(String xmlString) {
        System.out.println("Analyzing data smoothly: " + xmlString);
    }
}

// 3. The Adapter
class StockDataAdapter implements JsonDashboard {
    private final XmlAnalyticsLibrary xmlLibrary;

    public StockDataAdapter(XmlAnalyticsLibrary library) {
        this.xmlLibrary = library;
    }

    @Override
    public void displayStockData(String jsonString) {
        // Translate the input data from JSON format to XML format
        String translatedXml = convertJsonToXml(jsonString);
        
        // Forward the translated request to the incompatible library
        xmlLibrary.analyzeXmlData(translatedXml);
    }

    private String convertJsonToXml(String jsonString) {
        // Simplified mockup conversion logic for this example
        return "<xml><stockData>" + jsonString.replace("{", "").replace("}", "") + "</stockData></xml>";
    }
}

// 4. The Client Code
public class AdapterPatternExample {
    public static void main(String[] args) {
        // Raw incompatible service
        XmlAnalyticsLibrary legacyLibrary = new XmlAnalyticsLibrary();
        
        // Wrap it inside our Adapter
        JsonDashboard activeDashboard = new StockDataAdapter(legacyLibrary);
        
        String clientJsonData = "{'ticker': 'GOOG', 'price': 175}";
        activeDashboard.displayStockData(clientJsonData);
    }
}