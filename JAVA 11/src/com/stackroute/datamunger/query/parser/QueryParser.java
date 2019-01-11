package com.stackroute.datamunger.query.parser;

/*There are total 4 DataMungerTest file:
 * 
 * 1)DataMungerTestTask1.java file is for testing following 4 methods
 * a)getBaseQuery()  b)getFileName()  c)getOrderByClause()  d)getGroupByFields()
 * 
 * Once you implement the above 4 methods,run DataMungerTestTask1.java
 * 
 * 2)DataMungerTestTask2.java file is for testing following 2 methods
 * a)getFields() b) getAggregateFunctions()
 * 
 * Once you implement the above 2 methods,run DataMungerTestTask2.java
 * 
 * 3)DataMungerTestTask3.java file is for testing following 2 methods
 * a)getRestrictions()  b)getLogicalOperators()
 * 
 * Once you implement the above 2 methods,run DataMungerTestTask3.java
 * 
 * Once you implement all the methods run DataMungerTest.java.This test case consist of all
 * the test cases together.
 */

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QueryParser {

	private QueryParameter 	queryParameter;

	/*
	 * This method will parse the queryString and will return the object of
	 * QueryParameter class
	 */
	public QueryParameter parseQuery(String queryString) {

		queryParameter = new QueryParameter();

		queryParameter.setFileName(getFileName(queryString));
		queryParameter.setBaseQuery(getBaseQuery(queryString));
		queryParameter.setOrderByFields(getOrderByFields(queryString));
		queryParameter.setLogicalOperators(getLogicalOperators(queryString));
		queryParameter.setGroupByFields(getGroupByFields(queryString));
		queryParameter.setFields(getFields(queryString));
		queryParameter.setRestrictions(getRestrictions(queryString));

		return queryParameter;
	}

	public String[] getSplitStrings(String queryString) {

		String[] 	splitStringBasedOnSpace  =  queryString.trim().split(" ");

		return splitStringBasedOnSpace;
	}

	/*
	 * Extract the name of the file from the query. File name can be found after the
	 * "from" clause.
	 */


	public String getFileName(String queryString) {

		String  fileName = new String();

		Pattern pattern  = Pattern.compile("\\w+.csv");

		Matcher matcher = pattern.matcher(queryString);

		while (matcher.find())
		{

			fileName = matcher.group();
		}

		return fileName;
	}
	/*
	 * 
	 * Extract the baseQuery from the query.This method is used to extract the
	 * baseQuery from the query string. BaseQuery contains from the beginning of the
	 * query till the where clause
	 */
	public String getBaseQuery(String queryString) {


		String [] splitStringBasedOnSpace = getSplitStrings(queryString);

		String getBaseQuery = new String();

		for(String string: splitStringBasedOnSpace){
			if(string.contains(".csv")){
				getBaseQuery = getBaseQuery.concat(string);
				break;
			} else {
					getBaseQuery = getBaseQuery.concat(string+" ");
				}
		}

			return getBaseQuery;
	}
	/*
	 * extract the order by fields from the query string. Please note that we will
	 * need to extract the field(s) after "order by" clause in the query, if at all
	 * the order by clause exists. For eg: select city,winner,team1,team2 from
	 * data/ipl.csv order by city from the query mentioned above, we need to extract
	 * "city". Please note that we can have more than one order by fields.
	 */
	public ArrayList<String> getOrderByFields(String queryString) {
		if(queryString == null || queryString.length() == 0) {
			return new ArrayList<>();
		}
		queryString = queryString.replaceAll(","," ");

		// Replace more than one white spaces with single white space.
		queryString = queryString.trim().replaceAll(" +", " ");

		String [] splitStringBasedOnSpace = getSplitStrings(queryString);

		int 	startIndex  = 0;

		for(int i=0;i<splitStringBasedOnSpace.length;i++){

			if(splitStringBasedOnSpace[i].equalsIgnoreCase("order") &&
					splitStringBasedOnSpace[i+1].equalsIgnoreCase("by")){
				startIndex = i+2;
			}

		}

		if(startIndex == 0){
			return new ArrayList<>();
		}
		ArrayList<String>     orderByFieldsArrayList  =  new ArrayList<>();

		for(int i=startIndex; i<splitStringBasedOnSpace.length; i++){
			if(splitStringBasedOnSpace[i].equalsIgnoreCase("ASC") ||
					splitStringBasedOnSpace[i].equalsIgnoreCase("DESC")){
				continue;
			}

			if(splitStringBasedOnSpace[i].equalsIgnoreCase(";")){
				break;
			}
			orderByFieldsArrayList.add(splitStringBasedOnSpace[i]);
		}


		if(orderByFieldsArrayList.size() == 0){
			return new ArrayList<>();
		}else {
			return orderByFieldsArrayList;
		}

	}


	/*
	 * Extract the group by fields from the query string. Please note that we will
	 * need to extract the field(s) after "group by" clause in the query, if at all
	 * the group by clause exists. For eg: select city,max(win_by_runs) from
	 * data/ipl.csv group by city from the query mentioned above, we need to extract
	 * "city". Please note that we can have more than one group by fields.
	 */
	public ArrayList<String> getGroupByFields(String queryString) {

		queryString = queryString.replaceAll(","," ");
		// Replace more than one white spaces with single white space.
		queryString = queryString.trim().replaceAll(" +", " ");

		String [] splitStringBasedOnSpace = getSplitStrings(queryString);

		int 	startIndex  = 0;

		for(int i=0;i<splitStringBasedOnSpace.length;i++){

			if(splitStringBasedOnSpace[i].equalsIgnoreCase("group") &&
					splitStringBasedOnSpace[i+1].equalsIgnoreCase("by")){
				startIndex = i+2;
			}

		}

		if(startIndex == 0){
			return new ArrayList<>();
		}
		ArrayList<String>     groupByFieldsArrayList  =  new ArrayList<>();

		for(int i=startIndex; i<splitStringBasedOnSpace.length; i++){


			if(splitStringBasedOnSpace[i].equalsIgnoreCase(";") ||
					splitStringBasedOnSpace[i].equalsIgnoreCase("order")){
				break;
			}
			groupByFieldsArrayList.add(new String(splitStringBasedOnSpace[i]));
		}

		if(groupByFieldsArrayList.size() == 0){
			return new ArrayList<>();
		}else {
			return groupByFieldsArrayList;
		}


	}
	/*
	 * Extract the selected fields from the query string. Please note that we will
	 * need to extract the field(s) after "select" clause followed by a space from
	 * the query string. For eg: select city,win_by_runs from data/ipl.csv from the
	 * query mentioned above, we need to extract "city" and "win_by_runs". Please
	 * note that we might have a field containing name "from_date" or "from_hrs".
	 * Hence, consider this while parsing.
	 */

	public ArrayList<String> getFields(String queryString) {


		queryString = queryString.replaceAll(","," ");


		String [] splitStringBasedOnSpace = getSplitStrings(queryString);

		ArrayList<String> fieldStrings = new ArrayList<>();

		for(String string : splitStringBasedOnSpace){


			if(string.trim().length() > 0) {


				if (string.equals("from")) {
					break;
				} else {
					fieldStrings.add(string);
				}
			}
		}

		// we remove the string in the starting index because the string in the fieldStrings.get(0) is "select";
		// So we remove it.
		fieldStrings.remove(0);

		return fieldStrings;
	}


	/*
	 * Extract the conditions from the query string(if exists). for each condition,
	 * we need to capture the following: 1. Name of field 2. condition 3. value
	 * 
	 * For eg: select city,winner,team1,team2,player_of_match from data/ipl.csv
	 * where season >= 2008 or toss_decision != bat
	 * 
	 * here, for the first condition, "season>=2008" we need to capture: 1. Name of
	 * field: season 2. condition: >= 3. value: 2008
	 * 
	 * the query might contain multiple conditions separated by OR/AND operators.
	 * Please consider this while parsing the conditions.
	 * 
	 */
	public String getConditionsPartQuery(String queryString) {

		String [] splitStringBasedOnSpace = getSplitStrings(queryString);
		int 	stating_point = 0;
		int 	ending_point  = splitStringBasedOnSpace.length;

		for(int i=0; i<splitStringBasedOnSpace.length; i++) {

			if (splitStringBasedOnSpace[i].equalsIgnoreCase("where")) {
				stating_point = i + 1;
			} else if (splitStringBasedOnSpace[i].equalsIgnoreCase("group") &&
					splitStringBasedOnSpace[i + 1].equalsIgnoreCase("by")) {
				ending_point = i ;
				break;
			} else if (splitStringBasedOnSpace[i].equalsIgnoreCase("order") &&
					splitStringBasedOnSpace[i + 1].equalsIgnoreCase("by")) {
				ending_point = i ;
				break;
			}
		}

		String  conditionsPartString = new String();
		if(stating_point == 0){
			return null;
		}


		for (int i= stating_point; i< ending_point; i++){
			conditionsPartString = conditionsPartString.concat(splitStringBasedOnSpace[i]+" ");
		}

		return conditionsPartString.trim();
	}

	public ArrayList<Restriction> getRestrictions(String queryString) {

		String  conditionsPartString = getConditionsPartQuery(queryString);

		if(conditionsPartString == null){
			return new ArrayList<>();
		}

		String  splitConditionsPartStringUsingSpace[] =  conditionsPartString.split(" ");

		ArrayList<String>  getConditionStrings = new ArrayList<>();


		String   tempString = new String();

		for(int i=0;i< splitConditionsPartStringUsingSpace.length; i++){

			if(splitConditionsPartStringUsingSpace[i].equalsIgnoreCase("and") ||
					splitConditionsPartStringUsingSpace[i].equalsIgnoreCase("or")){

				getConditionStrings.add(tempString.trim());

				tempString = new String();

			}else {
				tempString = tempString.concat(splitConditionsPartStringUsingSpace[i]+" ");
			}

		}

		getConditionStrings.add(tempString.trim());

		if(getConditionStrings.size() == 0){
			return new ArrayList<>();
		}

		ArrayList<Restriction>  restrictions  = new ArrayList<>();

		for(int i=0;i<getConditionStrings.size();i++){

			// The split divides into strings based on =, <, > and makes ?<= means look-behind assertion  and ?= look-ahead assertion.
			String		restriction[] = getConditionStrings.get(i).split("(?<=([<>]=?|=))|(?=([<>]=?|=))");

			// Replace all single quotes with nothing
			restriction[2] = restriction[2].replaceAll("'","");
			Restriction  tempRestriction = new Restriction(restriction[0].trim(),restriction[2].trim(),restriction[1].trim());
			restrictions.add(tempRestriction);
		}

		return restrictions;
	}
	/*
	 * Extract the logical operators(AND/OR) from the query, if at all it is
	 * present. For eg: select city,winner,team1,team2,player_of_match from
	 * data/ipl.csv where season >= 2008 or toss_decision != bat and city =
	 * bangalore
	 * 
	 * The query mentioned above in the example should return a List of Strings
	 * containing [or,and]
	 */



	public ArrayList<String> getLogicalOperators(String queryString) {

		String  conditionsPartString = getConditionsPartQuery(queryString);
		if(conditionsPartString == null || conditionsPartString.length() == 0){
			return new ArrayList<>();
		}

		String  splitConditionsPartStringUsingSpace[] =  conditionsPartString.split(" ");

		ArrayList<String>  logicalOperators = new ArrayList<>();

		for(int i=0;i< splitConditionsPartStringUsingSpace.length; i++){

			if(splitConditionsPartStringUsingSpace[i].equalsIgnoreCase("and") ||
					splitConditionsPartStringUsingSpace[i].equalsIgnoreCase("or")){

				logicalOperators.add(splitConditionsPartStringUsingSpace[i]);
			}

		}

		if(logicalOperators.size()==0)
		{
			return new ArrayList<>();
		}else {
			return logicalOperators;
		}

	}


	/*
	 * Extract the aggregate functions from the query. The presence of the aggregate
	 * functions can determined if we have either "min" or "max" or "sum" or "count"
	 * or "avg" followed by opening braces"(" after "select" clause in the query
	 * string. in case it is present, then we will have to extract the same. For
	 * each aggregate functions, we need to know the following: 1. type of aggregate
	 * function(min/max/count/sum/avg) 2. field on which the aggregate function is
	 * being applied.
	 * 
	 * Please note that more than one aggregate function can be present in a query.
	 * 
	 * 
	 */

/*	   public void setAggregateFunctions(String queryString) {

		queryString = queryString.replaceAll(",", " ");
		// Replace more than one white spaces with single white space.
		queryString = queryString.trim().replaceAll(" +", " ");

		ArrayList<String> getFieldsArray = new ArrayList<>(queryParameter.getFields());

		ArrayList<String> getFieldsArrayList = new ArrayList<>();

		for(int i=0;i<getFieldsArray.size();i++){

			Pattern countPattern = Pattern.compile("count(.*)");

			Matcher countMatcher = countPattern.matcher(getFieldsArray.get(i));

			while (countMatcher.find()) {
				getFieldsArrayList.add(countMatcher.group().trim());
			}

			Pattern sumPattern = Pattern.compile("sum(.*)");

			Matcher sumMatcher = sumPattern.matcher(getFieldsArray.get(i));

			while (sumMatcher.find()) {
				getFieldsArrayList.add(sumMatcher.group().trim());
			}

			Pattern minPattern = Pattern.compile("min(.*)");

			Matcher minMatcher = minPattern.matcher(getFieldsArray.get(i));

			while (minMatcher.find()) {
				getFieldsArrayList.add(minMatcher.group().trim());
			}

			Pattern maxPattern = Pattern.compile("max(.*)");

			Matcher maxMatcher = maxPattern.matcher(getFieldsArray.get(i));

			while (maxMatcher.find()) {
				getFieldsArrayList.add(maxMatcher.group().trim());
			}


			Pattern avgPattern = Pattern.compile("avg(.*)");

			Matcher avgMatcher = avgPattern.matcher(getFieldsArray.get(i));

			while (avgMatcher.find()) {
				getFieldsArrayList.add(avgMatcher.group().trim());
			}

		}

		if(getFieldsArrayList.size() == 0){
			queryParameter.aggregateFunctions = null;
		}

		ArrayList<AggregateFunction>  aggregateFunctions = new ArrayList<>();


	}**/

}