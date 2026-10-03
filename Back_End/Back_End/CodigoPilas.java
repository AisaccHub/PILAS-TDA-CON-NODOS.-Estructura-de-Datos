package Back_End;

     class Node{
    public int datos;
    public Node next;
    
    public Node(int x){
    datos = x;
    next = null;
    }
    }
    public class CodigoPilas{
        public Node top;
        int count;
    
        public CodigoPilas(){
            top = null;
            count = 0;
    
        }
    
        void push (int x){
            Node temp = new Node(x);
            temp.next = top;
            top = temp;
            count ++;
    
        }
        int pop(){
    if (top == null){
        System.out.println("Mis datos explotados");
        return -1;
    }
    Node temp = top;
        top = top.next;
        int val = temp.datos;
    
        count--;
        return val;
        }
        public int peek(){
            if(top == null){
                System.out.println("Mis datos estan vacios");
            return -1;
            }
        return top.datos;
        }
        public boolean isEmpty(){
            return top == null;
        }
        public int size(){
            return count;
        }
        public static void main(String[] args){
            CodigoPilas  st = new CodigoPilas();
            st.push(1);
            st.push(2);
            st.push(3);
            st.push(4);
            st.push(5);
            st.push(6);
    
        System.out.println("Datos Explotados, " + st.pop());
        System.out.println("Datos Movidos arriba, " + st.peek());
        System.out.println("Estos Datos estan Vacios?, " + (st.isEmpty() ? "Si" : "Nel")); 
        System.out.println("Cantidad de datos, " + st.size());
    
        }
    
    
    }

