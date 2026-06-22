interface Document {
    void open();
    void close();
}

class WordDocument implements Document {
    @Override
    public void open() {
        System.out.println("Opening Word document (.docx)...");
    }

    @Override
    public void close() {
        System.out.println("Closing Word document.");
    }
}

class PdfDocument implements Document {
    @Override
    public void open() {
        System.out.println("Opening PDF document (.pdf) in reader view...");
    }

    @Override
    public void close() {
        System.out.println("Closing PDF document.");
    }
}

class ExcelDocument implements Document {
    @Override
    public void open() {
        System.out.println("Opening Excel spreadsheet (.xlsx) with gridlines...");
    }

    @Override
    public void close() {
        System.out.println("Closing Excel spreadsheet.");
    }
}

abstract class DocumentFactory {
    public abstract Document createDocument();

    public void manageDocument() {
        Document doc = createDocument();
        doc.open();
        doc.close();
    }
}

class WordDocumentFactory extends DocumentFactory {
    @Override
    public Document createDocument() {
        return new WordDocument();
    }
}

class PdfDocumentFactory extends DocumentFactory {
    @Override
    public Document createDocument() {
        return new PdfDocument();
    }
}

class ExcelDocumentFactory extends DocumentFactory {
    @Override
    public Document createDocument() {
        return new ExcelDocument();
    }
}

public class FactoryMethodPatternExample {
    public static void main(String[] args) {
        System.out.println("=== Document Management System ===\n");

        DocumentFactory pdfFactory = new PdfDocumentFactory();
        Document myPdf = pdfFactory.createDocument();
        myPdf.open();
        myPdf.close();

        System.out.println("\n----------------------------------\n");

        DocumentFactory wordFactory = new WordDocumentFactory();
        Document myWord = wordFactory.createDocument();
        myWord.open();
        myWord.close();

        System.out.println("\n----------------------------------\n");

        DocumentFactory excelFactory = new ExcelDocumentFactory();
        excelFactory.manageDocument();
    }
}