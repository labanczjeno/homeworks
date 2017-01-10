
package xyz.codingmentor.generictree.generic;

import java.util.List;
import java.util.ArrayList;

public class GenericTree<T> {

    private Bulge<T> set;

    public GenericTree() {
        super();
    }

    public Bulge<T> getRoot() {
        return this.set;
    }

    public void setRoot(Bulge<T> root) {
        this.set = root;
    }

    public int numberOfBulge() {
        int bulgesNumber = 0;

        if (set != null) {
            bulgesNumber = bulgeSupport(set) + 1;
        }

        return bulgesNumber;
    }

    private int bulgeSupport(Bulge<T> bulge) {
        int bulges = bulge.getNumberOfChildren();

        for (Bulge<T> child : bulge.getChildren()) {
            bulges += bulgeSupport(child);
        }

        return bulges;
    }

    public boolean isEmpty() {
        return set == null;
    }

    public List<Bulge<T>> build(PostPreOrder traversalOrder) {
        List<Bulge<T>> returnList = null;

        if (set != null) {
            returnList = build(set, traversalOrder);
        }

        return returnList;
    }

    public List<Bulge<T>> build(Bulge<T> bulge, PostPreOrder order) {
        List<Bulge<T>> listOrder = new ArrayList<>();

        if (order == PostPreOrder.PRE_ORDER) {
            buildPreOrder(bulge, listOrder);
        } else if (order == PostPreOrder.POST_ORDER) {
            buildPostOrder(bulge, listOrder);
        }

        return listOrder;
    }

    private void buildPreOrder(Bulge<T> bulge, List<Bulge<T>> order) {
        order.add(bulge);

        for (Bulge<T> child : bulge.getChildren()) {
            buildPreOrder(child, order);
        }
    }

    private void buildPostOrder(Bulge<T> bulge, List<Bulge<T>> order) {
        for (Bulge<T> child : bulge.getChildren()) {
            buildPostOrder(child, order);
        }

        order.add(bulge);
    }

    @Override
    public String toString() {
        return "GenericTree{" + "root=" + set + '}';
    }

}