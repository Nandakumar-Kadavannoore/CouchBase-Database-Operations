package com.couchbase;

import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.Cluster;
import com.couchbase.client.java.CouchbaseCluster;
import com.couchprocess.ProcessEngine;

public class MainClass {

	public static void main(String[] args) {

		Cluster cluster = CouchbaseCluster.create();
		Bucket bucket = cluster.openBucket("customer360");

		ProcessEngine process = new ProcessEngine(bucket);
		process.processing(bucket);

		cluster.disconnect();
	}

}
