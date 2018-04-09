package com.couchprocess;

import java.util.Scanner;

import com.couchbase.client.java.Bucket;

public class ProcessEngine {

	@SuppressWarnings("unused")
	private Bucket bucket;

	public ProcessEngine(Bucket bucket) {
		this.bucket = bucket;
	}

	public void processing(Bucket bucket) {
		 int choice;
		do {
			Scanner scan = new Scanner(System.in);
			System.out.println("-----------------------------");
			System.out.println("1] Insert ");
			System.out.println("2] Delete ");
			System.out.println("3] Update");
			System.out.println("4] View");
			System.out.println("5] Exit");
			System.out.println("Enter Ur Choice:: ");
			choice = scan.nextInt();
			switch (choice) {
			case 1:
				InsertData insertData = new InsertData();
				insertData.insert(bucket);
				break;
			case 2:
				DeleteData deleteData = new DeleteData();
				deleteData.delete(bucket);
				break;
			case 3:
				UpdateData updateData = new UpdateData();
				updateData.update(bucket);
				break;
			case 4:
				ViewData viewData = new ViewData();
				viewData.view(bucket);
				break;
			case 5:
				System.exit(0);
				break;
			default:
				System.exit(0);

			}
			scan.close();
		} while (choice != 5);
	}

}
