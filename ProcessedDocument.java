public class ProcessedDocument {
    public static void main(String[] args) {
        DocumentRegistry registry = new DocumentRegistry();

        PdfDocument pdf = registry.createPdfDocument();
        pdf.open();

        System.out.println();

        TextDocument text = registry.createTextDocument();
        text.open();

        System.out.println();

        SpreadsheetDocument spreadsheet = registry.createSpreadsheetDocument();
        spreadsheet.open();

        System.out.println();

        PdfDocument summaryPdf = registry.createPdfDocument();
        summaryPdf.setFileName("summary_report.pdf");
        summaryPdf.setPageCount(30);
        summaryPdf.open();
    }
}
