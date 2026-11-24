package src.LInkList.Assignment;

import java.util.Scanner;
import java.time.LocalDate;

public class Task {
    static class Node {int id,priority;String name,due;Node next;Node(int i,String n,int p,String d){id=i;name=n;priority=p;due=d;}}
    static Node head,tail,current;static Scanner sc=new Scanner(System.in);
    static int size(){int n=0;if(head==null)return 0;Node p=head;do{n++;p=p.next;}while(p!=head);return n;}
    static void add(int pos){System.out.print("Task ID: ");int id=sc.nextInt();sc.nextLine();if(find(id)!=null){System.out.println("ID exists.");return;}
        System.out.print("Task name: ");String name=sc.nextLine();System.out.print("Priority: ");int pr=sc.nextInt();sc.nextLine();System.out.print("Due date (YYYY-MM-DD): ");String due=sc.nextLine();
        Node x=new Node(id,name,pr,due);int len=size();
        if(head==null){head=tail=current=x;x.next=x;return;}
        if(pos<=1){x.next=head;head=x;tail.next=head;return;}
        if(pos>len){tail.next=x;tail=x;tail.next=head;return;}
        Node p=head;for(int i=1;i<pos-1;i++)p=p.next;x.next=p.next;p.next=x;
    }
    static Node find(int id){if(head==null)return null;Node p=head;do{if(p.id==id)return p;p=p.next;}while(p!=head);return null;}
    static void remove(){System.out.print("Task ID: ");int id=sc.nextInt();if(head==null){System.out.println("Empty.");return;}
        Node p=head,prev=tail;do{if(p.id==id){if(p==head)head=head.next;if(p==tail)tail=prev;if(p==prev){head=tail=current=null;}else{prev.next=p.next;if(current==p)current=p.next;tail.next=head;}System.out.println("Removed.");return;}prev=p;p=p.next;}while(p!=head);System.out.println("Task not found.");
    }
    static void display(){if(head==null){System.out.println("No tasks.");return;}Node p=head;do{System.out.printf("ID %d | %s | Priority %d | Due %s%n",p.id,p.name,p.priority,p.due);p=p.next;}while(p!=head);}
    static void mainTask(){if(current==null){System.out.println("No current task.");return;}System.out.printf("Current: %d - %s%n",current.id,current.name);current=current.next;System.out.printf("Next: %d - %s%n",current.id,current.name);}
    static void search(){System.out.print("Priority: ");int v=sc.nextInt();boolean f=false;if(head!=null){Node p=head;do{if(p.priority==v){System.out.println(p.id+" "+p.name+" "+p.due);f=true;}p=p.next;}while(p!=head);}if(!f)System.out.println("No task with that priority.");}
    public static void main(String[] args){while(true){System.out.println("\\n1 Add beginning 2 Add end 3 Add position 4 Remove ID 5 View/move current 6 Display 7 Search priority 0 Exit");int c=sc.nextInt();switch(c){case 1:add(1);break;case 2:add(Integer.MAX_VALUE);break;case 3:System.out.print("Position: ");add(sc.nextInt());break;case 4:remove();break;case 5:mainTask();break;case 6:display();break;case 7:search();break;case 0:return;default:System.out.println("Invalid choice.");}}}
}
