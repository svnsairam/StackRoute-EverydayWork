package com.stackroute.datamunger.query.parser;

import java.util.ArrayList;
import java.util.List;

/* 
 * This class will contain the elements of the parsed Query String such as conditions,
 * logical operators,aggregate functions, file name, fields group by fields, order by
 * fields, Query Type
 * */

public class QueryParameter {

	private 	String		 				queryString;
	private		String						file;
	private 	String						baseQuery;
	private 	List<String>				fields;
	private 	String						QUERY_TYPE;
	private 	ArrayList<Restriction>			restrictions;
	private 	ArrayList<String>				logicalOperators;
	private 	ArrayList<AggregateFunction>		aggregateFunctions;
	private 	ArrayList<String>				orderByFields;
	private 	ArrayList<String>				groupByFields;


	public String getFileName() {
		return this.file;
	}

	public String getBaseQuery() {

		return this.baseQuery;
	}

	public ArrayList<Restriction> getRestrictions() {
		return this.restrictions;
	}

	public List<String> getLogicalOperators() {
		return this.logicalOperators;
	}

	public List<String> getFields() {
		return this.fields;
	}

	public List<AggregateFunction> getAggregateFunctions() {
		return this.aggregateFunctions;
	}

	public List<String> getGroupByFields() {
		return this.groupByFields;
	}

	public List<String> getOrderByFields() {
		System.out.println(this.orderByFields);
		return this.orderByFields;
	}

	public void setFileName(String fileName) {
		this.file = fileName;
	}

	public void setBaseQuery(String baseQuery) {

		this.baseQuery = baseQuery;
	}

	public  void  setRestrictions(List<Restriction> restrictions) {

		ArrayList<Restriction>  restrictionArrayList =  new ArrayList<>();

		for (int i=0;i<restrictions.size();i++)
		{
			String name = restrictions.get(i).getName();
			String value = restrictions.get(i).getValue();
			String condition = restrictions.get(i).getCondition();

			restrictionArrayList.add(new Restriction(name,value,condition));
		}
		 this.restrictions = restrictionArrayList;
	}

	public void setLogicalOperators(ArrayList<String> logicalOperators) {
		 this.logicalOperators = logicalOperators;
	}

	public void setFields(List<String> fields) {
		 this.fields = fields;
	}

	public void setAggregateFunctions( ArrayList<AggregateFunction>  aggregateFunctions) {
		 this.aggregateFunctions = aggregateFunctions;
	}

	public void setGroupByFields(ArrayList<String> groupByFields) {
		 this.groupByFields = groupByFields;
	}

	public void setOrderByFields(ArrayList<String> orderByFields) {
		 this.orderByFields = orderByFields;
	}
}