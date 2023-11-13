import java.util.ArrayList;

public class Card {
	
	String id;
	String name;
	String type;
	ArrayList<String> colors;
	String manaCost;
	String image;
	String scryfallUrl;
	String rarity;
	int quantity;
	
	public Card(String id, String name, String type, ArrayList<String> colors, String manaCost, String image, String scryfallUrl,
			String rarity, int quantity) {
		this.id = id;
		this.name = name;
		this.type = type;
		this.colors = colors;
		this.manaCost = manaCost;
		this.image = image;
		this.scryfallUrl = scryfallUrl;
		this.rarity = rarity;
		this.quantity = quantity;
	}
	
	public void printCardNameToConsole() {
		System.out.println("name " + name);
	}

	public String getImage() {
		return image;
	}
	
	public String getName() {
		return name;
	}
	
}

