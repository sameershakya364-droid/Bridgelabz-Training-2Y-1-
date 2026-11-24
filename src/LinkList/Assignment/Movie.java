package src.LInkList.Assignment;

import java.util.Scanner;

public class Movie {
    static class Node {
        String title,director; int year; double rating; Node prev,next;
        Node(String t,String d,int y,double r){title=t;director=d;year=y;rating=r;}
    }
    static Node head,tail; static Scanner sc=new Scanner(System.in);
    static int size(){int n=0;for(Node p=head;p!=null;p=p.next)n++;return n;}
    static void add(int pos){
        sc.nextLine(); System.out.print("Movie title: "); String t=sc.nextLine();
        System.out.print("Director: "); String d=sc.nextLine();
        System.out.print("Release year: "); int y=sc.nextInt();
        System.out.print("Rating: "); double r=sc.nextDouble();
        Node x=new Node(t,d,y,r); int len=size();
        if(pos<=1 || head==null){x.next=head;if(head!=null)head.prev=x;else tail=x;head=x;return;}
        if(pos>len){x.prev=tail;tail.next=x;tail=x;return;}
        Node p=head;for(int i=1;i<pos-1;i++)p=p.next;
        x.next=p.next;x.prev=p;p.next.prev=x;p.next=x;
    }
    static void remove(){sc.nextLine();System.out.print("Title: ");String t=sc.nextLine();Node p=head;
        while(p!=null&&!p.title.equalsIgnoreCase(t))p=p.next;
        if(p==null){System.out.println("Movie not found.");return;}
        if(p.prev!=null)p.prev.next=p.next;else head=p.next;
        if(p.next!=null)p.next.prev=p.prev;else tail=p.prev;
        p.next=p.prev=null;System.out.println("Removed.");
    }
    static void search(){sc.nextLine();System.out.print("Search by 1 Director or 2 Rating: ");int c=sc.nextInt();boolean found=false;
        if(c==1){sc.nextLine();System.out.print("Director: ");String d=sc.nextLine();for(Node p=head;p!=null;p=p.next)if(p.director.equalsIgnoreCase(d)){show(p);found=true;}}
        else if(c==2){System.out.print("Rating: ");double r=sc.nextDouble();for(Node p=head;p!=null;p=p.next)if(p.rating==r){show(p);found=true;}}
        if(!found)System.out.println("No matching movie.");
    }
    static void show(Node p){System.out.printf("%s | %s | %d | Rating %.1f%n",p.title,p.director,p.year,p.rating);}
    static void display(boolean reverse){Node p=reverse?tail:head;if(p==null){System.out.println("No movies.");return;}while(p!=null){show(p);p=reverse?p.prev:p.next;}}
    static void update(){sc.nextLine();System.out.print("Movie title: ");String t=sc.nextLine();for(Node p=head;p!=null;p=p.next)if(p.title.equalsIgnoreCase(t)){System.out.print("New rating: ");p.rating=sc.nextDouble();System.out.println("Updated.");return;}System.out.println("Movie not found.");}
    public static void main(String[] args){while(true){System.out.println("\\n1 Add beginning 2 Add end 3 Add position 4 Remove title 5 Search director/rating 6 Forward 7 Reverse 8 Update rating 0 Exit");int c=sc.nextInt();
        switch(c){case 1:add(1);break;case 2:add(Integer.MAX_VALUE);break;case 3:System.out.print("Position: ");add(sc.nextInt());break;case 4:remove();break;case 5:search();break;case 6:display(false);break;case 7:display(true);break;case 8:update();break;case 0:return;default:System.out.println("Invalid choice.");}}
    }
}
