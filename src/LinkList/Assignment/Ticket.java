package src.LInkList.Assignment;

import java.util.Scanner;

public class Ticket {
    static class Node {int id,seat;String customer,movie,time;Node next;Node(int i,String c,String m,int s,String t){id=i;customer=c;movie=m;seat=s;time=t;}}
    static Node head,tail;static Scanner sc=new Scanner(System.in);
    static int size(){if(head==null)return 0;int n=0;Node p=head;do{n++;p=p.next;}while(p!=head);return n;}
    static Node find(int id){if(head==null)return null;Node p=head;do{if(p.id==id)return p;p=p.next;}while(p!=head);return null;}
    static void add(){System.out.print("Ticket ID: ");int id=sc.nextInt();sc.nextLine();if(find(id)!=null){System.out.println("Ticket ID exists.");return;}System.out.print("Customer name: ");String c=sc.nextLine();System.out.print("Movie name: ");String m=sc.nextLine();System.out.print("Seat number: ");int s=sc.nextInt();sc.nextLine();System.out.print("Booking time: ");String t=sc.nextLine();Node x=new Node(id,c,m,s,t);if(head==null){head=tail=x;x.next=x;}else{tail.next=x;tail=x;tail.next=head;}System.out.println("Ticket booked.");}
    static void remove(){System.out.print("Ticket ID: ");int id=sc.nextInt();if(head==null){System.out.println("No bookings.");return;}Node p=head,prev=tail;do{if(p.id==id){if(p==head)head=head.next;if(p==tail)tail=prev;if(p==prev){head=tail=null;}else{prev.next=p.next;tail.next=head;}System.out.println("Ticket removed.");return;}prev=p;p=p.next;}while(p!=head);System.out.println("Ticket not found.");}
    static void display(){if(head==null){System.out.println("No booked tickets.");return;}Node p=head;do{show(p);p=p.next;}while(p!=head);}
    static void show(Node p){System.out.printf("Ticket %d | %s | Movie: %s | Seat: %d | Time: %s%n",p.id,p.customer,p.movie,p.seat,p.time);}
    static void search(){sc.nextLine();System.out.print("Search by 1 Customer / 2 Movie: ");int c=sc.nextInt();sc.nextLine();System.out.print(c==1?"Customer name: ":"Movie name: ");String s=sc.nextLine();boolean f=false;if(head!=null){Node p=head;do{String value=c==1?p.customer:p.movie;if(value.equalsIgnoreCase(s)){show(p);f=true;}p=p.next;}while(p!=head);}if(!f)System.out.println("No matching reservation.");}
    public static void main(String[] args){while(true){System.out.println("\\n1 Book ticket 2 Remove ticket 3 Display tickets 4 Search customer/movie 5 Count booked tickets 0 Exit");int c=sc.nextInt();switch(c){case 1:add();break;case 2:remove();break;case 3:display();break;case 4:search();break;case 5:System.out.println("Total booked tickets: "+size());break;case 0:return;default:System.out.println("Invalid choice.");}}}
}
