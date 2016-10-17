package com.tamingtext.demo;

import java.io.IOException;
import java.net.URL;
import java.util.Date;

import org.apache.cassandra.thrift.Cassandra.system_add_column_family_args;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.CommonsHttpSolrServer;
import org.apache.solr.common.SolrInputDocument;

public class DemoDataCollector {

	
	public static void main(String[] args) throws SolrServerException, IOException {
		SolrServer solr = new CommonsHttpSolrServer(new URL("http://localhost:" + 8983 + "/solr"));//<co id="co.solrj.server"/>
	    AddDoc1(solr);
	    
	    AddDoc2(solr);
	    
	    
	    
	    System.out.print("Successfully saved");
	}

	private static void AddDoc2(SolrServer solr) throws SolrServerException, IOException {
		SolrInputDocument doc = new SolrInputDocument();
	    doc.addField("docid", "2");//<co id="co.solrj.unique"/>
	    //doc.addField("mimeType", "text/plain");
	    //doc.addField("title", "Tortoise beats Hare!  Hare wants rematch.", 5);//<co id="co.solrj.title"/>
	    Date now2 = new Date();
	    //doc.addField("date", DateUtil.getThreadLocalDateFormat().format(now));//<co id="co.solrj.date"/>
	    doc.addField("body", "Travel reimbursement cost is $60.");
	    //doc.addField("categories_t", "Fairy Tale, Sports");//<co id="co.solrj.dynamic.field"/>
	    solr.add(doc);//<co id="co.solrj.add"/>
	    solr.commit();//<co id="co.solrj.commit"/>
	}

	private static void AddDoc1(SolrServer solr) throws SolrServerException, IOException {
		SolrInputDocument doc = new SolrInputDocument();
	    doc.addField("docid", "12345");//<co id="co.solrj.unique"/>
	    //doc.addField("mimeType", "text/plain");
	    //doc.addField("title", "Tortoise beats Hare!  Hare wants rematch.", 5);//<co id="co.solrj.title"/>
	    Date now = new Date();
	    //doc.addField("date", DateUtil.getThreadLocalDateFormat().format(now));//<co id="co.solrj.date"/>
	    doc.addField("body", "Basketball is a sport played with a ball and two hoops.  "
	    		+ "There are 5 players on a team. "
	    		+ "Michael Jordan is the greatest basketball player of all time. ");
	    //doc.addField("categories_t", "Fairy Tale, Sports");//<co id="co.solrj.dynamic.field"/>
	    solr.add(doc);//<co id="co.solrj.add"/>
	    solr.commit();//<co id="co.solrj.commit"/>
	}
}	
	 
	   
