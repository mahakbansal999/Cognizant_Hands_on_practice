interface Document {
    void open();
}

class WordDocument implements Document {
    public void open() {
        System.out.println("Opening a Word document (.docx)");
    }
}

class PdfDocument implements Document {
    public void open() {
        System.out.println("Opening a PDF document (.pdf)");
    }
}

class ExcelDocument implements Document {
    public void open() {
        System.out.println("Opening an Excel document (.xlsx)");
    }
}

abstract class DocumentFactory {
    public abstract Document createDocument();

    public Document openNewDocument() {
        Document doc = createDocument();
        doc.open();
        return doc;
    }
}

class WordDocumentFactory extends DocumentFactory {
    public Document createDocument() {
        return new WordDocument();
    }
}

class PdfDocumentFactory extends DocumentFactory {
    public Document createDocument() {
        return new PdfDocument();
    }
}

class ExcelDocumentFactory extends DocumentFactory {
    public Document createDocument() {
        return new ExcelDocument();
    }
}

public class DocumentFactoryTest {
    public static void main(String[] args) {
        DocumentFactory wordFactory = new WordDocumentFactory();
        wordFactory.openNewDocument();

        DocumentFactory pdfFactory = new PdfDocumentFactory();
        pdfFactory.openNewDocument();

        DocumentFactory excelFactory = new ExcelDocumentFactory();
        excelFactory.openNewDocument();
    }
}