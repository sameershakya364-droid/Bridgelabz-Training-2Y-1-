package src.LInkList.Assignment;

import java.util.Scanner;

public class Student {
    static class Node {
        int roll, age; String name, grade; Node next;
        Node(int r, String n, int a, String g) { roll=r; name=n; age=a; grade=g; }
    }
    static Node head;
    static Scanner sc = new Scanner(System.in);

    static void add(int pos) {
        System.out.print("Roll number: "); int r=sc.nextInt(); sc.nextLine();
        if (find(r)!=null) { System.out.println("Roll number already exists."); return; }
        System.out.print("Name: "); String n=sc.nextLine();
        System.out.print("Age: "); int a=sc.nextInt(); sc.nextLine();
        System.out.print("Grade: "); String g=sc.nextLine();
        Node x=new Node(r,n,a,g);
        if (pos==1 || head==null) { x.next=head; head=x; return; }
        Node p=head; for(int i=1;i<pos-1 && p.next!=null;i++) p=p.next;
        x.next=p.next; p.next=x;
    }
    static Node find(int r) { for(Node p=head;p!=null;p=p.next) if(p.roll==r) return p; return null; }
    static void delete() {
        System.out.print("Roll number: "); int r=sc.nextInt();
        if(head==null) { System.out.println("List is empty."); return; }
        if(head.roll==r) { head=head.next; System.out.println("Deleted."); return; }
        Node p=head; while(p.next!=null && p.next.roll!=r) p=p.next;
        if(p.next==null) System.out.println("Student not found.");
        else { p.next=p.next.next; System.out.println("Deleted."); }
    }
    static void search() {
        System.out.print("Roll number: "); Node p=find(sc.nextInt());
        if(p==null) System.out.println("Student not found.");
        else System.out.printf("Roll: %d | Name: %s | Age: %d | Grade: %s%n",p.roll,p.name,p.age,p.grade);
    }
    static void display() {
        if(head==null) { System.out.println("No student records."); return; }
        for(Node p=head;p!=null;p=p.next)
            System.out.printf("Roll: %d | Name: %s | Age: %d | Grade: %s%n",p.roll,p.name,p.age,p.grade);
    }
    static void update() {
        System.out.print("Roll number: "); Node p=find(sc.nextInt()); sc.nextLine();
        if(p==null) System.out.println("Student not found.");
        else { System.out.print("New grade: "); p.grade=sc.nextLine(); System.out.println("Grade updated."); }
    }
    public static void main(String[] args) {
        while(true) {
            System.out.println("\\n1 Add beginning  2 Add end  3 Add position  4 Delete  5 Search  6 Display  7 Update grade  0 Exit");
            int c=sc.nextInt();
            switch(c) {
                case 1: add(1); break;
                case 2: add(Integer.MAX_VALUE); break;
                case 3: System.out.print("Position (1-based): "); add(sc.nextInt()); break;
                case 4: delete(); break; case 5: search(); break; case 6: display(); break; case 7: update(); break;
                case 0: return; default: System.out.println("Invalid choice.");
            }
        }
    }
}
