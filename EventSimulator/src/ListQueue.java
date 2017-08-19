

import java.util.Vector;
class ListQueue extends OrderedSet {

    private Vector<Comparable> elements = new Vector<>();

    @Override
    void insert(Comparable x) {
        int i = 0;
        while (i < elements.size() && ((Comparable) elements.elementAt(i)).lessThan(x)) {
            i++;
        }
        elements.insertElementAt(x,i);
     }

    @Override
     Comparable removeFirst() {
        if (elements.isEmpty()) return null;
        
        Comparable x = (Comparable) elements.firstElement();
        elements.removeElementAt(0);
        return x;
     }

    @Override
    Comparable remove(Comparable x) {
            for (int i = 0; i < elements.size(); i++) {
                if (elements.elementAt(i).equals(x)) {
                   Object y = elements.elementAt(i);
                   elements.removeElementAt(i);
                    return (Comparable) y;
                }
            }
        return null;
    }

    @Override
    public int size() {
        return elements.size();
    }
}
