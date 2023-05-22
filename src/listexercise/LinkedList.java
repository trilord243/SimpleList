
package listexercise;

class LinkedList {
    private Node head;
    private Node tail;
    private int size;
    
    
    //Constructor 
    public LinkedList(){
        this.head=null;
        this.tail=null;
        this.size=0;
    
    }
    
    // Getters and setters

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public Node getTail() {
        return tail;
    }

    public void setTail(Node tail) {
        this.tail = tail;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    
    
    public boolean isEmpty(){
        return getHead()==null;
    

    }
    
    //Inserts 
    
    public Node append(Object element){
        Node newNode=new Node(element);
        if(!isEmpty()){
              
        getTail().setNext(newNode);
        setTail(newNode);
        }else{
         setTail(newNode);
         setHead(newNode);
        
        
        
        }size++;
        return newNode;
    }
   
   public Node preappend(Object element){
       Node newNode=new Node(element);
       if(isEmpty()){
           setHead(newNode);
           setTail(newNode);
       
       }else{
           newNode.setNext(getHead());
           setHead(newNode);
       
       
       }size++;
       return newNode;
   
   }
   
   //Print 
   
   public void print(){
       
       if (isEmpty()){
           System.out.println("No hay nada xd");
       
       }else{
         Node aux=getHead();
       while(aux!=null){
           System.out.println(aux.getElement());
           aux=aux.getNext();
       
       }
       
       }

   }
 
   
   //Buscar index
   public Node get(int index){
        Node aux=getHead();
        for(int i=0;i<index;i++){
            aux=aux.getNext();
        }
        System.out.println(aux.getElement());
        return aux;
       
     
   
   
   }
   
   // Hacer reverso
   public void reverse(){
       Node before=null,curr=getHead(),after=curr.getNext();
       setHead(getTail());
       setTail(curr);
       
       for(int i=0; i<size;i++){
           after=curr.getNext();
           curr.setNext(before);
           before=curr;
           curr=after;
       
       
       }
   
   }
   //Ordenar ascendente
   public void sort(){
       Node curr=getHead(),index=null;
       Object temp;
       
       while(curr!=null){
           index=curr.getNext();
           while(index!=null){
               if( (int)curr.getElement()>(int) index.getElement() ){
                   temp=curr.getElement();
                   curr.setElement(index.getElement());
                   index.setElement(temp);
               }
               index=index.getNext();
           
           
           }
           curr=curr.getNext();
       
       }
   
   
   }
   //Borrar por elemento 
   public void deleteIndex(int n){
      while(head!=null && (int) head.getElement()==n  ){
          head=head.getNext();
      
      
      }
      
      Node current=head;
      
      while( current!=null && current.getNext()!=null ){
          
          if( (int) current.getNext().getElement()== n){
              current.setNext(current.getNext().getNext());
              if(current.getNext()==null){
              tail=current;
          
          }
                
          }else{
          
          current=current.getNext();
          }
          
          
          
      }
      
  }
   
   //frecuencia de numero
   
   private int countFrequency(Object element) {
    int count = 0;
    Node current = getHead();
    while (current != null) {
        if (current.getElement() == element) {
            count++;
        }
        current = current.getNext();
    }
    return count;
}
  public LinkedList frequency() {
    LinkedList frequencyList = new LinkedList();
    
    Node current = getHead();
    while (current != null) {
        int count = countFrequency(current.getElement());
        frequencyList.append(count);
        current = current.getNext();
    }
    
    return frequencyList;
}




  //suma todos los valores de una lista ;D
   public  int suma(LinkedList list) {
        int sum = 0;
        Node current = list.getHead();
        while (current != null) {
            sum += (int) current.getElement();
            current = current.getNext();
        }
        return sum;
    }
   
   //Eliminar al principio
   public Node deleteFirst(){
       if(size==0||size==1 ){
           setHead(null);
           setTail(null);
           return null;
       
       }else{
           Node aux=getHead();
           setHead(getHead().getNext());
           aux.setNext(null);
           return aux;
       
       }
   
   }
   //Eliminar al final 
   public Node deleteEnd(){
      if(size==0 || size==1){
          setHead(null);
          setTail(null);
          return null;
      
      }else{
          Node aux=getHead();
          while(aux.getNext().getNext()!=null){
              aux=aux.getNext();
          
          }
          Node temp=aux.getNext();
          aux.setNext(null);
          setTail(aux);
          
          return temp;
          
          
          
      
      }
   
   
   }
   
   //concatena 2 listas 
   
   public void concatenar(LinkedList lista) {
        if (lista.isEmpty()) {
            return;
        }
        
        if (this.isEmpty()) {
            this.setHead(lista.getHead());
            this.setTail(lista.getTail());
            this.setSize(lista.getSize());
            return;
        }
        
        this.getTail().setNext(lista.getHead());
        this.setTail(lista.getTail());
        this.setSize(this.getSize() + lista.getSize());
    }
   
   
   //Ordena por impares 
 public LinkedList ordenarParesImpares(LinkedList lista) {
    LinkedList listaOrdenada = new LinkedList();
    LinkedList listaPares = new LinkedList();
    LinkedList listaImpares = new LinkedList();

    Node current = lista.getHead();

    // Separar los números pares e impares en listas diferentes
    while (current != null) {
        int elemento = (int) current.getElement();
        if (elemento % 2 == 0) { // Es par
            listaPares.append(elemento);
        } else { // Es impar
            listaImpares.append(elemento);
        }
        current = current.getNext();
    }

    // Ordenar las listas de números pares e impares en orden ascendente
    listaPares.sort();
    listaImpares.sort();

    // Concatenar las listas de pares e impares en la lista ordenada final
    listaOrdenada.concatenar(listaPares);
    listaOrdenada.concatenar(listaImpares);

    return listaOrdenada;
}
 
 //Elimina repeditos 
 
    public void eliminarRepetidos() {
           if (isEmpty() || size == 1) {
               return;
           }

           Node current = head;
           while (current != null) {
               Node runner = current;
               while (runner.getNext() != null) {
                   if ((int) runner.getNext().getElement() == (int) current.getElement()) {
                       runner.setNext(runner.getNext().getNext());
                       size--;
                   } else {
                       runner = runner.getNext();
                   }
               }
               current = current.getNext();
           }
       }


    //Es palindromo? 
    
    public boolean esPalindromo() {
        if (isEmpty()) {
            return false;
        }
        
        LinkedList reversedList = new LinkedList();
        Node current = head;
        
        // Copiar la lista original en una lista nueva y revertirla
        while (current != null) {
            reversedList.preappend(current.getElement());
            current = current.getNext();
        }
        
        // Comparar la lista original con la lista invertida
        Node originalNode = head;
        Node reversedNode = reversedList.getHead();
        
        while (originalNode != null && reversedNode != null) {
            if (originalNode.getElement() != reversedNode.getElement()) {
                return false;
            }
            originalNode = originalNode.getNext();
            reversedNode = reversedNode.getNext();
        }
        
        return true;
    }
    //Suma las 3 listas de forma ordenada sin importar su tamaño 
    public LinkedList sumOfThreeLists(LinkedList lista1, LinkedList lista2, LinkedList lista3) {
    LinkedList resultList = new LinkedList(); // Lista para almacenar el resultado

    // Determinar la longitud máxima de las listas
    int maxLength = Math.max(Math.max(lista1.getSize(), lista2.getSize()), lista3.getSize());

    // Recorrer las listas
    for (int i = 0; i < maxLength; i++) {
        int sum = 0;

        // Sumar los elementos si existen en las listas
        if (i < lista1.getSize()) {
            sum += (int) lista1.get(i).getElement();
        }
        if (i < lista2.getSize()) {
            sum += (int) lista2.get(i).getElement();
        }
        if (i < lista3.getSize()) {
            sum += (int) lista3.get(i).getElement();
        }

        // Añadir la suma a la lista resultante
        resultList.append(sum);
    }

    return resultList;
}
    
    //Esta solo obtiene los multiplos 
    public LinkedList obtenerMultiplos(int numero) {
        LinkedList listaMultiplos = new LinkedList();
        
        Node current = head;
        while (current != null) {
            int elemento = (int) current.getElement();
            if (elemento % numero == 0) {
                listaMultiplos.append(elemento);
            }
            current = current.getNext();
        }
        
        return listaMultiplos;
    }
    
    //Cambiar valores 
     public void cambiarOcurrencias(int numero) {
        Node current = head;
        while (current != null) {
            if ((int) current.getElement() == numero) {
                current.setElement(-999);
            }
            current = current.getNext();
        }
    }
     //cambiar valores De N a V 
     public void cambiarOcurrencias(int N, int V) {
        Node current = head;
        while (current != null) {
            if ((int) current.getElement() == V) {
                current.setElement(N);
            }
            current = current.getNext();
        }
    }

  
}
