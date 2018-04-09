package com.couchprocess;

import java.util.Scanner;

import com.couchbase.client.java.Bucket;

public class DeleteData {
	
	@SuppressWarnings("unused")
	private Bucket bucket;

	public void delete(Bucket bucket) {
		this.bucket = bucket;
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter Unique Id");
		int id = scan.nextInt();
		String str = Integer.toString(id);
		
		bucket.remove(str);
		scan.close();
		
	}

}
