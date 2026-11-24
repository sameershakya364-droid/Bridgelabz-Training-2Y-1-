package src.LInkList.Assignment;

import java.util.Scanner;

public class TextEditor {
    static class Node {String text;Node prev,next;Node(String t){text=t;}}
    static Node head,tail,current;static int count;static final int LIMIT=10;static Scanner sc=new Scanner(System.in);
    static void addState(String text){Node x=new Node(text);if(current!=tail){Node p=current.next;while(p!=null){Node n=p.next;p.prev=p.next=null;p=n;}current.next=null;tail=current;count=0;for(Node q=head;q!=null;q=q.next)count++;}
        if(tail==null){head=tail=current=x;}else{x.prev=tail;tail.next=x;tail=x;current=x;}count++;
        while(count>LIMIT){Node old=head;head=head.next;head.prev=null;old.next=null;count--;}
    }
    static void undo(){if(current!=null&&current.prev!=null){current=current.prev;System.out.println("Undo successful.");}else System.out.println("Nothing to undo.");}
    static void redo(){if(current!=null&&current.next!=null){current=current.next;System.out.println("Redo successful.");}else System.out.println("Nothing to redo.");}
    static void show(){System.out.println("Current text: "+(current==null?"":current.text));}
    static void history(){for(Node p=head;p!=null;p=p.next)System.out.println((p==current?"* ":"  ")+p.text);}
    public static void main(String[] args){addState("");while(true){System.out.println("\\n1 Type/replace text 2 Undo 3 Redo 4 Show current text 5 Show history 0 Exit");int c=sc.nextInt();sc.nextLine();switch(c){case 1:System.out.print("Enter complete text state: ");addState(sc.nextLine());break;case 2:undo();break;case 3:redo();break;case 4:show();break;case 5:history();break;case 0:return;default:System.out.println("Invalid choice.");}}}
}
