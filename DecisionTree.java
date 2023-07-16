import java.util.Set;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DecisionTree{
  private Node root;
  public int diseasesQuantity;
  public int symptomsQuantity;
  public String[] diseasesList;
  public String[] symptomsList;

  public DecisionTree(){
    this.root = new Node();
    generateTree();
  }

  private void generateTree(){
    String fileName = "Symptoms.txt"; // IMPORTANTE: Verifique o nome do arquivo!
    try {
      File file = new File(fileName);
      Scanner scanner = new Scanner(file);

      // Leio a quantidade de doenças e sintomas.
      // Aloco um array para guardar doenças e outro para guardar os sintomas
      this.diseasesQuantity = scanner.nextInt();
      this.symptomsQuantity = scanner.nextInt();
      this.diseasesList = new String[this.diseasesQuantity];
      this.symptomsList = new String[this.symptomsQuantity];

      scanner.nextLine();
  
      // Leio as doenças e armazeno no array de doenças
      for (int i = 0; i < diseasesQuantity; i++) this.diseasesList[i] = scanner.nextLine();
      // Leio os sintomas e armazeno no array de sintomas
      for (int i = 0; i < symptomsQuantity; i++) this.symptomsList[i] = scanner.nextLine();

      // Enquanto houver linha, um ramo da árvore é criado a cada linha.
      while(scanner.hasNextLine()) buildBranch(scanner.nextLine());
      
      scanner.close();
    } catch (FileNotFoundException err){
      System.out.println("Arquivo 'Sintomas.txt' nao foi encontrado.");
      err.printStackTrace();
    }
  }

  private void buildBranch(String line){
    // Método que cria um ramo da árvore associado a uma doença.
    // OBS: Eu pretendia fazer recursivo mas não fiz porque pode dar StackOverFlow em datasets maiores

    /*
     A linha é dividida pelos espaços e armazenada em um array.
     Um lanço do indice 1 à quantidade de sintomas é executado.
     O algoritmo percorre a árvore criando os nós ainda não criados.
     Quando o laço termina, "current_node" é um nó que representa uma doença.
    */

    String[] flags = line.split("\\s+");
     
    Node currentNode = root;
    for(int i = 1; i <= this.symptomsQuantity; i++){
      if (flags[i].equals("1")){
        if (currentNode.getYesNode() == null) currentNode.setYesNode(new Node());
        currentNode = currentNode.getYesNode();
      } else {
        if (currentNode.getNoNode() == null) currentNode.setNoNode(new Node());
        currentNode = currentNode.getNoNode();
      }
    }
    // Leio o indice da doença e adiciono o nome dela ao nó folha.
    int diseaseIndex = Integer.parseInt(flags[0]) - 1;
    currentNode.addDisease(this.diseasesList[diseaseIndex]);
  }

  
  public Set<String> getDiagnosis(int[] symptoms){
    Node currentNode = root;
    int index = 0;
    while(currentNode != null && currentNode.isSymptom() == true){
      if (symptoms[index] == 0) currentNode = currentNode.getNoNode();
      if (symptoms[index] == 1) currentNode = currentNode.getYesNode();
      index++;
    }
    return currentNode.getDiseases();
  }

}