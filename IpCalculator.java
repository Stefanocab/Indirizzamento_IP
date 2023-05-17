public class IpCalculator {
    private static final String VERSION = "1.0";

    public static void main(String[] args) {
        // Verifica se non sono presenti argomenti o se viene fornita l'opzione -help
        if (args.length == 0 || args[0].equals("-help")) {
            printHelp(); // Chiama il metodo printHelp()
        }
        // Verifica se viene fornita l'opzione -version
        else if (args[0].equals("-version")) {
            printVersion(); // Chiama il metodo printVersion()
        }
        // Verifica se vengono forniti più di due argomenti
        else if (args.length > 2) {
            System.out.println("Avviso: tutti i parametri ulteriori saranno ignorati.");
            processIpAddress(args[0]); // Chiama il metodo processIpAddress() con il primo argomento
        }
        // Se viene fornito solo un argomento
        else {
            processIpAddress(args[0]); // Chiama il metodo processIpAddress() con il primo argomento
        }
    }

    private static void processIpAddress(String ipAddress) {
        try {
            Address address = new Address(ipAddress); // Crea un oggetto Address con l'indirizzo ipAddress
            printAddressDetails(address); // Chiama il metodo printAddressDetails() con l'oggetto Address
        } catch (IllegalArgumentException e) {
            System.err.println("Errore: Indirizzo IP non valido.");
            System.exit(1);
        }
    }

    private static void printAddressDetails(Address address) {
        System.out.println("Indirizzo IP decimale puntato: " + address.getDecimalDottedQuad());
        System.out.println("Indirizzo IP binario puntato: " + address.getBinaryValue());
    }

    private static void printHelp() {
        System.out.println("Utilizzo: java IpCalculator <indirizzo IP>");
        System.out.println("Parametri:");
        System.out.println("-help: Mostra l'help del programma");
        System.out.println("-version: Mostra la versione del programma");
    }

    private static void printVersion() {
        System.out.println("IpCalculator versione " + VERSION);
        System.exit(0);
    }
}


