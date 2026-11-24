package src.LInkList.Assignment;

import java.util.Scanner;

public class Inventory {
    static class Node {String name;int id,qty;double price;Node next;Node(String n,int i,int q,double p){name=n;id=i;qty=q;price=p;}}
    static Node head;static Scanner sc=new Scanner(System.in);
    static int size(){int n=0;for(Node p=head;p!=null;p=p.next)n++;return n;}
    static Node find(int id){for(Node p=head;p!=null;p=p.next)if(p.id==id)return p;return null;}
    static void add(int pos){System.out.print("Item ID: ");int id=sc.nextInt();sc.nextLine();if(find(id)!=null){System.out.println("ID exists.");return;}System.out.print("Item name: ");String n=sc.nextLine();System.out.print("Quantity: ");int q=sc.nextInt();System.out.print("Price: ");double pr=sc.nextDouble();Node x=new Node(n,id,q,pr);
        if(pos<=1||head==null){x.next=head;head=x;return;}Node p=head;for(int i=1;i<pos-1&&p.next!=null;i++)p=p.next;x.next=p.next;p.next=x;}
    static void remove(){System.out.print("Item ID: ");int id=sc.nextInt();if(head==null){System.out.println("Empty.");return;}if(head.id==id){head=head.next;System.out.println("Removed.");return;}Node p=head;while(p.next!=null&&p.next.id!=id)p=p.next;if(p.next==null)System.out.println("Not found.");else{p.next=p.next.next;System.out.println("Removed.");}}
    static void update(){System.out.print("Item ID: ");Node p=find(sc.nextInt());if(p==null)System.out.println("Not found.");else{System.out.print("New quantity: ");p.qty=sc.nextInt();System.out.println("Updated.");}}
    static void search(){System.out.print("Search 1 ID / 2 Name: ");int c=sc.nextInt();boolean f=false;if(c==1){System.out.print("ID: ");Node p=find(sc.nextInt());if(p!=null){show(p);f=true;}}else{sc.nextLine();System.out.print("Name: ");String n=sc.nextLine();for(Node p=head;p!=null;p=p.next)if(p.name.equalsIgnoreCase(n)){show(p);f=true;}}if(!f)System.out.println("No matching item.");}
    static void show(Node p){System.out.printf("%s | ID %d | Qty %d | Price %.2f | Value %.2f%n",p.name,p.id,p.qty,p.price,p.qty*p.price);}
    static void display(){if(head==null)System.out.println("Inventory empty.");for(Node p=head;p!=null;p=p.next)show(p);}
    static void total(){double sum=0;for(Node p=head;p!=null;p=p.next)sum+=p.qty*p.price;System.out.printf("Total inventory value: %.2f%n",sum);}
    static void sort(){System.out.print("Sort 1 Name / 2 Price: ");int field=sc.nextInt();System.out.print("Order 1 Ascending / 2 Descending: ");boolean desc=sc.nextInt()==2;
        for(Node a=head;a!=null;a=a.next)for(Node b=a.next;b!=null;b=b.next){int cmp=field==1?a.name.compareToIgnoreCase(b.name):Double.compare(a.price,b.price);if((!desc&&cmp>0)||(desc&&cmp<0)){String n=a.name;a.name=b.name;b.name=n;int id=a.id;a.id=b.id;b.id=id;int q=a.qty;a.qty=b.qty;b.qty=q;double pr=a.price;a.price=b.price;b.price=pr;}}System.out.println("Sorted.");}
    public static void main(String[] args){while(true){System.out.println("\\n1 Add beginning 2 Add end 3 Add position 4 Remove ID 5 Update quantity 6 Search 7 Display 8 Total value 9 Sort 0 Exit");int c=sc.nextInt();switch(c){case 1:add(1);break;case 2:add(Integer.MAX_VALUE);break;case 3:System.out.print("Position: ");add(sc.nextInt());break;case 4:remove();break;case 5:update();break;case 6:search();break;case 7:display();break;case 8:total();break;case 9:sort();break;case 0:return;default:System.out.println("Invalid choice.");}}}
}
