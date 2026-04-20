// Document interface (extends Cloneable)
interface Document extends Cloneable {
    Document clone();
    void open();
    String getType();
}

// PdfDocument
class PdfDocument implements Document {
    private String fileName;
    private String author;
    private int pageCount;
    private String name;

    public PdfDocument(String fileName, String author, int pageCount, String name) {
        this.fileName = fileName;
        this.author = author;
        this.pageCount = pageCount;
        this.name = name;
    }

    @Override
    public PdfDocument clone() {
        return new PdfDocument(this.fileName, this.author, this.pageCount, this.name);
    }

    @Override
    public void open() {
        System.out.println("Opening PDF Document: " + fileName + " by " + author + " (" + pageCount + " pages)");
        System.out.println("Type: PDF, File: " + fileName + ", Author: " + author + ", Pages: " + pageCount);
    }

    @Override
    public String getType() {
        return "PDF";
    }

    public void setFileName(String fileName) { this.fileName = fileName; }
    public void setPageCount(int pageCount)  { this.pageCount = pageCount; }
}

// TextDocument
class TextDocument implements Document {
    private String filePath;
    private String encoding;
    private int wordCount;

    public TextDocument(String filePath, String encoding, int wordCount) {
        this.filePath = filePath;
        this.encoding = encoding;
        this.wordCount = wordCount;
    }

    @Override
    public TextDocument clone() {
        return new TextDocument(this.filePath, this.encoding, this.wordCount);
    }

    @Override
    public void open() {
        System.out.println("Opening Text Document: " + filePath + " with encoding: " + encoding + " (" + wordCount + " words)");
        System.out.println("Type: Text, Path: " + filePath + ", Encoding: " + encoding + ", Words: " + wordCount);
    }

    @Override
    public String getType() {
        return "Text";
    }
}

// SpreadsheetDocument
class SpreadsheetDocument implements Document {
    private String spreadsheetName;
    private int rowCount;
    private int columnCount;

    public SpreadsheetDocument(String spreadsheetName, int rowCount, int columnCount) {
        this.spreadsheetName = spreadsheetName;
        this.rowCount = rowCount;
        this.columnCount = columnCount;
    }

    @Override
    public SpreadsheetDocument clone() {
        return new SpreadsheetDocument(this.spreadsheetName, this.rowCount, this.columnCount);
    }

    @Override
    public void open() {
        System.out.println("Opening Spreadsheet Document: " + spreadsheetName + " (" + rowCount + " rows, " + columnCount + " columns)");
        System.out.println("Type: Spreadsheet, Name: " + spreadsheetName + ", Rows: " + rowCount + ", Columns: " + columnCount);
    }

    @Override
    public String getType() {
        return "Spreadsheet";
    }
}

// DocumentRegistry — holds prototypes and clones them on demand
class DocumentRegistry {
    private PdfDocument pdfPrototype;
    private TextDocument textDocumentPrototype;
    private SpreadsheetDocument spreadsheetPrototype;

    public DocumentRegistry() {
        System.out.println("Creating a PDF Document prototype.");
        pdfPrototype = new PdfDocument("annual_report_2024.pdf", "Acme Corp", 150, "Annual Report");

        System.out.println("Creating a Text Document prototype.");
        textDocumentPrototype = new TextDocument("meeting_notes.txt", "UTF-8", 250);

        System.out.println("Creating a Spreadsheet Document prototype.");
        spreadsheetPrototype = new SpreadsheetDocument("sales_data_q1.xlsx", 1000, 20);
    }

    public PdfDocument createPdfDocument() {
        return pdfPrototype.clone();
    }

    public TextDocument createTextDocument() {
        return textDocumentPrototype.clone();
    }

    public SpreadsheetDocument createSpreadsheetDocument() {
        return spreadsheetPrototype.clone();
    }
}

// ProcessedDocument — uses the registry and demonstrates the pattern
class ProcessedDocument {
    public static void main(String[] args) {
        DocumentRegistry registry = new DocumentRegistry();

        // Clone and open each prototype
        PdfDocument pdf = registry.createPdfDocument();
        pdf.open();

        System.out.println();

        TextDocument text = registry.createTextDocument();
        text.open();

        System.out.println();

        SpreadsheetDocument spreadsheet = registry.createSpreadsheetDocument();
        spreadsheet.open();

        System.out.println();

        // Clone the PDF prototype and customise it independently
        PdfDocument summaryPdf = registry.createPdfDocument();
        summaryPdf.setFileName("summary_report.pdf");
        summaryPdf.setPageCount(30);
        summaryPdf.open();
    }
}
