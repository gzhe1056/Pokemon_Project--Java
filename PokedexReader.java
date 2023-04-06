import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Scanner;

public class PokedexReader {
    public static void main(String[] args) {
        String filename = "pokemon.csv";
        try {
            Scanner inputStream = new Scanner(new FileInputStream(filename));
            String line = inputStream.nextLine();
            Scanner keyboard = new Scanner(System.in);
            System.out.println("Enter a pokemon");
            String search = keyboard.next().toLowerCase();
            while (inputStream.hasNextLine()) {
                line = inputStream.nextLine();
                String[] pokemonArray = line.split(",");
                String name = pokemonArray[1];
                String type1 = pokemonArray[2];
                String type2 = pokemonArray[3];
                int total = Integer.parseInt(pokemonArray[4].trim());
                int hp = Integer.parseInt(pokemonArray[5].trim());
                int attack = Integer.parseInt(pokemonArray[6].trim());
                int defense = Integer.parseInt(pokemonArray[7].trim());
                int spatk = Integer.parseInt(pokemonArray[8].trim());
                int spdef = Integer.parseInt(pokemonArray[9].trim());
                int speed = Integer.parseInt(pokemonArray[10].trim());
                int generation = Integer.parseInt(pokemonArray[11].trim());
                String legendary = pokemonArray[12];
                if (search.equalsIgnoreCase(name)) {
                    System.out.println("Name:" +name);
                    System.out.println("Type 1: " +type1);
                    System.out.println("Type 2: " +type2);
                    System.out.println("Total: " +total);
                    System.out.println("Health: " +hp);
                    System.out.println("Attack: " +attack);
                    System.out.println("Defense:" +defense);
                    System.out.println("Special Attack: " +spatk);
                    System.out.println("Special Defense: " +spdef);
                    System.out.println("Speed: " +speed);
                    System.out.println("Generation: " +generation);
                    System.out.println("Is a Legendary: " +legendary);
                }
            }
        }
        catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}