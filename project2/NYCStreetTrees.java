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

		ArrayList<ArrayList<String>> dataTable = new ArrayList<ArrayList<String>>();
		try{   
			File file = new File(fileName);
			CSV csv = new CSV(new Scanner(file));

			for (int i = 0; i <= csv.getNumOfRows(); ++i){
				ArrayList<String> dataLine = csv.getNextRow();
				dataTable.add(dataLine);
			}
		}
		catch (FileNotFoundException e){
			System.err.println("Error: The file " + fileName + " canot be opened.");
			System.exit(0);
		}

		dataTable.remove(0);
		TreeList treeList = new TreeList();	
		for (int i=0; i<dataTable.size();i++){
			try{
				int tree_id = Integer.parseInt(dataTable.get(i).get(0));
				String status = dataTable.get(i).get(6);
				String health = dataTable.get(i).get(7);
				String spc_latin = dataTable.get(i).get(8);
				String spc_common = dataTable.get(i).get(9);
				int zipcode = Integer.parseInt(dataTable.get(i).get(25));
				String boroname = dataTable.get(i).get(29);
				double x_sp = Double.parseDouble(dataTable.get(i).get(39));
				double y_sp = Double.parseDouble(dataTable.get(i).get(40));

				Tree toAddTree = new Tree(tree_id, status, health, spc_latin, spc_common, zipcode, boroname, x_sp, y_sp);
				treeList.add(toAddTree);
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
			ArrayList<String> commonList = treeList.getMatchingCommon(userInput);
			ArrayList<String> latinList = treeList.getMatchingLatin(userInput);

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

			int nycTotalCommon = treeList.getCountByCommonName(userInput);
			int nycTotalLatin = treeList.getCountByLatinName(userInput);
			int nycTotal = nycTotalCommon + nycTotalLatin;
			int nycTotalTrees =  treeList.getTotalNumberOfTrees();
			double nycPercent = 0;
			int manTotalSpecies = 0;
			int manTotalTrees = treeList.getCountByBorough("Manhattan");
			double manPercent = 0;
			int bronxTotalSpecies = 0;
			int bronxTotalTrees = treeList.getCountByBorough("bronx");
			double bronxPercent = 0;
			int brookTotalSpecies = 0;
			int brookTotalTrees = treeList.getCountByBorough("Brooklyn");
			double brookPercent = 0;
			int queensTotalSpecies = 0;
			int queensTotalTrees = treeList.getCountByBorough("Queens");
			double queensPercent = 0;
			int statenTotalSpecies = 0;
			int statenTotalTrees = treeList.getCountByBorough("Staten Island");
			double statenPercent = 0;

			if (nycTotalCommon > 0){
				manTotalSpecies += treeList.getCountByCommonNameBorough(userInput, "manhattan");
				bronxTotalSpecies += treeList.getCountByCommonNameBorough(userInput, "bronx");
				brookTotalSpecies += treeList.getCountByCommonNameBorough(userInput, "Brooklyn");
				queensTotalSpecies += treeList.getCountByCommonNameBorough(userInput, "Queens");
				statenTotalSpecies += treeList.getCountByCommonNameBorough(userInput, "Staten Island");
			}

			if(nycTotalLatin > 0){	
				manTotalSpecies += treeList.getCountByLatinNameBorough(userInput, "manhattan");
				bronxTotalSpecies += treeList.getCountByLatinNameBorough(userInput, "bronx");
				brookTotalSpecies += treeList.getCountByLatinNameBorough(userInput, "Brooklyn");
				queensTotalSpecies += treeList.getCountByLatinNameBorough(userInput, "Queens");
				statenTotalSpecies += treeList.getCountByLatinNameBorough(userInput, "Staten Island");
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