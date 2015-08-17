import java.util.ArrayList;

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

        t.addNodesToParent(10, null);

        System.out.println("Display:");
        t.displayNodesWithChildrens(t.getRoot());
        System.out.println("End of display.");

        t.updateNodeInfo(t.getRoot(), 100);
        System.out.println("Display:");
        t.displayNodesWithChildrens(t.getRoot());
        System.out.println("End of display.");

        t.changeParentOfNode(t.getNodeByKey(6, t.getRoot(), new Node<Integer>()), t.getNodeByKey(2, t.getRoot(), new Node<Integer>()));

        System.out.println("Display:");
        t.displayNodesWithChildrens(t.getRoot());
        System.out.println("End of display.");

        t.changeParentOfNode(t.getNodeByKey(2, t.getRoot(), new Node<Integer>()), t.getNodeByKey(3, t.getRoot(), new Node<Integer>()));

        System.out.println("Display:");
        t.displayNodesWithChildrens(t.getRoot());
        System.out.println("End of display.");

        t.changeParentOfNode(t.getNodeByKey(0, t.getRoot(), new Node<Integer>()), t.getNodeByKey(2, t.getRoot(), new Node<Integer>()));

        System.out.println("Display====:");
        t.displayNodesWithChildrens(t.getRoot());
        System.out.println("End of display.");

        System.out.println(t.getRoot().getData()); //100
        System.out.println(t.getRoot().getChildren().get(0).getData()); //2
        System.out.println(t.getRoot().getChildren().get(0).getChildren().get(0).getData()); //6
        System.out.println(t.getRoot().getChildren().get(0).getChildren().get(1).getData()); //0
        System.out.println(t.getRoot().getChildren().get(0).getChildren().get(1).getChildren().get(0).getData()); //1
        System.out.println(t.getRoot().getChildren().get(0).getChildren().get(1).getChildren().get(1).getData()); //3
        System.out.println(t.getRoot().getChildren().get(0).getChildren().get(1).getChildren().get(1).getChildren().get(0).getData()); //4
        System.out.println("\n\n");
        System.out.println(t.getRoot().getChildren().get(0).getParent().getData()); //100
        System.out.println(t.getRoot().getChildren().get(0).getChildren().get(0).getParent().getData()); //2
        System.out.println(t.getRoot().getChildren().get(0).getChildren().get(1).getParent().getData()); //2
        System.out.println(t.getRoot().getChildren().get(0).getChildren().get(1).getChildren().get(0).getParent().getData()); //0
        System.out.println(t.getRoot().getChildren().get(0).getChildren().get(1).getChildren().get(1).getParent().getData()); //0
        System.out.println(t.getRoot().getChildren().get(0).getChildren().get(1).getChildren().get(1).getChildren().get(0).getParent().getData()); //3

        t.addNodesToParentByKey(8, 1);
        t.addNodesToParentByKey(9, 8);
        System.out.println("Display:");
        t.displayNodesWithChildrens(t.getRoot());
        System.out.println("End of display.");

        t.changeParentOfNode(t.getRoot().getChildren().get(0).getChildren().get(1).getChildren().get(0), t.getRoot().getChildren().get(0).getChildren().get(1).getChildren().get(1).getChildren().get(0));

        System.out.println("Display:");
        t.displayNodesWithChildrens(t.getRoot());
        System.out.println("End of display.");
//        System.out.println("\nTest:");
//        System.out.println(t.getRoot().getChildren().get(0).getChildren().get(1).getChildren().get(0).getChildren().get(0).getChildren().get(0).getChildren().get(0).getChildren().get(0).getParent().getParent().getParent().getParent().getParent().getParent().getParent().getData()); // 9
//        System.out.println(t.getRoot().getChildren().get(0).getChildren().get(1).getChildren().get(0).getChildren().get(0).getChildren().get(0).getChildren().get(0).getParent().getParent().getParent().getParent().getParent().getParent().getData()); // 8
//        System.out.println(t.getRoot().getChildren().get(0).getChildren().get(1).getChildren().get(0).getChildren().get(0).getChildren().get(0).getParent().getParent().getParent().getParent().getParent().getData()); // 1
//        System.out.println(t.getRoot().getChildren().get(0).getChildren().get(1).getChildren().get(0).getChildren().get(0).getParent().getParent().getParent().getParent().getData()); // 4
//        System.out.println(t.getRoot().getChildren().get(0).getChildren().get(1).getChildren().get(0).getParent().getParent().getParent().getData()); // 3
//        System.out.println(t.getRoot().getChildren().get(0).getChildren().get(1).getParent().getParent().getData()); // 0
//        System.out.println(t.getRoot().getChildren().get(0).getChildren().get(0).getParent().getParent().getData()); // 6
//        System.out.println(t.getRoot().getChildren().get(0).getParent().getData()); // 2
//        System.out.println(t.getRoot().getData()); // 100

        t.addNodesToParentByKey(1, 9);
        System.out.println("Display:");
        t.displayNodesWithChildrens(t.getRoot());
        System.out.println("End of display.");
//        System.out.println(t.getRoot().getChildren().get(0).getChildren().get(1).getChildren().get(0).getChildren().get(0).getChildren().get(0).getChildren().get(0).getChildren().get(0).getChildren().get(0).getData());
//        System.out.println(t.getNodeByKey(1, t.getRoot(), new Node<Integer>()).getParent().getData());

        t.addNodesToParent(10, t.getRoot().getChildren().get(0).getChildren().get(1).getChildren().get(0).getChildren().get(0).getChildren().get(0).getChildren().get(0).getChildren().get(0).getChildren().get(0));
        System.out.println("Display:");
        t.displayNodesWithChildrens(t.getRoot());
        System.out.println("End of display.");

        ArrayList<Node<Integer>> nodes = t.configurationBottomUp(t.getRoot().getChildren().get(0).getChildren().get(1).getChildren().get(0).getChildren().get(0).getChildren().get(0).getChildren().get(0).getChildren().get(0).getChildren().get(0).getChildren().get(0), t.getRoot().getChildren().get(0));
        System.out.println("bottom-up:");
        for (Node<Integer> n : nodes) {
            System.out.print(n.getData() + " ");
        }

        ArrayList<Node<Integer>> nodes2 = t.configurationTopDown(t.getRoot().getChildren().get(0), t.getRoot().getChildren().get(0).getChildren().get(1).getChildren().get(0).getChildren().get(0).getChildren().get(0).getChildren().get(0).getChildren().get(0).getChildren().get(0).getChildren().get(0));
        System.out.println("\ntop-down:");
        for (Node<Integer> n : nodes2) {
            System.out.print(n.getData() + " ");
        }
    }
}
