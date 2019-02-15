package ru.java;
@SuppressWarnings("unchecked")
public class ArrList<T> implements ICollection<T> {
    private T[] items;
    private int size;

    public ArrList() {
        items = (T[]) new Object[10];
    }

        public ArrList(int length){
            items = (T[]) new Object[length];
        }
    @Override
        public void add(Object item) {
        if (item == null)
            return;

        if (size >= items.length) {
            resize();

        }

        items[size] = (T) item;
        size++;
        System.out.printf("Item '%s' is in the bag.\n", item);

    }


    private void resize(){
            T [] temp = (T[]) new String[items.length *3/2 +1];
            for (int i= 0; i < items.length; i++){
                temp[i] =  items[i];

            }
                items = temp;
    }
    @Override
    public boolean contains(Object s) {
        if (s == null) {
            return false;
        }
        for (int i = 0; i < size; i++){
            if (s.equals(items[i])) {
                return true;
            }
        }
      return false;
    }

    public void print() {
        for (T item : items) {
            System.out.println(item);
        }
    }

    public int getSize() {
        return size;
    }

    @Override
    public int remove(int index) {
        return 0;
    }

  public Object size() {
      return null;
  }
}
