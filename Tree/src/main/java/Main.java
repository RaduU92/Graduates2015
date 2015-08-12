/**
 * Created by rursu on 8/12/2015.
 */
public class Main {

    public static void main(String[] args) {
        Tree<Integer> t = new Tree<Integer>(1);
        System.out.println("Root data: " + t.getRoot().getData() + "\n");

        t.addNodesToParent(0, null);

        System.out.println("Old root parent data: " + t.getRoot().getChildren().get(0).getParent().getData() + " is the same with new root info: " + t.getRoot().getData());

//        t.addNodesToParentByKey(2, 0);
//        System.out.println("root: " + t.getRoot().getData());
//        for (Node<Integer> x : t.getRoot().getChildren()) {
//            System.out.println("   children: " + x.getData());
//        }

        t.addNodesToParent(2, t.getRoot());

        System.out.println("\nDisplay:\n");
        t.display(t.getRoot());
        System.out.println("\nEnd of display\n");

//Este o problema cand adaug un copil la vechiul root...!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
//        t.addNodesToParent(3, t.getRoot().getChildren().get(0));
        t.addNodesToParent(3, t.getRoot().getChildren().get(1));

        System.out.println("\nDisplay:\n");
        t.display(t.getRoot());
        System.out.println("\nEnd of display\n");

        System.out.println("root: " + t.getRoot().getChildren().get(1).getData());
        for (Node<Integer> x : t.getRoot().getChildren().get(1).getChildren()) {
            System.out.println("   children: " + x.getData());
        }

        t.addNodesToParent(4, t.getRoot().getChildren().get(1).getChildren().get(0));
//        System.out.println("afadadfaniadb: " + t.getRoot().getChildren().get(0).getData());

        System.out.println("\nDisplay:\n");
        t.display(t.getRoot());
        System.out.println("\nEnd of display\n");

        System.out.println("root: " + t.getRoot().getChildren().get(1).getChildren().get(0).getData());
        for (Node<Integer> x : t.getRoot().getChildren().get(1).getChildren().get(0).getChildren()) {
            System.out.println("   children: " + x.getData());
        }

        System.out.println("\nDisplay:\n");
        t.display(t.getRoot().getChildren().get(0));
        System.out.println("\nEnd of display\n");

        t.addNodesToParent(10, null);
        System.out.println("\nDisplay:\n");
        t.display(t.getRoot());
        System.out.println("\nEnd of display\n");

        t.addNodesToParent(5, t.getRoot().getChildren().get(0).getChildren().get(1));
//        System.out.println(t.getRoot().getChildren().get(0).getChildren().get(1).getData());

        System.out.println("\nDisplay:\n");
        t.display(t.getRoot());
        System.out.println("\nEnd of display\n");

        System.out.println("\nDisplay:\n");
        t.display(t.getRoot().getChildren().get(0).getChildren().get(1));
        System.out.println("\nEnd of display\n");

        System.out.println("root: " + t.getRoot().getChildren().get(0).getChildren().get(1).getData());
        for (Node<Integer> x : t.getRoot().getChildren().get(0).getChildren().get(1).getChildren()) {
            System.out.println("   children: " + x.getData());
        }

//        Aici merge sa adaug dupa ce modific radacina...
        t.addNodesToParent(6, t.getRoot().getChildren().get(0));
        System.out.println("\nDisplay:\n");
        t.display(t.getRoot().getChildren().get(0));
        System.out.println("\nEnd of display\n");

//        Aici merge sa adaug copil la radacina
        t.addNodesToParent(7, t.getRoot());
        System.out.println("root: " + t.getRoot().getData());
        for (Node<Integer> x : t.getRoot().getChildren()) {
            System.out.println("   children: " + x.getData());
        }

        System.out.println("\nDisplay:\n");
        t.display(t.getRoot());
        System.out.println("\nEnd of display\n");
//      Modific radacina
        t.addNodesToParent(8, null);
        System.out.println("root: " + t.getRoot().getData());
        for (Node<Integer> x : t.getRoot().getChildren()) {
            System.out.println("   children: " + x.getData());
        }

        System.out.println("\nDisplay:\n");
        t.display(t.getRoot());
        System.out.println("\nEnd of display\n");

        t.addNodesToParent(9, t.getRoot().getChildren().get(0).getChildren().get(0).getChildren().get(0));

        System.out.println("root: " + t.getRoot().getChildren().get(0).getChildren().get(0).getChildren().get(0).getData());
        for (Node<Integer> x : t.getRoot().getChildren().get(0).getChildren().get(0).getChildren().get(0).getChildren()) {
            System.out.println("   children: " + x.getData());
        }

        System.out.println("\nDisplay:\n");
        t.display(t.getRoot());
        System.out.println("\nEnd of display\n");
    }
}
