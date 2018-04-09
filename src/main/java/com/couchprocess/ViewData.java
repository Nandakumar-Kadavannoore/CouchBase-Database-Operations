package com.couchprocess;

import java.util.Scanner;

import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.document.JsonDocument;
import com.couchbase.client.java.document.json.JsonObject;

public class ViewData {

	@SuppressWarnings("unused")
	private Bucket bucket;

	public void view(Bucket bucket) {
		this.bucket = bucket;
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter Unique Id");
		int id = scan.nextInt();
		String str = Integer.toString(id);
		if(bucket.get(str)!=null){
		JsonDocument document = bucket.get(str);
		JsonObject jsonObject = document.content();

		String name = (String) jsonObject.get("name");
		System.out.println(name);

		String email = (String) jsonObject.get("email");
		System.out.println(email);}
		else{
			System.out.println("ID " + str + " doesn't exist");
		}
        scan.close();
		/*
		 * Statement statement = select("name","email").from(i("customer360"));
		 * QueryResult result = bucket.query(statement); Iterator<QueryRow>
		 * iterator = (Iterator<QueryRow>) result.allRows();
		 */

	}

}
