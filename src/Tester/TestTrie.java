package Tester;
/*
Data Structure MiniProject
"Library Management System Using Trie Data Structure"
Group Member:=
Kuldip Rajendra Patil Prn = 210940120096
Niket Sunil Anavkar   Prn = 210940120024
*/ 

import static utils.Database.bookData;
import java.util.Scanner;
import com.app.trie.Trie;
import custom_exception.LibraryCustom_Exception;

public class TestTrie {

	public static void main(String[] args) {

		try (Scanner sc = new Scanner(System.in)) {

			Trie trie = new Trie();

			String[] data = bookData();
			for (int i = 0; i < data.length; i++) {
				trie.insert(data[i]);
			}

			boolean exit = false;
			while (!exit) {
				System.out.println("Choose Option:\n" + "1)Add New Book in Library\n"
						+ "2)Search Book Available In Library or Not\n" + "3)Delete Book from List\n"
						+ "4)Find Book Names By Prefix\n" + "5)Exit");
				try {
					switch (sc.nextInt()) {
					case 1:
						System.out.println("Enter Book Name To Add In Library(Name Should be in small letter)");
						String name = sc.next();
						trie.insert(name);
						System.out.println("Name Added in Data Successfully.");
						break;

					case 2:
						System.out.println("Enter Book Name To Search in Library.");
						String name1 = sc.next();

						if (trie.search(name1)) {
							System.out.println("This Book is Available in library.");
						} else
							System.out.println("This Book is not Available in library.");
						break;

					case 3:
						System.out.println("Enter Book Name To Remove From Library");
						String name2 = sc.next();

						if (trie.search(name2)) {
							trie.delete(name2);
							System.out.println("Student Remove Successfully");
						} else
							throw new LibraryCustom_Exception(
									"Please Enter Correct Book Name or Book Not Available in Library");
						break;

					case 4:
						System.out.println("Enter Book Name Prefix To Find Books From Library");
						String name3 = sc.next();

						System.out.println(trie.autocomplete(name3));
						break;

					case 5:
						exit = true;
						break;

					default:
						System.out.println("Please Enter Valid Option.");
						break;
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
				sc.nextLine();
			}

		}
	}
}
