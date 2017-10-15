/**
@author Emanuel Estrada Larios - A01633605
*/

import java.util.NoSuchElementException;

class DLinkedList<T> {

  /** Clase interna Double Node
  */
  private static class DNode<T>{
    T data;
    DNode<T> next;
    DNode<T> prev;

    public DNode(T data, DNode prev, DNode next){
      this.data = data;
      this.prev = prev;
      this.next = next;
    }

  }

  private DNode<T> head;
  private DNode<T> tail;
  private int size;

  /** Constructor de la clase de listas
  * ligadas dobles
  */
  public DLinkedList(){
    this.head = null;
    this.tail = null;
    this.size = 0;
  }

  /** Revisa si la lista contiene
  * elementos y regresa true si esta vacia
  * @return True si la lista esta vacia
  */
  public boolean isEmpty(){
    return this.size == 0;
  }

  /** Regresa el tamano de la lista
  * @return Tamano de la lista
  */
  public int size(){
    return this.size;
  }

  /** Busca si la lista contiene
  * un elemento especifico
  * @return Verdadero si el elemto existe dentro de la lista
  */
  public boolean containts(T data){
    DNode tmp = this.head;
    for(int i=0; i<list.size; i++){
      if(tmp.data == data)
        return true;
      else
        tmp = tmp.next;
    }
    return false;
  }

  /** Obtiene un elemento de la lista si existe
  * @return Elemento buscado si existe
  */
  public T get(int index){
    DNode tmp = this.head;
    for(int i=0; i<index; i++){
      tmp = tmp.next;
    }

    if (tmp != null)
      return tmp;
    else
      throw new NoSuchElementException("No existe dicho elemento");
  }

  /** Regresa el numero de indice de
  * un elemento especifico si este existe,
  * si no, regresa -1
  * @return Indice del elemento
  */
  public int indextOf(T data){
    DNode tmp = this.head;
    for(int i=0; i<list.size; i++){
      if(tmp.data == data)
        return i;
      else
        tmp = tmp.next;
    }
    return -1;
  }

  /** Agrega un elemento a la lista
  * en un indice especificado si existe
  * @return True si el elemento se agrego con exito
  */
  public boolean add(int index, T item){
    DNode tmp = this.head;
    for(int i=0; i<index-1; i++){
      if(tmp != null)
        tmp = tmp.next;
      else
        return false;
    }
    tmp.data = item;
    return true;
  }

  /** Elimina un elemento de la lista
  * en un indice especifico y regresa el elemento
  * @return Elemento eliminado si existe
  */
  public T remove(int index){
    DNode tmp = this.head;
    for(int i=0; i<index; i++){
      if(tmp != null)
        tmp = tmp.next;
      else
        return null;
    }
    T data = tmp.data;
    tmp.data = null;
    return data;
  }

  /** Recorre la lista y genera un string
  * con todos sus contenidos
  * @return String con todos los elementos
  */
  public String toString(){
    DNode tmp = this.head;
    String ret = "";
    while(tmp != null){
        ret += tmp.element + "\n";
        tmp = tmp.next;
    }
    return ret;
  }

  /** Agrega un elemento al principio
  * de la lista
  */
  public void addFirst(T element) {
      DNode tmp = new DNode(element, head, null);
      if(this.head != null )
        this.head.prev = tmp;

      this.head = tmp;
      if(this.tail == null)
        this.tail = tmp;

      this.size++;
  }

  /** Agrega un elemento al final
  * de la lista
  */
  public void addLast(T element) {
      DNode tmp = new DNode(element, null, tail);
      if(this.tail != null)
        this.tail.next = tmp;

      this.tail = tmp;
      if(this.head == null)
        this.head = tmp;

      this.size++;
  }

  /** Elimina el elemento al principio
  * de la lista
  * @return Elemento eliminado
  */
  public T removeFirst() {
      if(size == 0)
        throw new NoSuchElementException();

      DNode tmp = this.head;
      this.head = head.next;
      head.prev = null;

      this.size--;
      return tmp.element;
  }

  /** Elimina el elemento al final
  * de la lista, regresa dicho elemento
  * @return Elemento eliminado
  */
  public T removeLast() {
      if (size == 0)
        throw new NoSuchElementException();

      DNode tmp = this.tail;
      this.tail = tail.prev;
      this.tail.next = null;

      this.size--;
      return tmp.element;
  }

  /** Obtiene el primer elemento de
  * la lista sin eliminarlo
  * @return Primer Elemento
  */
  public T getFirst(){
    if(this.head.next != null)
      return this.head.next;
    else
      throw new NoSuchElementException();
  }

  /** Obtiene el ultimo elemento de
  * la lista sin eliminarlo
  * @return Ultimo Elemento
  */
  public T getLast(){
    if(this.tail.prev != null)
      return this.tail.prev;
    else
      throw new NoSuchElementException();
  }

  /** Ierador que recorre la lista
  * e imprime los elementos en la
  * linea de comandos
  */
  public void iterarate(){
      DNode tmp = this.head;
      while(tmp != null){
          System.out.println(tmp.element);
          tmp = tmp.next;
      }
  }

}
