package ru.geekbrains;

public interface MyList<T>{

   T get(int p);

   void add(T element);

   void insert(int index, T element);

   void delete(int p);
}
