package main;

import java.util.Scanner;

public class Main {

    Node first = null;
    Node tail = null;
    Node temp = null;
    Node temp2 = null;
    Node prev = null;

    public static void main(String[] args) {

    	System.out.println("*************************** ");
    	new Main().linkList();
    }
    
    public void linkList() {
    	
    	System.out.println("1. Enter (1) for insertion ");
    	System.out.println("2. Enter (2) to delete tail");
    	System.out.println("3. Enter (3) for removing elements greater than the target value");
    	System.out.println("4. Enter (4) to view list");
    	System.out.println("5. Enter (5) to exit");
        Scanner in = new Scanner(System.in);
        int i = in.nextInt();
        
         switch(i) {
         
         case 1:
         {
         	in = new Scanner(System.in);
         	System.out.println("Enter integer value to insert: ");
         	i = in.nextInt();
         	addNode(i);
         	linkList();
         }
         
         case 2:
         {
        	 deleteTail(); 
        	 linkList();
         }
         
         case 3:
         {
        	in = new Scanner(System.in);
          	System.out.println("Enter the required element: ");
          	i = in.nextInt();
          	
          	remove(i);
          	linkList();
         }
         
         case 4:
         {
        	 traversList();
        	 System.out.println("");
        	 linkList();
         }
         
         case 5:	
         {
        	 System.out.println("Thank you");
        	 System.exit(0);
        	 break;
         }
         	
         default :	
         {
        	 System.out.println("Plz enter correct value");
        	 linkList();
         }
         
         }
         
    }

    public void addNode(int number){

        if(first == null) {
            tail = first = new Node(number, null);
        } else {

            tail.setNext(new Node(number, null));
            tail = tail.getNext();
        }
    }

    public void deleteTail() {

        if(first != null) {

            if(first.getNext() == null) {
               // temp = first;
                first = null;
               // delete(temp);
            } else {

                temp = first;
                while(temp.getNext() != null){

                    temp2 = temp;
                    temp = temp.getNext();
                }

                tail = temp2 ;
                tail.setNext(null);
              //  delete(temp);

            }
        } else
        	System.out.println("List is already empty");
    }
    
	private void traversList() {

		if (first == null) {
			System.out.println("List is already empty");
		} else {
			temp = first;
			while (temp.getNext() != null) {
				System.out.println(temp.getElement());
				temp = temp.getNext();
			}
			
			System.out.println(temp.getElement());
			
			System.out.println("first  "+first.getElement());
			System.out.println("tail  "+tail.getElement());
		}
	}
	
	private void remove(int i) {
		
		if (first == null) {
			System.out.println("List is already empty");
		} else {
			
			if(i < first.getElement()) {
				first = first.getNext();
				remove(i);
			} else {
				
				Node next = null;
				temp = first;
				prev = temp;
				
				do {
					
					if(i < temp.getElement()) {
						if(temp.getNext() != null) {
							next = temp.getNext();
							prev.setNext(next);
							temp = next;
						} else {
							temp = null;
							prev.setNext(null);
							tail = prev;
						}
					} else {
						prev = temp;
						temp = temp.getNext();
					}
				} while (temp != null);
			}
		}
	}
}
