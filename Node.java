import java.util.Set;
import java.util.HashSet;

public class Node {
  private Boolean isSymptom; // Flag que define se é um sintoma (true) ou doença (false)
  private Set<String> diseases; // Set de doenças (só é alocado caso seja uma doença)
  private Node yesNode; // RightNode (Resposta Sim)
  private Node noNode; // LeftNode (Resposta Nao)

  Node(){
    this.isSymptom = true;
    this.yesNode = null;
    this.noNode = null;
  }

  public Set<String> getDiseases(){
    return this.diseases;
  }

  public void addDisease(String diseaseName){
    /*
    (Ao usar esse método, o nó passa a ser considerado uma doença)
    É verificado se o Nó é um sintoma.
    Caso seja, seto como doença e aloco um Set para armazenar as doenças.
    Adiciono o nome da doença ao set de doenças.
    */ 
    if (isSymptom){
      isSymptom = false;
      this.diseases = new HashSet<String>();
    } 

    this.diseases.add(diseaseName);
  }

  public Node getYesNode(){
    return this.yesNode;
  }

  public Node getNoNode(){
    return this.noNode;
  }

  public void setYesNode(Node newYesNode){
    this.yesNode = newYesNode;
  }

  public void setNoNode(Node newNoNode){
    this.noNode = newNoNode;
  }

  public boolean isSymptom(){
    return this.isSymptom;
  }
}
