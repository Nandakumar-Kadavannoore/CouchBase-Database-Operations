package me.start.couchprocess;

/**
 * Used for insert operation
 */
import java.util.Scanner;

import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.document.JsonDocument;
import com.couchbase.client.java.document.json.JsonObject;

import me.start.couchbase.PersonDetails;

public class InsertData {

	PersonDetails person = new PersonDetails();
	@SuppressWarnings("unused")
	private Bucket bucket;

	public void insert(Bucket bucket) {

		this.bucket = bucket;

		Scanner scan = new Scanner(System.in);

		System.out.println("Enter name:: ");
		person.setName(scan.nextLine());

		System.out.println("Enter Email:: ");
		person.setEmail(scan.nextLine());

		System.out.println("Enter Unique Id");
		int id = scan.nextInt();

		String str = Integer.toString(id);

		if ((bucket.get(str) == null)) {

			System.out.println("ID " + str);
			JsonObject user = JsonObject.create().put(person.toString(), str);
			bucket.upsert(JsonDocument.create(str, user));

		} else {
			System.out.println("ID " + str + " exist");
		}
		scan.close();
	}

}
