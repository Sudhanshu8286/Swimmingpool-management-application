package CoreJavaProject;

import java.sql.SQLException;
import java.util.Scanner;

public class UIInterface {
	static void startApp() throws SQLException {
		Scanner scan = new Scanner(System.in);
		System.out.println("***** Welcome to Swimming Pool Managment *****");
		while(true) {
			System.out.println("Select the operation to perform:");
			System.out.println("1. Show All Product Details");
			System.out.println("2. Find Product By ID");
			System.out.println("3. Add More Products");
			System.out.println("4. Update Product Details");
			System.out.println("5. Delect Product Details");
			
			System.out.println("0. Quit");
			System.out.println("Enter Your Choice: ");
			int choice = scan.nextInt();
			if(choice == 0) {
				System.out.println("******* THANK YOU *******");
				break;
				}
			else {
					int id, quantity;
					String name;
					double price;
					
					switch(choice) {
					case 1: System.out.println(DatabaseInterface.getAll());
								break;
					case 2:	System.out.print("Provide the ID of the Product: ");
								id = scan.nextInt();
								System.out.println(DatabaseInterface.getById(id));
								break;
					case 3:	System.out.print("Enter ID: ");
								id = scan.nextInt();
								System.out.println("Enter Name: ");
								name = scan.next();
								System.out.print("Enter Price: ");
								price = scan.nextDouble();
								System.out.print("Enter Quantity: ");
								quantity = scan.nextInt();
								System.out.println(DatabaseInterface.add(id, name, price, quantity));
								break;
					
					case 4: System.out.print("Provide the ID of the product to be updated: ");
								id = scan.nextInt();
								System.out.println("Choose the details to be updated:");
								System.out.println("1. Name");
								System.out.println("2. Price");
								System.out.println("3. Quantity");
								System.out.println("Enter Your Choice: ");
								int upChoice = scan.nextInt();
								switch(upChoice) {
												case 1: System.out.print("Enter New Name:");
																name = scan.next();
																System.out.println(DatabaseInterface.updateName(id, name));
																break;
												case 2: System.out.print("Enter New Price:");
																price = scan.nextDouble();
																System.out.println(DatabaseInterface.updatePrice(id,price));;
																break;
												case 3: System.out.print("Enter New Quantity:");
																quantity = scan.nextInt();
																System.out.println(DatabaseInterface.updateQuantity(id, quantity));
																break;
												default: System.out.println("\n\n *** WRONG CHOICE ***\n\n");
												}break;
					
					case 5: System.out.print("Provide the ID of the product to be deleted: ");
									id = scan.nextInt();
									System.out.println(DatabaseInterface.delete(id));
									break;
					case 6:	System.out.print("Provide the name: ");
									name = scan.next();
									System.out.println(DatabaseInterface.getByName(name));
									break;
					default: System.out.println("\n\nEnter the correct choice\n\n");				
								
								
																
								
					}
			}	
			
		}
		DatabaseInterface.dbDisconnect();
		
	}

}
