
package xyz.codingmentor.generictree.generic;

import java.util.List;
import java.util.ArrayList;
import java.util.Objects;

public final class Bulge<T> {

    private T info;
    private List<Bulge<T>> children;
    private Bulge<T> parent;

    public Bulge() {
        super();
        children = new ArrayList<>();
    }

    public Bulge(T data) {
        this();
        setData(data);
    }

    public Bulge<T> getParent() {
        return this.parent;
    }

    public List<Bulge<T>> getChildren() {
        return this.children;
    }

    public void addChild(Bulge<T> child) {
        child.parent = this;
        children.add(child);
    }

    public void addChildAt(int index, Bulge<T> child) {
        child.parent = this;
        children.add(index, child);
    }

    public Bulge<T> getChildAt(int index) {
        return children.get(index);
    }

    public T getData() {
        return this.info;
    }
    
        public int getNumberOfChildren() {
        return getChildren().size();
    }

    public boolean hasChildren() {
        return getNumberOfChildren() > 0;
    }

    public void setChildren(List<Bulge<T>> children) {
        for (Bulge<T> child : children) {
            child.parent = this;
        }

        this.children = children;
    }
    
    public void removeChildren() {
        this.children = new ArrayList<>();
    }

    public void removeChildAt(int index) {
        children.remove(index);
    }

    public void setData(T data) {
        this.info = data;
    }

    @Override
    public String toString() {
        return "Bulge{" + "data=" + info + ", children=" + children + ", parent=" + parent + '}';
    }


    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.info);
        hash = 89 * hash + Objects.hashCode(this.children);
        hash = 89 * hash + Objects.hashCode(this.parent);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Bulge<?> other = (Bulge<?>) obj;
        if (!Objects.equals(this.info, other.info)) {
            return false;
        }
        if (!Objects.equals(this.children, other.children)) {
            return false;
        }
        if (!Objects.equals(this.parent, other.parent)) {
            return false;
        }
        return true;
    }
}