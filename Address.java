public class Address {
    private String decimalDottedQuad; // Rappresenta l'indirizzo IP decimale puntato
    private String binaryValue; // Rappresenta l'indirizzo IP binario puntato 
    private int decimalValue; // Rappresenta l'indirizzo IP decimale

    public Address(String decimalDottedQuad) {
        this.decimalDottedQuad = decimalDottedQuad;
        this.binaryValue = convertToBinary(decimalDottedQuad); // Converte l'indirizzo decimale puntato in binario puntato
        this.decimalValue = convertToDecimal(decimalDottedQuad); // Converte l'indirizzo decimale puntato in decimale
    }

    public Address(int decimalValue) {
        this.decimalValue = decimalValue;
        this.decimalDottedQuad = convertToDecimalDottedQuad(decimalValue); // Converte l'indirizzo decimale in decimale puntato
        this.binaryValue = convertToBinary(decimalValue); // Converte l'indirizzo decimale in binario puntato
    }

    public String getDecimalDottedQuad() {
        return decimalDottedQuad;
    }

    public String getBinaryValue() {
        return binaryValue;
    }

    public int getDecimalValue() {
        return decimalValue;
    }

    private int convertToDecimal(String decimalDottedQuad) {
        String[] octets = decimalDottedQuad.split("\\.");
        int decimalAddress = 0;

        for (String octet : octets) {
            int decimal = Integer.parseInt(octet);
            decimalAddress = (decimalAddress << 8) + decimal; // Combina gli ottetti per ottenere l'indirizzo IP decimale
        }

        return decimalAddress;
    }

    private String convertToDecimalDottedQuad(int decimalValue) {
        StringBuilder decimalQuad = new StringBuilder();
        int mask = 255; // Maschera per estrarre l'ottetto

        for (int i = 0; i < 4; i++) {
            int octet = (decimalValue >> (24 - (i * 8))) & mask; // Esegue lo shift e applica la maschera per ottenere l'ottetto
            decimalQuad.append(octet); // Aggiunge l'ottetto al risultato

            if (i < 3) {
                decimalQuad.append("."); // Aggiunge il punto tra gli ottetti
            }
        }

        return decimalQuad.toString(); // Restituisce l'indirizzo decimale puntato
    }

    private String convertToBinary(String decimalDottedQuad) {
        String[] octets = decimalDottedQuad.split("\\.");
        StringBuilder binaryAddress = new StringBuilder();

        for (String octet : octets) {
            int decimal = Integer.parseInt(octet);
            String binary = Integer.toBinaryString(decimal); // Converte l'ottetto decimale in binario

            // Aggiunge zeri iniziali se necessario per avere 8 bit
            while (binary.length() < 8) {
                binary = "0" + binary;
            }

            binaryAddress.append(binary); // Aggiunge l'ottetto binario al risultato
        }

        return binaryAddress.toString(); // Restituisce l'indirizzo binario puntato
    }

    private String convertToBinary(int decimal) {
        return Integer.toBinaryString(decimal); // Converte l'indirizzo decimale in binario
    }
}
