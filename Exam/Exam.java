import java.util.*;

public class Exam{
	
	public static void main(String[] args){
		
		ArrayList<String> list = new ArrayList<String>();
		Scanner scan =  new Scanner(System.in);
		String again = "";
		
		do{
			System.out.print("\n\tRAFFLE\n1. Add Participants.\n2. List of Participants.\n3. Begin Raffle. \n4. Exit.\n\nPlease Choose a Number: ");
			int choice = scan.nextInt();

			if(choice == 1){
				System.out.print("Enter Name of Participant: ");
				String name = scan.next();
				addPart(list, name);
			}
			else if(choice == 2){
				viewList(list);
			}
			else if(choice == 3){
				raffle(list);
			}
			else if(choice == 4){
				again = "n";
			}
			else{
				System.out.println("\n\nInvalid Choice");
			}
			
			System.out.print("Do you wish to Continue? y/n: ");
			again = scan.next();
			
		}while(again.equalsIgnoreCase("y"));
	}
	// CHECK NAME IF UNIQUE
	static void unique(ArrayList<String> list, String name){
		boolean ans = false;
		for(String obj:list){
			if(obj.equalsIgnoreCase(name)){
				ans = true;
				break;
			}
		}
		if(!ans){
			list.add(name);
			System.out.println("Participant " + name + " has been added the list!\n\n");
		}else{
			System.out.println(name + " is already in the list!\n\n");
		}

	}
	// ADD PARTICIPANT INTO THE LIST
	static void addPart(ArrayList<String> list, String name){

		if(list.isEmpty()){
			list.add(name);
			System.out.println("Participant " + name + " has been added the list!\n\n");
		}else{
			unique(list, name);
		}
	}
	//CALL RANDOM PARTICIPANT IN THE LIST
	static void raffle(ArrayList<String> list){
		
		Random generator = new Random();
		int raf = generator.nextInt(list.size());
		
		System.out.println("\nThe winner of the raffle is: '" + list.get(raf) +"' \n\n");
		list.remove(raf); //REMOVE PARTICIPANT
		
		if(list.isEmpty()){
			System.out.println("List empty...\nExiting program...");
			System.exit(0);
		}

	}
	// VIEW PARTICIPANTS LIST
	static void viewList(ArrayList<String> list){
		int cnt = 1;
		System.out.println("\n\tList of Participants : \n");
		if(list.isEmpty()){
			System.out.println("\tThe List is still empty!\n\n");
		}else{
			for(String obj:list){
				System.out.println("\t"+cnt+". "+obj);
				cnt++;
			}
		}
		
	}
	
}