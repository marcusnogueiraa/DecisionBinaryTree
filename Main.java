import java.util.Set;
import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    DecisionTree bt = new DecisionTree();
    int numOfSymptoms = bt.symptomsQuantity;
    int numOfDiseases = bt.diseasesQuantity;

    System.out.println("[Medical consultation system]");
    System.out.println("Dataset: " + numOfDiseases + " diseases - " + numOfSymptoms + " symptoms\n");

    int[] symptomFlags = new int[numOfSymptoms];
    int option;
    do {
      System.out.printf("> Do you want to make a medical appointment? [1/0] ");
      option = sc.nextInt();
      if (option == 1){
        int index = 0;
        for(String symptom : bt.symptomsList){
          System.out.printf("> [1/0] Symptom [" + symptom + "] ");
          symptomFlags[index++] = sc.nextInt();
        }

        System.out.println();
        try {
          Set<String> diagnosticResult = bt.getDiagnosis(symptomFlags);
          for (String disease : diagnosticResult){
            System.out.println(disease);
          }
        } catch(NullPointerException err){
          System.out.println("> There is no disease for this set of symptoms! ");
        }
        System.out.println();

      } 
      if (option == 0) break;
    } while(true);

    sc.close();
  }  
}
