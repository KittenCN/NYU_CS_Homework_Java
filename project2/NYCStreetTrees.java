package project2;

import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;

public class NYCStreetTrees{
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);
		String fileName = null;
		if (args.length==0){
			System.out.println("Input the csv file name:");
			fileName = sc.nextLine();
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
			File file = new File(fileName);
			CSV csv = new CSV(new Scanner(file));
			for (int i = 0; i <= csv.getNumOfRows(); ++i){
				ArrayList<String> dl = csv.getNextRow();
				dt.add(dl);
			}
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
				String status = dt.get(i).get(6);
				String health = dt.get(i).get(7);
				String spc_latin = dt.get(i).get(8);
				String spc_common = dt.get(i).get(9);
				int zipcode = Integer.parseInt(dt.get(i).get(25));
				String boroname = dt.get(i).get(29);
				double x_sp = Double.parseDouble(dt.get(i).get(39));
				double y_sp = Double.parseDouble(dt.get(i).get(40));
				Tree toAddTree = new Tree(tree_id, status, health, spc_latin, spc_common, zipcode, boroname, x_sp, y_sp);
				tl.add(toAddTree);
				} 
			catch (Exception e){
				System.err.println("Error: The file " + fileName + " is not in the correct format.");
				continue;
			}
		}	
		while (true){
			System.out.println("Enter the tree species to learn more about it (\"quit\" to stop): ");
			String userInput = sc.nextLine().toLowerCase();
			if (userInput.equals("quit")){
				break;
			}
			System.out.println("All matching species: \n");
			ArrayList<String> commonList = tl.getMatchingCommon(userInput);
			ArrayList<String> latinList = tl.getMatchingLatin(userInput);
			if(commonList != null){
				for (int i=0; i<commonList.size(); i++){
					System.out.println(commonList.get(i));
				}
			}
			if(latinList != null){
				for (int i=0; i<latinList.size(); i++){
					System.out.println(latinList.get(i));
				}
			}
			int nycTotalCommon = tl.getCountByCommonName(userInput);
			int nycTotalLatin = tl.getCountByLatinName(userInput);
			int nycTotal = nycTotalCommon + nycTotalLatin;
			int nycTotalTrees =  tl.getTotalNumberOfTrees();
			double nycPercent = 0;
			int manTotalSpecies = 0;
			int manTotalTrees = tl.getCountByBorough("Manhattan");
			double manPercent = 0;
			int bronxTotalSpecies = 0;
			int bronxTotalTrees = tl.getCountByBorough("bronx");
			double bronxPercent = 0;
			int brookTotalSpecies = 0;
			int brookTotalTrees = tl.getCountByBorough("Brooklyn");
			double brookPercent = 0;
			int queensTotalSpecies = 0;
			int queensTotalTrees = tl.getCountByBorough("Queens");
			double queensPercent = 0;
			int statenTotalSpecies = 0;
			int statenTotalTrees = tl.getCountByBorough("Staten Island");
			double statenPercent = 0;
			if (nycTotalCommon > 0){
				manTotalSpecies += tl.getCountByCommonNameBorough(userInput, "manhattan");
				bronxTotalSpecies += tl.getCountByCommonNameBorough(userInput, "bronx");
				brookTotalSpecies += tl.getCountByCommonNameBorough(userInput, "Brooklyn");
				queensTotalSpecies += tl.getCountByCommonNameBorough(userInput, "Queens");
				statenTotalSpecies += tl.getCountByCommonNameBorough(userInput, "Staten Island");
			}
			if(nycTotalLatin > 0){	
				manTotalSpecies += tl.getCountByLatinNameBorough(userInput, "manhattan");
				bronxTotalSpecies += tl.getCountByLatinNameBorough(userInput, "bronx");
				brookTotalSpecies += tl.getCountByLatinNameBorough(userInput, "Brooklyn");
				queensTotalSpecies += tl.getCountByLatinNameBorough(userInput, "Queens");
				statenTotalSpecies += tl.getCountByLatinNameBorough(userInput, "Staten Island");
			}
			nycPercent = ((double)nycTotal/(double)nycTotalTrees)*100;
			manPercent = ((double)manTotalSpecies/(double)manTotalTrees)*100;
			bronxPercent = ((double)bronxTotalSpecies/(double)bronxTotalTrees)*100;
			brookPercent = ((double)brookTotalSpecies/(double)brookTotalTrees)*100;
			queensPercent = ((double)queensTotalSpecies/(double)queensTotalTrees)*100;
			statenPercent = ((double)statenTotalSpecies/(double)statenTotalTrees)*100;
			System.out.println("\nPopularity in the city: ");
			System.out.printf("%-15s %,-5d  %1s %,d %s %.2f %s", "NYC: ", nycTotal, "(", nycTotalTrees, ")", nycPercent, "%");
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