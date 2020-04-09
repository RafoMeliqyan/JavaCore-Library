package storage;


import model.Lesson;

public class DynamicArrayForBook {
    private Lesson[] array = new Lesson[10];
    private int size = 0;

    public void add(Lesson value) {
        if (size == array.length) {
            extend();
        }
        array[size++] = value;
    }

    private void extend() {
        Lesson[] arr = new Lesson[array.length + 10];
        System.arraycopy(array,0,arr,0,array.length);
        array = arr;
    }

    public Lesson get(int index) {
        return array[index];
    }

    public void print(){
        for (int i = 0; i < size; i++) {
            System.out.println(array[i]);
        }
    }

    public Lesson getBookByTitle(String title){
        for (int i = 0; i < size; i++) {
            if (title.equals(array[i].getTitle())) {
                return array[i];
            }
        }
        return null;
    }
}
