package me.start.couchbase;

import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.Cluster;
import com.couchbase.client.java.CouchbaseCluster;

import me.start.couchprocess.ProcessEngine;

public class MainClass {

	public static void main(String[] args) {

		// Creating cluster and bucket
		Cluster cluster = CouchbaseCluster.create();
		Bucket bucket = cluster.openBucket("customer360");

		// Creating process engine for the bucket
		ProcessEngine process = new ProcessEngine(bucket);
		process.processing(bucket);

		// Closing the cluster
		cluster.disconnect();
	}

}
