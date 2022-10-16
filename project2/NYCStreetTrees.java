package project2;

import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;

public class NYCStreetTrees{
	public static ArrayList<String> readCSV(String strLine) {
		char crNext;
		boolean FlagQ = false;
		boolean FlagE = false;
		int intLen = strLine.length();
		ArrayList<String> ans = new ArrayList<String>();
		StringBuffer sbNext = new StringBuffer();
		for (int i = 0; i < intLen; i++) {
			crNext = strLine.charAt(i);
			if (crNext == '"' || crNext == '\u201C' || crNext =='\u201D') { 
				if (FlagQ) {
					FlagQ = false;
					FlagE = false; 
				}
				else {
					FlagQ = true; 
					FlagE = true; 
				}
			}
			else if (Character.isWhitespace(crNext)) {
				if  ( FlagQ == true || FlagE == true ) {
					sbNext.append( crNext );
				}
				else  { 
					continue;
				}
			}
			else if ( crNext == ',') {
				if (FlagQ == true) 
					sbNext.append(crNext);
				else { 
					FlagE = false; 
					ans.add(sbNext.toString());
					sbNext = new StringBuffer();
				}
			}
			else {
				sbNext.append(crNext);
				FlagE = true; 
			}

		}
		if (!sbNext.toString().equals("")) {
			ans.add(sbNext.toString().trim());
		}
		return ans;
	}
	public static void main(String[] args) throws FileNotFoundException {
		String fileName = null;
		if (args.length==0){
			System.out.println("Input the csv file name:");
			Scanner sc = new Scanner(System.in);
			fileName = sc.nextLine();
			sc.close();
			File file = new File(fileName);
			if (!file.exists()){
				System.err.println("File " + fileName + " can not be found!");
				System.exit(0);
			}
		}
		else{
			fileName = args[0];
			File file = new File(fileName);
			if (!file.exists()){
				System.err.println("File " + fileName + " can not be found!");
				System.exit(0);
			}
		}
		ArrayList<ArrayList<String>> dt = new ArrayList<ArrayList<String>>();
		try{   
			Scanner fs = new Scanner(new File(fileName));
			while (fs.hasNextLine()){
				ArrayList<String> dl = readCSV(fs.nextLine());
				dt.add(dl);
			}
			fs.close();
			
		}
		catch (FileNotFoundException e){
			System.err.println("Error: The file " + fileName + " canot be opened.");
			System.exit(0);
		}
		dt.remove(0);
		TreeList tl = new TreeList();	
		for (int i=0; i<dt.size();i++){
			try{
				int tree_id = Integer.parseInt(dt.get(i).get(0));
				int dbh = Integer.parseInt(dt.get(i).get(3));
				String status = dt.get(i).get(6);
				String health = dt.get(i).get(7);
				String species = dt.get(i).get(9);
				int zipcode = Integer.parseInt(dt.get(i).get(25));
				String boroname = dt.get(i).get(29);
				double x_sp = Double.parseDouble(dt.get(i).get(39));
				double y_sp = Double.parseDouble(dt.get(i).get(40));
				Tree toAddTree = new Tree(tree_id, dbh, status, health, species, zipcode, boroname, x_sp, y_sp);
				tl.add(toAddTree);
				} 
			catch (Exception e){
				System.err.println("Error: The file " + fileName + " is not in the correct format.");
				continue;
			}
		}
		Scanner sc = new Scanner(System.in);	
		while (true){
			System.out.println("Enter the tree species to learn more about it (\"quit\" to stop): ");
			String userInput = sc.nextLine().toLowerCase();
			if (userInput.equals("quit")){
				break;
			}
			System.out.println("All matching species: \n");
			ArrayList<String> mlist = tl.getMatchingSpecies(userInput);
			for(int i = 0; i<mlist.size(); i++){
				System.out.println(mlist.get(i));
			}
			int nycTotalSpecies = tl.getCountByTreeSpecies(userInput);
			int nycTotalTrees = tl.getTotalNumberofTrees();
			double nycPercent = ((double)nycTotalSpecies/(double)nycTotalTrees)*100;
			int manTotalSpecies = tl.getCountByTreeSpeciesBorough(userInput, "manhattan");
			int manTotalTrees = tl.getCountByBorough("Manhattan");
			double manPercent = ((double)manTotalSpecies/(double)manTotalTrees)*100;
			int bronxTotalSpecies = tl.getCountByTreeSpeciesBorough(userInput, "bronx");
			int bronxTotalTrees = tl.getCountByBorough("bronx");
			double bronxPercent = ((double)bronxTotalSpecies/(double)bronxTotalTrees)*100;
			int brookTotalSpecies = tl.getCountByTreeSpeciesBorough(userInput, "Brooklyn");
			int brookTotalTrees = tl.getCountByBorough("Brooklyn");
			double brookPercent = ((double)brookTotalSpecies/(double)brookTotalTrees)*100;
			int queensTotalSpecies = tl.getCountByTreeSpeciesBorough(userInput, "Queens");
			int queensTotalTrees = tl.getCountByBorough("Queens");
			double queensPercent = ((double)queensTotalSpecies/(double)queensTotalTrees)*100;
			int statenTotalSpecies = tl.getCountByTreeSpeciesBorough(userInput, "Staten Island");
			int statenTotalTrees = tl.getCountByBorough("Staten Island");
			double statenPercent = ((double)statenTotalSpecies/(double)statenTotalTrees)*100;
			System.out.println("\nPopularity in the city: ");
			System.out.printf("%-15s %,-5d  %1s %,d %s %.2f %s", "NYC: ", nycTotalSpecies, "(", nycTotalTrees, ")", nycPercent, "%");
			System.out.println("");
			System.out.printf("%-15s %,-5d  %s %,d %s %.2f %s", "Manhattan: ", manTotalSpecies, "(", manTotalTrees, ")", manPercent, "%");
			System.out.println("");
			System.out.printf("%-15s %,-5d  %s %,d %s %.2f %s", "Bronx: ", bronxTotalSpecies, "(", bronxTotalTrees, ")", bronxPercent, "%");
			System.out.println("");
			System.out.printf("%-15s %,-5d  %s %,d %s %.2f %s", "Brooklyn: ", brookTotalSpecies, "(", brookTotalTrees, ")", brookPercent, "%");
			System.out.println("");
			System.out.printf("%-15s %,-5d  %s %,d %s %.2f %s", "Queens: ", queensTotalSpecies, "(", queensTotalTrees, ")", queensPercent, "%");
			System.out.println("");
			System.out.printf("%-15s %,-5d  %s %,d %s %.2f %s", "Staten Island: ", statenTotalSpecies, "(", statenTotalTrees, ")", statenPercent, "%");
			System.out.println("\n");
		}
		sc.close();
	}
}