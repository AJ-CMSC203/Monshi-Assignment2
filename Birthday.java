import java.util.Random;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Birthday {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Random rand = new Random();
		int orderNumber = rand.nextInt(10000);
		
		//declare variables
		String childName;
		String toyChoice;
		String yesOrNo = null;
		int toyCost, childAge;
		String askCard, askBalloon;
		String userChoice = "y";
		double totalCost = 0;
		
		
		while (userChoice.contentEquals("y")){
		//opening message
		JOptionPane.showMessageDialog(null, "Welcome to the Toy Company to choose gifts for young children");
		
		//enter child name
		childName = JOptionPane.showInputDialog("Enter the name of the child: ");
		
		//declare object
		Toy present = new Toy();
		
		//enter age
		String enterAge = JOptionPane.showInputDialog("How old is the child?");
		childAge = Integer.parseInt(enterAge);
		present.setAge(childAge);
		
		//choose toy
		toyChoice = JOptionPane.showInputDialog("Choose a toy: plushie, blocks, or book: ");
		present.setToy(toyChoice);
		present.setCost(toyChoice);
		
		
		
		if(present.ageOK() == false) {
			
			do{
				yesOrNo = JOptionPane.showInputDialog("Toy is not age appropriate. Do you want to buy a different toy? yes or no");
				toyChoice = JOptionPane.showInputDialog("Choose a toy: plushie, blocks, or book: ");
				present.setToy(toyChoice);
				present.setCost(toyChoice);
			}while(yesOrNo.equals("yes") && present.ageOK() == false);
			
		}
		else {
			JOptionPane.showMessageDialog(null, "Good choice");
		}
		
		//add card cost
		present.addCard(JOptionPane.showInputDialog("Do you want a card with the gift? yes or no"));
		
		
		//add balloon cost
		present.addBalloon(JOptionPane.showInputDialog("Do you want a balloon with the gift? yes or no"));
		
		totalCost += present.getCost();
		
		//present final cost
		JOptionPane.showMessageDialog(null, "The gift for " + childName + " at " + present.getAge() + 
				" is a " + present.getToy() + " for " + present.getCost() + ". Total Cost is " + totalCost + ".");
		
		
		//user decides if they want another toy
		userChoice = JOptionPane.showInputDialog("Do you want another toy? (y or n)");
		}
		
		JOptionPane.showMessageDialog(null, "Order number is " + orderNumber + " Programmer name: Amanda Jaley");
		
		
	}

}
