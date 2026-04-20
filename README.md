## Problem 

Implement the Prototype Design Pattern using Document as the prototype interface. The interface implements two methods: clone() and open().
PdfDocument, TextDocument, and SpreadsheetDocument are concrete objects that implement the Document interface.
DocumentRegistry holds the prototypes and is responsible for creating cloned instances of each document type.
ProcessedDocument would be the client object.



## Class Diagram
<img width="896" height="479" alt="image" src="https://github.com/user-attachments/assets/1f5aa298-ef28-44ce-9786-f358ff405e8e" />

