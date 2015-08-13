/**
 * Created by rursu on 8/12/2015.
 */
public class Main {

    public static void main(String[] args) {
        Tree<Integer> t = new Tree<Integer>(1);
        System.out.println("Root data: " + t.getRoot().getData() + "\n");

        t.addNodesToParent(0, null);

        System.out.println("Old root parent data: " + t.getRoot().getChildren().get(0).getParent().getData() + " is the same with new root info: " + t.getRoot().getData());

        t.addNodesToParent(2, t.getRoot().getChildren().get(0));

        System.out.println("Display:");
        t.displayNodesWithChildrens(t.getRoot().getChildren().get(0));
        System.out.println("End of display.");

//        t.addNodesToParent(3, t.getRoot());
        t.addNodesToParentByKey(3, 0);

        System.out.println("Display:");
        t.displayNodesWithChildrens(t.getRoot());
        System.out.println("End of display.");

        System.out.println("----------------");
        Node<Integer> nod = t.getNodeByKey(2, t.getRoot(), new Node<Integer>());
        System.out.println("----------------");
        System.out.println("Nod Parinte: " + nod.getParent().getData());
        System.out.println(" Copil: " + nod.getData());
        System.out.println("----------------");

        System.out.println("Display:");
        t.display(t.getRoot());
        System.out.println("End of display.");

        t.addNodesToParentByKey(4, 3);

        System.out.println("root: " + t.getRoot().getChildren().get(1).getData());
        for (Node<Integer> x : t.getRoot().getChildren().get(1).getChildren()) {
            System.out.println("   children: " + x.getData());
        }

        System.out.println("Display:");
        t.display(t.getRoot());
        System.out.println("End of display.");

        t.addNodesToParentByKey(5, 1);
        t.addNodesToParentByKey(6, 1);

        t.addNodesToParentByKey(7, 5);

        System.out.println("Display:");
        t.displayNodesWithChildrens(t.getRoot());
        System.out.println("End of display.");

        System.out.println("Display:");
        t.displayNodesWithChildrens(t.getRoot().getChildren().get(0));
        System.out.println("End of display.");

        System.out.println("Display:");
        t.displayNodesWithChildrens(t.getRoot().getChildren().get(0).getChildren().get(1));
        System.out.println("End of display.");

        System.out.println("amdiojaiodiadiauidauindasuidnauisdnauindaidnai");
        System.out.println("Display:");
        t.displayNodesWithChildrens(t.getRoot());
        System.out.println("End of display.");

        t.removeNode(t.getNodeByKey(5, t.getRoot(), new Node<Integer>()));
        System.out.println("\nDeleting node 5...");
        System.out.println("Display:");
        t.displayNodesWithChildrens(t.getRoot());
        System.out.println("End of display.");
        System.out.println("---------------------------------------------------");

        System.out.println("Display:");
        t.displayNodesWithChildrens(t.getNodeByKey(1, t.getRoot(), new Node<Integer>()));
        System.out.println("End of display.");

//        t.removeNode(t.getRoot());
//        System.out.println("\nDeleting root...");
//        System.out.println("Display:");
//        t.display(t.getRoot());
//        System.out.println("End of display.");
        t.addNodesToParent(10, null);

        System.out.println("Display:");
        t.displayNodesWithChildrens(t.getRoot());
        System.out.println("End of display.");

        t.updateNodeInfo(t.getRoot(), 100);
        System.out.println("Display:");
        t.displayNodesWithChildrens(t.getRoot());
        System.out.println("End of display.");


//        System.out.println("Answer: " + t.isUpper(t.getRoot().getChildren().get(0).getChildren().get(0).getChildren().get(0), t.getRoot().getChildren().get(0).getChildren().get(1)));

        System.out.println("Display:");
        t.displayNodesWithChildrens(t.getRoot());
        System.out.println("End of display.");
    }
}
