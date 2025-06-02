import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DeckManager {
    private List<String> deckNames; //guarda os nomes de cada deck

    public DeckManager() {
        this.deckNames = new ArrayList<>();
    }

    
    public void addDeck(String deckName) {
        if (!deckNames.contains(deckName)) {
            deckNames.add(deckName);
            System.out.println("Deck " + deckName + " adicionado.");
        } else {
            System.out.println("Deck " + deckName + " já existe.");
        }
    }


    public void saveDeckNamesToFile(String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (String deckName : deckNames) {
                writer.write(deckName);
                writer.newLine();
            }
            System.out.println("Deck names saved to " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void loadDeckNamesFromFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                deckNames.add(line);
            }
            System.out.println("Deck names loaded from " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public List<String> getDeckNames() {
        return deckNames;
    }
}
