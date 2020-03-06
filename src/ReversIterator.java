import java.util.Iterator;
import java.util.List;

/**
 * Итератор для обратного обхода списка.
 *
 * @param <E> - тип элементов в списке
 * @author Hin7
 */

public class ReversIterator<E> implements Iterator<E> {
    private List<E> itarableList;
    private int position;

     public ReversIterator(List<E> list) {
        itarableList = list;
        position = list.size() - 1;
    }

    @Override
    public boolean hasNext() {
        return position > 0;
    }

    @Override
    public E next() {
        if (hasNext())
            return itarableList.get(position--);
        else
            return null;
    }
}
