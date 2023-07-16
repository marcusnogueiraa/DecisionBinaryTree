# **DecisionBinaryTree**
This algorithm made in java was developed to study the binary tree concept and apply it to a usual implementation.

## **Dataset Pattern**
  In this algorithm, a tree is created based on reading a file "Symptoms.txt" which is a dataset that has the number of diseases
and symptoms, names of diseases and symptoms, as well as the combination of symptoms that result in a disease.
  The dataset pattern must follow a pattern, in the first line there must be two integer values ​​x and y, which are equivalent to
the number of diseases and symptoms, respectively, separated by a space. Then there should be x lines representing the name of the diseases and y lines representing the name of the symptoms. After that, the remaining lines should follow this pattern:
  A number from 1 to x that represents the ID of the disease that that set of symptoms refers to, followed by y values ​​0 or 1
separated by a space. The value 1 means that that symptom is valid for that disease, while 0 means that it is not.</br>
**Example of initial lines**
```
X Y
disease1
disease2
[...]
diseaseX
symptom1
symptom2
[...]
symptomX
```
Now see an example of a set of symptoms that result in a disease with ID 4, considering a dataset with 6 symptoms.
```
4 1 0 1 0 1 1
```
This line means that, when receiving an entry to which the user answers yes to the first symptom, no to the second, yes to the third, no to the fourth, yes to the fifth and sex, he has the disease ID 4. For more examples see the Symptoms.txt file.

## **How does the tree work?**
  The leaves of trees with a height equal to the number of symptoms + 1 are considered diseases, there is a flag on the nodes to
facilitate identification. The algorithm generates the tree according to the set of symptoms present in the dataset, this allows creating an algorithm that works with gigantic datasets, as only the cases that result in a disease are built. It is worth emphasizing that a set of diseases can result in only one disease, more than one or no disease. In addition, the fact of storing the resulting diseases in a set data structure allows a set of repeated symptoms not to result in the same disease more than once (it is a prevention for possible errors in the dataset). If the tree is created entirely without using the symptom sets, it would have complexity 2^(n-1) where n is the number of symptoms, which would result in a much higher complexity time.

## **How to customize the dataset**
You can change the dataset at will as long as you respect the rules established above, any change in this is necessary to change the file "DecisionTree.java".

## **Important**
The MoreSymptoms.txt file has more symptoms, diseases and clusters, you can paste its content in "Symptoms.txt if you want to test the efficiency of the tree generation algorithm.