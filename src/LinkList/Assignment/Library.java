package src.LInkList.Assignment;

import java.util.Scanner;

public class Library {
    static class Node {String title,author,genre;int id;boolean available;Node prev,next;Node(String t,String a,String g,int i,boolean v){title=t;author=a;genre=g;id=i;available=v;}}
    static Node head,tail;static Scanner sc=new Scanner(System.in);
    static int size(){int n=0;for(Node p=head;p!=null;p=p.next)n++;return n;}
    static Node find(int id){for(Node p=head;p!=null;p=p.next)if(p.id==id)return p;return null;}
    static void add(int pos){System.out.print("Book ID: ");int id=sc.nextInt();sc.nextLine();if(find(id)!=null){System.out.println("ID exists.");return;}System.out.print("Title: ");String t=sc.nextLine();System.out.print("Author: ");String a=sc.nextLine();System.out.print("Genre: ");String g=sc.nextLine();System.out.print("Available? (true/false): ");boolean v=sc.nextBoolean();Node x=new Node(t,a,g,id,v);int len=size();
        if(pos<=1||head==null){x.next=head;if(head!=null)head.prev=x;else tail=x;head=x;return;}if(pos>len){x.prev=tail;tail.next=x;tail=x;return;}Node p=head;for(int i=1;i<pos-1;i++)p=p.next;x.next=p.next;x.prev=p;p.next.prev=x;p.next=x;}
    static void remove(){System.out.print("Book ID: ");Node p=find(sc.nextInt());if(p==null){System.out.println("Not found.");return;}if(p.prev!=null)p.prev.next=p.next;else head=p.next;if(p.next!=null)p.next.prev=p.prev;else tail=p.prev;p.next=p.prev=null;System.out.println("Removed.");}
    static void search(){sc.nextLine();System.out.print("Search by 1 Title / 2 Author: ");int c=sc.nextInt();sc.nextLine();System.out.print(c==1?"Title: ":"Author: ");String s=sc.nextLine();boolean f=false;for(Node p=head;p!=null;p=p.next)if((c==1?p.title:p.author).equalsIgnoreCase(s)){show(p);f=true;}if(!f)System.out.println("No matching book.");}
    static void update(){System.out.print("Book ID: ");Node p=find(sc.nextInt());if(p==null)System.out.println("Not found.");else{System.out.print("Available? (true/false): ");p.available=sc.nextBoolean();System.out.println("Updated.");}}
    static void show(Node p){System.out.printf("ID %d | %s | %s | %s | %s%n",p.id,p.title,p.author,p.genre,p.available?"Available":"Not available");}
    static void display(boolean rev){Node p=rev?tail:head;if(p==null){System.out.println("No books.");return;}while(p!=null){show(p);p=rev?p.prev:p.next;}}
    public static void main(String[] args){while(true){System.out.println("\\n1 Add beginning 2 Add end 3 Add position 4 Remove ID 5 Search title/author 6 Update availability 7 Forward 8 Reverse 9 Count books 0 Exit");int c=sc.nextInt();switch(c){case 1:add(1);break;case 2:add(Integer.MAX_VALUE);break;case 3:System.out.print("Position: ");add(sc.nextInt());break;case 4:remove();break;case 5:search();break;case 6:update();break;case 7:display(false);break;case 8:display(true);break;case 9:System.out.println("Total books: "+size());break;case 0:return;default:System.out.println("Invalid choice.");}}}
}
